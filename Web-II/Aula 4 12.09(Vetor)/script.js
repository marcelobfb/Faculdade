//todo: vetor reservar na memoria do computador para poder armazenar os dados, possui 3 maneiras diferentes criar um vetor, construtor, literal e indice
//todo: Metodo construtor() - new Array()
// var a = new Array()
// document.write(`<br> ${a}`)
// var b = new Array(true, 1,2,3,4,new Array(1,2,3),'a')
// document.write(`<br> ${b}`)
// document.write(`<br> ${b[2]}`)
// document.write(`<br> ${b[5][1]}`)

// var b = [true, 1,2,3,4,[1,2,3],'a','a']
// document.write(`<br> ${b}`)
//* length - verifica o tamanho do array
// document.write('<br>O tamnho do vetor é ',b.length)
//* indexOf() - identifica a posição do elemento solicitado no vetor
// document.write(`<br>o elemento 'a' esta na posição de numero ${b.indexOf('a')}`)
//* lastIndexOf() - ultima ocorrencia do elemento solicitado no vetor
// document.write(`<br>o elemento 'a' foi visto por ultimo ${b.lastIndexOf('a')}`)
// -------------------------------------------------------------------------------------------------
//TODO: Metodo literal
// var d = [true, 1,2,3,4,[1,2,3],'a','a']
// document.write(`<br> ${d}`)
//* valores externos
// nota=[]
// for(i=0;i<3;i++){
//     nota[i]=prompt(`Digite a nota: `)
// }
// document.write(`<br>${nota}`)
//* string
// nome='Thereza'
// document.write(`<br>O nome tem  ${nome.length} letras`)
// document.write(`<br>Ultima vez q o 'e' aparece é na posição  ${nome.lastIndexOf('e')}`)
// *Inserir novos elemntos no array
// var e=[1,2,3,4]
// e[4]='novo valor'
// document.write(`<br>${e}`)
// *ou
// e[e.length]='Novo valor'
// document.write(`<br>${e}`)
// -------------------------------------------------------------------------------------------------
// pessoa = ["ana", "liz", "eva", "flora", "isabel"];
// for (i = 0; i < pessoa.length; i++) {
//     document.write(`<br>${pessoa[i]}`)
// }
// -------------------------------------------------------------------------------------------------
//*funcao de ordenação, reverse() - le o array de forma invertida
// pessoa = ["ana", "liz", "eva", "flora", "isabel"];
// for (i = 0; i < pessoa.length; i++) {
//     document.write(`<br>${pessoa.reverse()[i]}`)
// }
// *sort() - ordena em ordem alfabetica
// pessoa = ["ana", "liz", "eva", "flora", "isabel"];
// num = [5, 78, 3, 5, 7, 5];
// document.write(`<br>a ordem alfabetica do array é: ${pessoa.sort()}`);
// document.write(`<br>a ordem numerica do array é: ${pessoa.sort()}`);
// *concat() - concatenar vetores
// var f = [1, 2, 3, 4];
// var g = [6, 7, 8, 9];
// var h = f.concat(g);
// document.write(`<br>${h}`);
// //*includes() - verifica se um determinado elemento encontra-se no array///// se qusiser alterar o true for sim (?'Sim':'Não')
// document.write(`<br>O numero 2 encontra-se no array? ${(f.includes(2))}`);
// document.write(`<br>O numero 2 encontra-se no array? ${f.includes(12)}`);
//*push()- adiciona um novo elemento no final do array
// var i = [10, 20, 30, 40];
// i.push("azul");
// document.write(`<br>${i}`);
//*pop() - remove o ultimo elemento do vetor
// i.pop();
// document.write(`<br>${i}`);
//*unshift() - adicionar novo elemento no inicio do vetor
// i.unshift("azul");
// document.write(`<br>${i}`);
//*shift() - remover o primeiro elemento
// i.shift();
// document.write(`<br>${i}`);
//*slice() - fatia o array sem alterar o array original
// document.write(`<br>${i.slice(2)}`);
// document.write(`<br>${i.slice(0, 2)}`);
// letras = ["a", "b", "c", "d", "f", "g"];
// c = letras.slice(2);
// document.write(`<br>${c}`);
// c1 = letras.slice(2, 3);
// document.write(`<br>${c1}`);
// c2 = letras.slice(2, 5);
// document.write(`<br>${c2}`);
// c3 = letras.slice(-4, -2);
// document.write(`<br>${c3}`);
// c4 = letras.slice(-6, -3);
// document.write(`<br>${c4}`);

// email = "exemplo@gmail.com";
// e = email.slice(email.indexOf("@") + 1);
// document.write(`<br>${e}`);

// e2 = email.slice(email.lastIndexOf("m") + 1);
// document.write(`<br>${e2}`);

// e1 = email.slice(email.lastIndexOf("e"));
// document.write(`<br>${e1}`);

// nome2='Thereza'
// n1=nome2.slice(-3)
// document.write(`<br>${n1}`)

//*splice()- 1º valor: posição, 2º valor: quantidade de elementos excluidos, 3º valor: novos elementos

// d=['segunda','terça','quarta']
// d1=d.splice(1,1)
// document.write(`<br>${d1}`)
// document.write(`<br>${d}`)

// d2=d.sploce(1,1,'quinta','sexta')
// document.write(`<br>${d2}`)
// document.write(`<br>${d}`)
// d=['segunda','terça','quarta']
// d1=d.splice(1,1)
// document.write(`<br>${d}`)

// nome=[]
// for(i=0;i<5;i++){
//     nome[i]=prompt('Digite o seu nome: ')
// }
// document.write(`<br>Nome: ${nome}`)
// n=nome.splice(2,0,'1')
// document.write(`<br>Nome: ${nome}`)

//*funcao anonima - n possui nome, atribui-se a funca
var msg=function(x){
    return `ola ${x} bom dia`
}
nome=prompt('nome: ')
nome=nome[0].toUpperCase()+nome.substring(1)
document.write(`<br>${msg(nome)}`)

num=function(x){
    return x**2
}
numero=Number(prompt('Digite numero: '))
document.write(`<br>${num(numero)}`)
