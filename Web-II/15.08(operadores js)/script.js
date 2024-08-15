//comentario de 1 linha
/*comentario de multiplas linhas */
alert('Bom dia! Sejam Bem-Vindos!\n'+Date())/*faz um alerta quando abre a pagina*/
document.write('Bom dia! Sejam Bem-Vindos!<br>'+Date())/*Escreve no texto*/
console.log('Bom dia! Sejam Bem-Vindos!\n'+Date())/*Escreve no console, inspecionar, console */
/*para concatenar podemos usar o sinal de + ou a virgula, sendo que no alert so funciona o sinal de + */
document.write('<br>O resultado é: ' +1+2)
document.write('<br>O resultado é: ' ,1,2)
document.write('<br>O resultado é: ' +(1+2))
//const=constante
const nome ='Marcelo Bernardes'
const idade =15
document.write('<br>O nome da pessoa é '+nome+' ele tem '+idade+' anos<br>')
const email='marcelobouchardet@hotmail.com',cidade='niteroi'/*outra maneira de declarar constante*/
document.write('meu email é '+email+'e moro em '+cidade)
//var=variavel
var nome2 = prompt("Digite o seu nome")
var idade2 = prompt("Digite sua idade")
document.write('<br>'+nome2+" você tem "+idade2+' anos<br>')
//operadores aritméticos: +,-,*,/,%
valor1=Number(prompt("Digite o valor 1"))
valor2=Number(prompt("Digite o valor 2"))
valor3=Number(prompt("Digite o valor 3"))
valor4=Number(prompt("Digite o valor 4"))
soma=valor1+valor2+valor3+valor4
/*
parseInt
parseFloat
Number
+
*/
document.write(valor1+'+'+valor2+'+'+valor3+'+'+valor4+" = "+soma)
//exemplo de subtração
document.write("<br> A subtração de "+ valor1+" - "+valor4+" é = " ,valor1-valor4)
document.write("<br> A multiplicação de "+ valor1+" * "+valor3+" é = ",valor1*valor3)
//operação matematica
document.write("<br>O resultado da operação valor1*(valor2+valor3)/valor4 é ",valor1*(valor2+valor3)/valor4)