--ex1
select nomecliente,genero
from cliente;

--ex2
select nomeproduto,preco
from produto;

--ex3
select idcompra, dtcompra
from compras;

--ex4
select nomecliente,cidade,estadocivil
from cliente;

--ex5
select * from cliente;

--ex6
select nomecliente,estadocivil
from cliente 
order by nomecliente asc;

--ex7
select nomeproduto,preco
from produto
order by preco desc;

--ex8
select nomecliente,cidade,estado
from cliente
order by cidade,estado asc;

--ex9
select distinct estado
from cliente;

--ex10
select distinct dtcompra
from compras;

--ex11
select nomeproduto,preco
from produto
where preco > 5;

--ex12
select nomecliente,estadocivil,genero
from cliente
where genero='F';

--ex13
select nomecliente,cidade
from cliente
where cidade='Rio de Janeiro';

--ex14
select nomecliente,dtnascimento
from cliente
where dtnascimento<'2004-01-01';

--ex15
select distinct idcliente, dtcompra
from compras
where dtcompra between '2021-01-01' and '2021-12-31';

--ex16
select idcliente,dtcompra
from compras
where extract(year from dtcompra)=2020;

-- Ex17
select nomecliente
from cliente
where nomecliente like 'A%';

-- Ex18
SELECT nomecliente
FROM cliente
WHERE nomecliente LIKE '%ana%';

-- Ex19
SELECT nomecliente, estadocivil
FROM cliente
WHERE estado = 'Rio de Janeiro' or estado = 'São Paulo' or estado='Minas Gerais' or estado='Espírito Santo';

-- Ex20
SELECT nomecliente, 
CASE estadocivil
WHEN 'S' THEN 'Solteiro'
WHEN 'C' THEN 'Casado'
WHEN 'D' THEN 'Divorciado'
WHEN 'V' THEN 'Viúvo'
ELSE 'Desconhecido'
END AS estado_civil_extenso
FROM cliente;

-- Ex21
SELECT 
    produto.nomeproduto,
    marca.nomemarca
FROM 
    produto
JOIN 
    marca ON produto.idmarca = marca.idmarca;

-- Ex22
SELECT 
    cliente.nomecliente,
    produto.nomeproduto
FROM 
    cliente
JOIN 
    compras ON cliente.idcliente = compras.idcliente
JOIN 
    produto ON compras.idproduto = produto.idproduto;


-- Ex23
SELECT 
    cliente.nomecliente,
    loja.nomeloja,
    loja.uf AS estado_loja
FROM 
    cliente
JOIN 
    compras ON cliente.idcliente = compras.idcliente
JOIN 
    loja ON compras.idloja = loja.idloja
WHERE 
    compras.qtd > 40;


-- Ex24
SELECT 
    produto.nomeproduto,
    produto.preco,
    marca.nomemarca
FROM 
    produto
INNER JOIN 
    marca ON produto.idmarca = marca.idmarca;


-- Ex25
SELECT 
    marca.nomemarca,
    compras.dtcompra,
    compras.qtd
FROM 
    compras
INNER JOIN 
    produto ON compras.idproduto = produto.idproduto
INNER JOIN 
    marca ON produto.idmarca = marca.idmarca;


-- Ex26
SELECT 
    cliente.nomecliente,
    produto.nomeproduto,
    compras.qtd
FROM 
    cliente
INNER JOIN 
    compras ON cliente.idcliente = compras.idcliente
INNER JOIN 
    produto ON compras.idproduto = produto.idproduto;


-- Ex27
SELECT 
    cliente.nomecliente,
    compras.idcompra
FROM 
    cliente
LEFT JOIN 
    compras ON cliente.idcliente = compras.idcliente;


-- Ex28
SELECT 
    marca.nomemarca,
    produto.nomeproduto
FROM 
    produto
RIGHT JOIN 
    marca ON produto.idmarca = marca.idmarca;


-- Ex29
SELECT 
    cliente.nomecliente,
    marca.nomemarca
FROM 
    cliente
FULL OUTER JOIN 
    compras ON cliente.idcliente = compras.idcliente
FULL OUTER JOIN 
    produto ON compras.idproduto = produto.idproduto
FULL OUTER JOIN 
    marca ON produto.idmarca = marca.idmarca;
