//* While() - a condição é verificada antes de ser executada
// var a=0
// while(a<=10){
//     document.write(`<br>${a}`)
//     a++
// }
// ---------------------------------------------------------------
// var b=Number(prompt("Digite um número ate 50: "))
// while(b<50){
//     document.write(`<br>${b}`)
//     b+=2//ou b=b+2
// }
// ---------------------------------------------------------------
//* exemplo de decremento
// var c=10
// while(c>=0){
//     document.write(`<br>Número ${c}`)
//     c--
// }
// ---------------------------------------------------------------
// var n=1
// par=impar=0
// var list=[]
// while(n!=0){
//     n=+(prompt('Digite um número: '))
//     if(n!=0){
//         list.push(n)
//         if(n%2==0){
//             par++
//         }
//         else{
//             impar++
//         }
//     }
// }
// document.write(`<br>Você digitou ${par} numeros pares e ${impar} numeros impar, os numeros digitados foram ${list}`)
// ---------------------------------------------------------------
// n1=0
// while(n1<5){
//     n1++
//     if(n1==3){
//     continue
//     }
// document.write(`<br>${n1}`)
// }
// ---------------------------------------------------------------
// c=Math.floor(Math.random()*11)
// var acerto=false
// var palpite=0
// while(acerto==false){
//     j=+(prompt('Qual o seu palpite: '))
//     palpite++
//     if(j==c){
//         acerto=true
//     }
// }
// document.write(`<br>Você acertou em ${palpite} tentativas.`)
// document.write(`<br>O numero sorteado foi ${c}`)
// ---------------------------------------------------------------
// x=5
// while(x<5){
//     document.write(`<br>${x}`)
// }
// ---------------------------------------------------------------
//* Do while()
// var x = 10;
// do {
//   document.write(`<br>${x}`);
//   x++;
// } while (x < 21);
// ---------------------------------------------------------------
// var b=Number(prompt("Digite um número ate 50: "))
// do{
//     document.write(`<br>${b}`)
//     b+=2//ou b=b+2
// }while(b<=50)
// ---------------------------------------------------------------
// x=5
// do{
//     document.write(`<br>${x}`)
// }while(x<5)
// ---------------------------------------------------------------
// var opcao;
// var num1;
// var num2;
// var result;

// do {
//     console.log("Menu de operações: ");
//     console.log("1. Soma: ");
//     console.log("2. Subtração: ");
//     console.log("3. Multiplicação: ");
//     console.log("4. Divisão: ");
//     console.log("5. Sair: ");
//     opcao = +prompt("Escolha uma operação: ");

//     if (opcao >= 1 && opcao <= 4) {
//         num1 = +prompt("Digite o primeiro num: ");
//         num2 = +prompt("Digite o segundo num: ");
//     }

//     switch (opcao) {
//         case 1:
//             result = num1 + num2;
//             console.log(`resultado: ${num1} + ${num2} = ${result}`);
//             break;
//         case 2:
//             result = num1 - num2;
//             console.log(`resultado: ${num1} - ${num2} = ${result}`);
//             break;
//         case 3:
//             result = num1 * num2;
//             console.log(`resultado: ${num1} * ${num2} = ${result}`);
//             break;
//         case 4:
//             if (num2 !== 0) {
//                 result = num1 / num2;
//                 console.log(`resultado: ${num1} / ${num2} = ${result}`);
//             } else {
//                 console.log("Erro: divisão por zero não é permitido");
//             }
//             break;
//         case 5:
//             console.log("Sair");
//             break;
//         default:
//             console.log("Opção inválida");
//     }
// } while (opcao !== 5);

//* Função
// function mensagem(){
//     document.write(`<br>Olá mundo`)
// }
// mensagem()
// ---------------------------------------------------------------
// function mensagem1() {
//     return `<br>Oál mundo`;
// }
// document.write(mensagem1());
// ---------------------------------------------------------------
// function mensagem2(nome){
//     document.write(`<br> Bom dia, ${nome}!`)
// }
// nome=prompt('Digite o seu nome')
// mensagem2(nome)
// ---------------------------------------------------------------
// function mensagem3(nome){
//     return `<br> Bom dia, ${nome}`
// }
// nome=prompt('digite o nome')
// document.write(mensagem3(nome))
// ---------------------------------------------------------------
// function soma(x,y){
//     return x+y
// }
// x=Number(prompt('primeiro numero'))
// y=Number(prompt('segundo numero'))
// document.write(`<br> ${x}+${y}=${soma(x,y)}`)
// ---------------------------------------------------------------
// function media(x,y,z){
//     return((x+y+z)/3)
// }
// x=parseFloat(prompt('primeiro nota'))
// y=parseFloat(prompt('segunda nota'))
// z=parseFloat(prompt('terceira nota'))
// document.write(`<br> A media das notas é ${media(x,y,z).toFixed(1)}`)
// ---------------------------------------------------------------
// function par(num){
//     return num%2==0
// }
// num=parseFloat(prompt('numero: '))
// if(par(num)){
//     document.write(`<br> o número ${num} é par`)
// }
// else{
//     document.write(`<br> o numero ${num} é impar`)
// }
// ---------------------------------------------------------------
function fatorar(num){
    if(num==0||num==1){
        return 1
    }
    return num*fatorar(num-1)
}
num=parseFloat(prompt('numero: '))
document.write(`<br> o número ${fatorar(num)}`)