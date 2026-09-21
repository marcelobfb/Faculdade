import numpy as np


def titulo(texto):
    print("\n" + "=" * 64)
    print(texto)
    print("=" * 64)



titulo("PARTE 1 | NÍVEL 1 — Faturamento semanal e filtros")

# Passo 1
pecas_vendidas = np.array([150, 120, 90, 210, 300, 250, 180])
print("Peças vendidas:", pecas_vendidas)

faturamento = pecas_vendidas * 50
print("Faturamento (R$):", faturamento)
print("Faturamento total (R$):", faturamento.sum())

mascara_pico = pecas_vendidas > 200
print("Máscara booleana:", mascara_pico)
print("Vendas nos dias de pico:", pecas_vendidas[mascara_pico])
print("Posição dos dias de pico (0 = 1º dia):", np.where(mascara_pico)[0])

titulo("PARTE 1 | NÍVEL 2 — Múltiplas filiais e falhas de sistema")


vendas = np.array(
    [
        [200, 220, np.nan, 250],  
        [150, 180, 160, 190], 
        [300, 310, 290, 330],  
    ]
)
print("Matriz de vendas:\n", vendas)
print("Shape:", vendas.shape)

total_por_loja = vendas.sum(axis=1)
print("\nTotal por loja com sum(axis=1):", total_por_loja)
print("  -> a Loja A virou nan: um único nan contamina a soma da linha.")
print("Total por loja com nansum(axis=1):", np.nansum(vendas, axis=1))


print("\nMédia normal (contaminada):", vendas.mean())
media_geral = np.nanmean(vendas)
print("Média diária geral da rede (nanmean):", round(media_geral, 2))

meta = np.where(vendas >= 200, "Meta Atingida", "Abaixo")
print("\nMeta por loja/dia:\n", meta)
print("  -> repare: nan >= 200 é False, então a falha da Loja A aparece como 'Abaixo'.")

meta_v2 = np.where(
    np.isnan(vendas),
    "Sem dado",
    np.where(vendas >= 200, "Meta Atingida", "Abaixo"),
)
print("Versão que distingue a falha de sistema:\n", meta_v2)

titulo("PARTE 1 | NÍVEL 3 — Categorização e destaques de marketing")


rng = np.random.default_rng(42)
departamentos = ["Eletrônicos", "Roupas", "Casa"]
vendas_sorteadas = rng.choice(departamentos, size=50)
print("5 primeiras vendas:", vendas_sorteadas[:5])

categorias, contagens = np.unique(vendas_sorteadas, return_counts=True)
for cat, qtd in zip(categorias, contagens):
    print(f"  {cat:<12} {qtd} vendas")
print("Soma das contagens:", contagens.sum())

campanhas = np.array([12000, 45000, 23000, 89000, 31000])
idx_campea = np.argmax(campanhas)
print(f"\nCampanha campeã: índice {idx_campea} (Campanha {idx_campea + 1}) "
      f"com R$ {campanhas[idx_campea]:,}")



titulo("PARTE 2 | NÍVEL 1 — Sequências e tipagem")

dias = np.arange(1, 31)
print("Dias do mês:", dias)

metas = np.linspace(20000, 30000, 5)
print("Metas (R$):", metas)

estoque = np.array([10.5, 20.1, 30.9])
print("Estoque original:", estoque)
print("astype(int):", estoque.astype(int), " <- 30.9 virou 30")
print("Arredondando antes:", np.round(estoque).astype(int))

ultimos_5_invertidos = dias[-5:][::-1]
print("Últimos 5 dias (invertidos):", ultimos_5_invertidos)

# ---------------------------------------------------------------- Nível 2 ----
titulo("PARTE 2 | NÍVEL 2 — Redimensionamento e proteção de dados")


visitas_12_meses = np.array([1200, 1350, 1280, 1500, 1620, 1580,
                             1710, 1690, 1800, 1950, 2100, 2300])
trimestres = visitas_12_meses.reshape(4, 3)
print("Visitas por trimestre (4x3):\n", trimestres)

primeiro_semestre = trimestres[:2]  
segundo_semestre = trimestres[2:]
ano_completo = np.vstack([primeiro_semestre, segundo_semestre])
print("\nApós vstack (4x3):\n", ano_completo)
print("Igual à matriz original?", np.array_equal(ano_completo, trimestres))


q1_view = ano_completo[0]  
q1_copia = ano_completo[0].copy()  

q1_copia[:] = q1_copia * 1.10  
print("\n1º trimestre projetado (cópia):", q1_copia)
print("Original intacto:              ", ano_completo[0])

q1_view[0] = 0 
print("Após alterar a VIEW, original ficou:", ano_completo[0], " <- a pegadinha")
ano_completo[0, 0] = 1200  


plano = ano_completo.ravel()
print("\nravel():", plano, "| shape:", plano.shape)



titulo("PARTE 2 | NÍVEL 3 — Ranking, broadcasting e sistemas lineares")

notas = np.array([85, 92, 78, 95, 88])
ordem_crescente = np.argsort(notas)
print("argsort (crescente):", ordem_crescente)
print("Notas ordenadas:", notas[ordem_crescente])


ordem_decrescente = np.argsort(-notas) 
ranking = np.empty_like(ordem_decrescente)
ranking[ordem_decrescente] = np.arange(1, len(notas) + 1)
for aluno, (nota, pos) in enumerate(zip(notas, ranking)):
    print(f"  Aluno {aluno}: nota {nota} -> {pos}º lugar")


precos_base = np.array([100.0, 250.0, 400.0])
descontos = np.array([0.05, 0.10, 0.20])

precos_coluna = precos_base[:, np.newaxis]
print("\nPreços como coluna, shape:", precos_coluna.shape)


tabela_precos = precos_coluna * (1 - descontos)
print("Preço final (linhas = produtos, colunas = 5%, 10%, 20%):\n", tabela_precos)

A = np.array([[2, 1],
              [1, -1]])
b = np.array([500, 100])
placa, sensor = np.linalg.solve(A, b)
print(f"\nPlaca robótica: R$ {placa:.2f} | Sensor: R$ {sensor:.2f}")
print("Verificação A @ x == b?", np.allclose(A @ np.array([placa, sensor]), b))
