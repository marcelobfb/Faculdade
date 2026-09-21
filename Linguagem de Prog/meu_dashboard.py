from pathlib import Path

import pandas as pd
import streamlit as st


st.set_page_config(page_title="Dashboard de Vendas", layout="wide")
st.title("Dashboard de Vendas")


@st.cache_data  
def carregar_dados(caminho: str = "vendas.csv") -> pd.DataFrame:
   
    arquivo = Path(__file__).parent / caminho
    df = pd.read_csv(arquivo, parse_dates=["data"])
    df["receita"] = df["quantidade"] * df["preco_unitario"]
    return df


def formatar_brl(valor: float) -> str:
    """Formata 1234567.5 como 'R$ 1.234.567,50'."""
    texto = f"{valor:,.2f}"
    return "R$ " + texto.replace(",", "X").replace(".", ",").replace("X", ".")


df = carregar_dados()


st.sidebar.title("Filtros")

lista_de_categorias = sorted(df["categoria"].unique())
categorias_escolhidas = st.sidebar.multiselect(
    "Selecione as Categorias",
    options=lista_de_categorias,
    default=lista_de_categorias,  
)


df_filtrado = df[df["categoria"].isin(categorias_escolhidas)]

if df_filtrado.empty:
    st.warning("Selecione ao menos uma categoria na barra lateral.")
    st.stop()


receita_calculada = df_filtrado["receita"].sum()
total_pedidos = df_filtrado["pedido_id"].nunique()

col1, col2 = st.columns([1, 1])

with col1:
    st.metric(label="Receita Total", value=formatar_brl(receita_calculada))

with col2:
    st.metric(label="Total de Pedidos", value=f"{total_pedidos:,}".replace(",", "."))

aba1, aba2 = st.tabs(["Evolução Mensal", "Tabela de Dados"])

with aba1:
    
    dados_agrupados = (
        df_filtrado.assign(mes=df_filtrado["data"].dt.to_period("M").dt.to_timestamp())
        .groupby("mes")["receita"]
        .sum()
    )
    st.area_chart(dados_agrupados)

with aba2:
    st.dataframe(df_filtrado, use_container_width=True)  
    st.download_button(
        label="Baixar recorte em CSV",
        data=df_filtrado.to_csv(index=False).encode("utf-8"),
        file_name="vendas_filtradas.csv",
        mime="text/csv",
    )
