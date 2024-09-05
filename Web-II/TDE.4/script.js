//* 1
// x=1
// while(x<=10){
//     document.write(`<br>${x}`)
//     x++
// }

//* 2
// const n = Number(prompt("Digite um número N:"));
// var soma = 0;
// var contador = 1;
// while (contador <= n) {
//     soma += contador;
//     contador += 1;
// }
// document.write(`A soma de todos os números de 1 a ${n} é ${soma}.`);

//*3
// var x = 20;
// do {
//     document.write(`<br>${x}`);
//     x--;
// } while (x >= 10);
// document.write("<br>Lançamento");

//*4
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

// *5
// senha='senha'
// do{
// user=prompt('Senha: ')
// }while(user!=senha)
// document.write("senha aprovada")

//* 6
// function saudacao(nome){
//     document.write(`<br> Oi, ${nome}!`)
// }
// nome=prompt('Digite o seu nome')
// saudacao(nome)

//* 7
function potencia(base, expoente) {
    var result = 1;
    var count = 0;
    do {
        result *= base;
        count++;
    } while (count < expoente);
    return result;
}

base = Number(prompt("Digite a base"));
expoente = Number(prompt("Digite o expoente"));
document.write(`<br>${potencia(base, expoente)}`);
