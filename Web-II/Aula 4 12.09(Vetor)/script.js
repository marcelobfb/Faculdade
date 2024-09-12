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
var i=[10,20,30,40]
i.push('azul')
document.write(`<br>${i}`)