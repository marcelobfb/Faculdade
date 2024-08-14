// revisão exercicio 1
//  #include <stdio.h>
//  int main(void) {
//    float altura[5][20];
//    float soma=0;
//    float somatoria=0;
//    float media=0;
//    int count=0;
//    for(int i=0;i<5;i++){
//      printf("Qual sua altura? ");
//      scanf(" %f", &altura[i][0]);
//      soma=soma+altura[i][0];
//      if(altura[i][0]>1.75){
//        count++;
//      }
//    }
//    media=soma/5;
//    printf("A soma das alturas é %.2f\n",soma);
//    printf("A media das alturas é %.2f\n",media);
//    printf("A quantidade de pessoas acima de 1.75m é %d\n",count);
//    return 0;
//  }
// exercicio 2
//  #include <stdio.h>
//  int main (){
//    int idades[4][10];
//    float pesos[4][30];
//    int maiorvinte=0;
//    int maisvelha=0;
//    int maisnova=0;
//    float menorpeso=0;
//    float pesomaisnova=0;
//    for(int i=0; i<4;i++){
//      printf("Qual seu peso? ");
//      scanf(" %f", &pesos[i][0]);
//      printf("Qual sua idade? ");
//      scanf(" %d", &idades[i][0]);
//      if(idades[i][0]>20 && pesos[i][0]<70){
//        maiorvinte++;
//      }
//      if(idades[i][0]>maisvelha){
//        maisvelha=idades[i][0];
//      }
//      if(idades[i][0]<maisnova||maisnova==0){
//        maisnova=idades[i][0];
//        pesomaisnova=pesos[i][0];
//      }
//      if(pesos[i][0]<menorpeso||menorpeso==0){
//        menorpeso=pesos[i][0];
//      }
//    }
//    printf("A quantidade de pessoas que tem mais de 20 anos e pesa menos que
//    70kg é %d\n",maiorvinte); printf("A idade da pessoa mais velha é %d\n",
//    maisvelha); printf("O peso da pessoa com menor peso %.2f\n",menorpeso);
//    printf("O peso da pessoa mais nova é %.2f\n",pesomaisnova);
//    return 0;
//  }
// exercicio 3
#include <stdio.h>
int main() {
    float salario[2][3];
    float media = 0;
    float somatoria = 0;
    int countabaixomedia = 0;
    int countentre = 0;
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 3; j++) {
            printf("Qual salario: ");
            scanf(" %f", &salario[i][j]);
            somatoria = somatoria + salario[i][j];
            if (salario[i][j] >= 1250 && salario[i][j] <= 1800) {
                countentre++;
            }
        }
    }
    media = somatoria / 6;
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 3; j++) {
            if (salario[i][j] < media) {
                countabaixomedia++;
            }
        }
    }
    printf("Quantidade de salario entre 1250 e 1800 é %d\n", countentre);
    printf("A media salarial é %.2f\n", media);
    printf("Quantidade de salarios abaixo da media é %d\n", countabaixomedia);
    return 0;
}