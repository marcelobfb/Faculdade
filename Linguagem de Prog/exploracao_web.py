from io import StringIO

import pandas as pd
import requests
from bs4 import BeautifulSoup

HEADERS = {"User-Agent": "ExploracaoWebPython/1.0 (projeto academico)"}
TIMEOUT = 10


def titulo(texto):
    print(f"\n{'=' * 60}\n{texto}\n{'=' * 60}")


titulo("NÍVEL 1 — Requisições GET, parâmetros e cabeçalhos")

resposta = requests.get(
    "https://jsonplaceholder.typicode.com/posts",
    params={"userId": 2},
    headers=HEADERS,
    timeout=TIMEOUT,
)
posts = resposta.json()

print("Status HTTP:", resposta.status_code)
print("URL final:", resposta.url)
print("Posts retornados:", len(posts))
print("Primeiro post:", posts[0]["title"])


titulo("NÍVEL 2 — JSON, erros e arquivos binários")


def baixar_seguro(url, **kwargs):
    try:
        resposta = requests.get(url, headers=HEADERS, timeout=TIMEOUT, **kwargs)
        resposta.raise_for_status()
        return resposta
    except requests.exceptions.HTTPError as erro:
        print(f"Não foi possível acessar {url}: o servidor respondeu {erro.response.status_code}.")
    except requests.exceptions.Timeout:
        print(f"Tempo esgotado ao acessar {url}. Tente novamente mais tarde.")
    except requests.exceptions.ConnectionError:
        print(f"Falha de conexão ao acessar {url}. Verifique sua internet.")
    except requests.exceptions.RequestException as erro:
        print(f"Erro inesperado ao acessar {url}: {erro}")
    return None


ceps = ["01310100", "30130010", "20040020"]
enderecos = []

for cep in ceps:
    resposta = baixar_seguro(f"https://viacep.com.br/ws/{cep}/json/")
    if resposta is None:
        continue
    dados = resposta.json()
    if dados.get("erro"):
        print(f"CEP {cep} não encontrado.")
        continue
    enderecos.append(dados)

df_ceps = pd.DataFrame(enderecos)
print(df_ceps[["cep", "logradouro", "bairro", "localidade", "uf"]].to_string(index=False))

print("\nTeste de erro HTTP (404 proposital):")
baixar_seguro("https://jsonplaceholder.typicode.com/posts/99999")

resposta = baixar_seguro("https://picsum.photos/400/400")
if resposta is not None:
    with open("imagem_aleatoria.jpg", "wb") as arquivo:
        arquivo.write(resposta.content)
    print(f"\nImagem salva: imagem_aleatoria.jpg ({len(resposta.content)} bytes)")


titulo("NÍVEL 3 — Webscraping e ética")

URL_SITE = "https://books.toscrape.com/"

resposta = requests.get(URL_SITE + "robots.txt", headers=HEADERS, timeout=TIMEOUT)
print("robots.txt — status:", resposta.status_code)
if resposta.status_code == 200:
    print(resposta.text)
else:
    print("Nenhuma restrição publicada em robots.txt para este site de estudos.")

resposta = requests.get(URL_SITE, headers=HEADERS, timeout=TIMEOUT)
resposta.raise_for_status()
resposta.encoding = "utf-8"

soup = BeautifulSoup(resposta.text, "html.parser")
livros = []

for artigo in soup.select("article.product_pod")[:5]:
    titulo_livro = artigo.find("h3").find("a")["title"]
    preco = artigo.find("p", class_="price_color").get_text(strip=True)
    livros.append({"titulo": titulo_livro, "preco": preco})

df_livros = pd.DataFrame(livros)
print("\n", df_livros.to_string(index=False), sep="")

df_livros.to_csv("livros.csv", index=False, encoding="utf-8")
print("\nArquivo salvo: livros.csv")

url_wikipedia = "https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population"
resposta = requests.get(url_wikipedia, headers=HEADERS, timeout=TIMEOUT)
resposta.raise_for_status()

tabelas = pd.read_html(StringIO(resposta.text))
df_paises = tabelas[0]

print(f"\nTabelas encontradas na página: {len(tabelas)}")
print("Shape da primeira tabela:", df_paises.shape)
print(df_paises.head().to_string(index=False))
