//*operadores de atribuição
// var a = Number(prompt("Digite um numero"));
// a += 5;
// alert("a soma dos valores = " + a);
// document.write("a soma dos valores = " + a);
// console.log("a soma dos valores = " + a);

// var b = Number(prompt("digite um numero"));
// b -= a;
// alert("a subtração dos valores = " + b);
// document.write("<br>a subtração dos valores= " + b);
// console.log("a subtração dos valores = " + b);

// alert(`A soma dos valores = ${a}`);
// document.write(`<br>A soma dos valores =${a}`);
// console.log(`A soma dos valores = ${a}`);

// a *= b;
// alert(`A multiplicação dos valores = ${a}`);
// document.write(`<br>A multiplicação dos valores =${a}`);
// console.log(`a multiplicação dos valores = ${a}`);

// var a1 = Number(prompt("Digite um numero "));
// var b1 = Number(prompt("Digite um numero "));
// alert(`A soma de ${a1} + ${b1} = ${a1 + b1}`);
// document.write(`<br>A soma de ${a1} + ${b1} = ${a1 + b1}`);
// console.log(`a soma de ${a1}+${b1}=${a1 + b1}`);

//*incremento(++) e decremento(--)
// num1=20
// document.write(num1++)//pos incrementa, incrementa mas n mostra o valor incrementado
// document.write(`<br> ${num1}`)
// document.write(`<br> ${++num1}`)//pre incremento, incrementa e mostra o valor incrementado
// document.write(`<br> O valor de ${num1} incrementado é igual a ${++num1}`)
// num2=10
// document.write(`<br>${num2--}`)
// document.write(`<br>${num2}`)
// document.write(`<br>${--num2}`)
// document.write(`<br> O valor de ${num2} decrementado é igual a ${--num2}`)

//*operadores de comparação ==, ===
//== --> verifica se os dados são iguais
//=== --> verifica se os valores são iguais
// x=10
// y='10'
// document.write(`O valor de ${x} é igual o valor de ${y} ? ${x==y}`)
// document.write(`<br> O valor de ${x} é igual o valor de ${y} ? ${x===y}`)
// x1=+(prompt('Digite um numero'))
// y1=prompt('Digite um numero')
// document.write(`<br>O valor ${x1} é igual ${y1}? ${x1==y1}`)
// document.write(`<br>O valor ${x1} é igual ${y1}? ${x1===y1}`)

//*operador diferente !=, !==
// o != --> verifica se os dados são diferentes
// o !== --> verifica se os valores são diferentes
// x=10
// y='10'
// document.write(`O valor de ${x} é diferente do valor de ${y} ? ${x!=y}`)
// document.write(`<br> O valor de ${x} possui identidade diferente de ${y} ? ${x!==y}`)
// x1=+(prompt('Digite um numero'))
// y1=prompt('Digite um numero')
// document.write(`<br>O valor ${x1} é diferente do ${y1}? ${x1!=y1}`)
// document.write(`<br>O valor ${x1} possui identidade diferente de ${y1}? ${x1!==y1}`)

//*operadores relacionais >,>=,<,<=
// n1=+(prompt('Digite um numero'))
// n2=parseFloat(prompt('Digite um numero'))
// document.write(`<br>${n1} > ${n2} ? ${n1>n2}`)

//*operadores logicos &&(e),||(ou),!(negação)
// console.log(20 < 40 && 30 > 5);
// console.log(20 < 40 && 30 < 5);
// console.log(20 < 40 || 30 < 5);
// console.log(2 < 3);
// console.log(!(2 < 3));
// console.log(!!(2 < 3));

//*biblioteca math
//potencia --> pow(valor da base, valor da potencia)
// x=10
// y=2
// p=Math.pow(x,y)
// document.write(`${x} elevado a ${y} é ${p}`)
// x3=+(prompt("Digite um numero"))
// y3=+(prompt("Digite o valor da potencia"))
// document.write(`<br>O numero ${x3} elevado a ${y3} = ${Math.pow(x3,y3)}`)

//*sqrt() --> raiz quadrada
//.toFixed() --> é igual %.2f
// x=+(prompt("Digite um numero"))
// r=Math.sqrt(x)
// document.write(`<br>a raiz quadrada de ${x} é ${r.toFixed(2)}`)

//*cbrt() --> raiz cubica
// x=+(prompt("Digite um numero"))
// c=Math.cbrt(x)
// document.write(`<br>A raiz cubica de ${x} é ${c.toFixed(2)}`)

//*round() --> arredonda matematicamente
//ceil() --> arredonda para cima
//floor() --> arredonda para baixo
// x=+(prompt("Digite um numero"))
// document.write(`<br>${x} arrendondado matematicamente é ${Math.round(x)}`) 
// document.write(`<br>${x} arrendondado para cima é ${Math.ceil(x)}`) 
// document.write(`<br>${x} arrendondado para baixo é ${Math.floor(x)}`) 

//* random() --> gera numeros aleatorios entre 0 e 1
// document.write(`<br>O numero aleatorio entre 0 e 1 ${Math.random()}`)
// document.write(`<br>O numero aleatorio entre 0 e 1 ${Math.random().toFixed(0)}`)
// document.write(`<br>O numero aleatorio entre 0 e 1 ${(Math.random()*50).toFixed(0)}`)

//*1
// x=+(prompt("Digite um número Inteiro: "))
// y=+(prompt("Digite um número Inteiro: "))
// z=+(prompt("Digite um número Real: "))
// a=(x*2)*(y/2)
// b=(x*3)+z
// c=(Math.pow(z,3))
// document.write(`<br>o produto do dobro do primeiro com metade do segundo é ${a}`)
// document.write(`<br>a soma do triplo do primeiro com o terceiro é ${b}`)
// document.write(`<br>o terceiro elevado ao cubo é ${c}`)

//*2
// x=+(prompt("Digite um número: "))
// document.write(`<br>O número foi ${x} `)

//*3
// x=+(prompt("Digite o valor em metros: "))
// document.write(`<br>${x} Metros em centimetos é ${x*100} e em milimetros é ${x*1000}`)

//*4
// F=+(prompt("Digite a temperatura em Fahrenheit: "))
// C = 5 * ((F-32) / 9)
// document.write(`<br> ${F} graus Fahrenheit são ${C.toFixed(2)} graus Celsius`)

//*5
// x=+(prompt("Digite um numero: "))
// document.write(`<br>${x}x 1 = ${x*1}`)
// document.write(`<br>${x}x 2 = ${x*2}`)
// document.write(`<br>${x}x 3 = ${x*3}`)
// document.write(`<br>${x}x 4 = ${x*4}`)
// document.write(`<br>${x}x 5 = ${x*5}`)
// document.write(`<br>${x}x 6 = ${x*6}`)
// document.write(`<br>${x}x 7 = ${x*7}`)
// document.write(`<br>${x}x 8 = ${x*8}`)
// document.write(`<br>${x}x 9 = ${x*9}`)
// document.write(`<br>${x}x 10 = ${x*10}`)

//*6
// r=+(prompt("Digite quanto dinheiro uma pessoa tem na carteira: "))
// u=r/5.40
// document.write(`<br>${r} reais são ${u.toFixed(2)} dolares`)

//*7
l=+(prompt("Digite largura: "))
a=+(prompt("Digite altura: "))
area=l*a
tinta=area/2
document.write(`<br>A area é ${area} e a quantidade de tinta são ${tinta} litros`)