-- Exemplo 1
SELECT MAX(preco) AS maiorPreco
FROM produto;

-- Exemplo 2
SELECT MIN(qtd) AS minPreco
FROM compras;

-- Exemplo 3
SELECT ROUND(AVG(qtd), 2) AS mediaQtd
FROM compras;

-- Exemplo 4
SELECT COUNT(idcliente) AS qtdRJ
FROM cliente
WHERE estado = 'Rio de Janeiro';

-- Exemplo 5
SELECT ROUND(AVG(preco), 2) AS mediaPreco
FROM produto;

-- Exemplo 6
SELECT COUNT(*) AS qtdBomPrato
FROM compras AS co
INNER JOIN produto AS pr
    ON co.idproduto = pr.idproduto
INNER JOIN marca AS ma
    ON pr.idmarca = ma.idmarca
WHERE ma.nomemarca = 'Bom Prato';

-- Exemplo 7
SELECT SUM(co.qtd)
FROM compras AS co
INNER JOIN loja AS lo
    ON co.idloja = lo.idloja
WHERE lo.nomeloja = 'Vale Verde';

-- Exemplo 8
SELECT SUM(qtd) AS qtdMG
FROM produto AS pdt
INNER JOIN compras AS cm
    ON pdt.idproduto = cm.idproduto
INNER JOIN loja AS lj
    ON cm.idloja = lj.idloja
WHERE lj.uf = 'MG';

-- Exemplo 9
SELECT SUM(co.qtd) AS qtdMacarrao
FROM compras AS co
INNER JOIN produto AS pr
    ON co.idproduto = pr.idproduto
WHERE pr.nomeproduto = 'Macarrão';

-- Exemplo 10
SELECT SUM(qtd) AS qtdTotal, COUNT(*) AS qtdVenda
FROM compras AS cm;

-- Exemplo 11
SELECT estado, COUNT(*) AS clientes
FROM cliente
GROUP BY estado
ORDER BY clientes DESC;

-- Exemplo 12
SELECT COUNT(*) AS qtdLoja, uf
FROM loja
GROUP BY uf
ORDER BY qtdLoja DESC;

-- Exemplo 13
SELECT ma.nomemarca, COUNT(*) AS total
FROM marca AS ma
INNER JOIN produto AS pr
    ON ma.idmarca = pr.idmarca
GROUP BY ma.nomemarca
ORDER BY total DESC;

-- Exemplo 14
SELECT ma.nomemarca, SUM(co.qtd * pr.preco) AS total
FROM compras AS co
INNER JOIN produto AS pr
    ON co.idproduto = pr.idproduto
INNER JOIN marca AS ma
    ON ma.idmarca = pr.idmarca
GROUP BY ma.nomemarca
ORDER BY total DESC;

-- Exemplo 15
SELECT pr.nomeproduto, ROUND(AVG(co.qtd), 2) AS media
FROM compras AS co
INNER JOIN produto AS pr
    ON co.idproduto = pr.idproduto
GROUP BY pr.nomeproduto
ORDER BY media DESC;

-- Exemplo 16
SELECT lo.nomeloja, SUM(co.qtd * pr.preco) AS faturamento
FROM compras AS co
INNER JOIN loja AS lo
    ON co.idloja = lo.idloja
INNER JOIN produto AS pr
    ON pr.idproduto = co.idproduto
GROUP BY lo.nomeloja
ORDER BY faturamento DESC;

-- ex17
SELECT cl.nomecliente, SUM(co.qtd) AS total
	FROM compras AS co
	INNER JOIN cliente AS cl
		ON co.idcliente = cl.idcliente
	GROUP BY cl.nomecliente
	ORDER BY total DESC;

-- ex18
SELECT cidade, COUNT(*) AS qtdclientes
	FROM cliente AS cli
	GROUP BY cidade
	ORDER BY qtdclientes DESC
	LIMIT 5;

-- ex19
-- ex20
-- ex21
-- ex22