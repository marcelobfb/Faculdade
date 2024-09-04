//* 1
// var x = Number(prompt('Digite o primeiro número: '))
// var y = Number(prompt('Digite o segundo número: '))
// var z = prompt('Deseja somar(+), subtrair(-), dividir(/) ou multiplicar(*): ')
// switch(z){
//     case'+':
//     document.write(`${x} ${z} ${y} = ${x+y}`)
//     break
//     case'-':
//     document.write(`${x} ${z} ${y} = ${x-y}`)
//     break
//     case'/':
//     document.write(`${x} ${z} ${y} = ${x/y}`)
//     break
//     case'*':
//     document.write(`${x} ${z} ${y} = ${x*y}`)
//     break
// }

//* 2
// var x = prompt('Cliente comum (1), funcionario(2), vip(3): ')
// var y = Number(prompt('Digite o valor da compra: '))
// switch(x){
//     case'1':
//     document.write(`Sua compra é no valor de ${y} reais`)
//     break
//     case'2':
//     document.write(`Funcionario tem desconto de 10%, sua compra de ${y} reais deu o total de ${y-(y*0.10)}`)
//     break
//     case'3':
//     document.write(`Clientes vips tem desconto de 5%, sua compra de ${y} reais deu o total de ${y-(y*0.05)}`)
//     break
// }

//* 3
// var x=Number(prompt('Valor do produto: '))
// var y=prompt('Forma de pagamento, à vista(1) ou à prazo (2): ')
// switch(y){
//     case'1':
//     document.write(`Produto pago à vista, desconto de 10% aplicado, sua compra de ${x} reais, deu o total de ${x-(x*0.10)} reais`)
//     break
//     case'2':
//     document.write(`Forma de pagamento à prazo, o valor total é de ${x} reais`)
//     break
// }

//* 4
// var x=prompt('Conceito do aluno em Desenv Web 2 (A,B,C,D,E,F): ').toUpperCase()
// switch(x){
//     case'A':
//     document.write('A = Excelente')
//     break
//     case'B':
//     document.write('B = Ótimo')
//     break
//     case'C':
//     document.write('C = Bom')
//     break
//     case'D':
//     document.write('D = Regular')
//     break
//     case'E':
//     document.write('E = Ruim')
//     break
//     case'F':
//     document.write('F = Nos vemos de novo ano que vem...')
//     break
//     default:
//     document.write('ERRO: Opção invalida')
//     break
// }

//* 5
// var x=prompt('Digite uma letra: ').toLowerCase()
// switch(x){
//     case'a':
//     document.write(`A letra ${x} é vogal`)
//     break
//     case'e':
//     document.write(`A letra ${x} é vogal`)
//     break
//     case'i':
//     document.write(`A letra ${x} é vogal`)
//     break
//     case'o':
//     document.write(`A letra ${x} é vogal`)
//     break
//     case'u':
//     document.write(`A letra ${x} é vogal`)
//     break
//     default:
//     document.write(`A letra ${x} é uma consoante`)
//     break
// }

//* 6
// var x=[1,2,3,4,5,6,7,8,9]
// for(i=0;i<9;i++){
//     if(x[i]%2==0){
//         console.log(`${x[i]}`)
//     }
// }

//* 7
// for(i=0;i<90;i++){
//     var x=Number(prompt('Nota entre 0 a 10: '))
//     if(x>10||x<0){
//         alert('ERRO: Número invalido')
//     }
//     else{
//         break;
//     }
// }

//* 8
// for(i=0;i<90;i++){
//     var user=prompt('Usuario: ').toLowerCase()
//     var pass=prompt('Senha: ').toLowerCase()
//     if(user==pass){
//         alert('ERRO: Usuario não pode ser o mesmo que a senha.')
//     }
//     else{
//         break
//     }
// }

//* 9
// var x=Number(prompt('Quantos numeros vai digitar: '))
// var menornum=0
// var maiornum=0
// somadosvalores=0
// for(i=0;i<x;i++){
//     var num=Number(prompt(`Digite o ${i+1}º Número: `))
//     if(num>maiornum){
//         maiornum=num
//     }
//     else if(num<menornum||menornum==0){
//         menornum=num
//     }
//     somadosvalores+=num
// }
// document.write(`O menor valor é ${menornum} o maior numero é ${maiornum} e a soma dos valores é ${somadosvalores}`)

//* 10
// var qtdturma=Number(prompt('Quantidade de turmas: '))
// var somaaluno=0
// for(i=0;i<qtdturma;i++){
//     var qtdaluno=Number(prompt(`Quantidades de aluno da turma ${i+1} (não podem ter mais de 40): `))
//     somaaluno+=qtdaluno
// }
// var media=somaaluno/qtdturma
// document.write(`O numero medio de alunos por tuma é ${media.toFixed(2)}`)

//* 11
// function calcularPorcentagem(valor, porcentagem){
//     return(valor * porcentagem)/100
// }
// var numero=Number(prompt('Num: '))
// var percentual=Number(prompt('Digite a porcentagem: '))
// var resultado=calcularPorcentagem(numero,percentual)
// alert(`O valor de ${percentual}% de ${numero} é ${resultado}`)

//* 12
// function convertor(c){
//     return c * 1.8 + 32
// }
// var Celsius=Number(prompt('Digite o numero em Celsius: '))
// var resultado=convertor(Celsius)
// alert(`O valor de ${Celsius}C convertido para fahrenheit é de ${resultado.toFixed(2)}F `)

//* 13
// function fibonacci(n){
//     if(n<=1){
//         return n
//     }
//     return fibonacci(n-1) + fibonacci(n-2)
// }
// for(i=0;i<10;i++){
//     document.write(fibonacci(i)+' ')
// }

//* 14 
// function raizquadrada(num){
//     return Math.floor(Math.sqrt(num))
// }
// var numero=Number(prompt('Numero: '))
// var resultado=raizquadrada(numero)
// document.write(`raiz quadrada de ${numero} arrendonda para baixo é ${resultado} `)

//* 15
function maiorouigual(num1,num2){
    return num1>=num2
}
var primeironum=Number(prompt('primeiro num: '))
var segundonum=Number(prompt('segundo num: '))
var resultado=maiorouigual(primeironum,segundonum)
if(resultado){
    alert(`${primeironum} é maior ou igual a ${segundonum}`)
}
else{
    alert(`${primeironum} não é maior ou igual a ${segundonum}`)
}