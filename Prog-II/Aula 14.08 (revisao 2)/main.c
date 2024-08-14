// exercicio 1
//  #include <stdio.h>

// int main(){
//     char nomes [4][30];
//     for (int i=0;i<4;i++){
//         printf("Nome: ");
//         scanf("%s", nomes[i]);
//     }
//     for(int i=0;i<4;i++){
//         printf("%s\n",nomes[i]);
//     }
//     return 0;
// }
// exercicio 2
// #include <stdio.h>

// int main()
// {
//     int idades[3][2];
//     int count = 0;
//     for (int i = 0; i < 3; i++){
//         for (int j=0;j<2;j++){
//             printf("Idade: ");
//             scanf("%d", &idades[i][j]);
//             if(idades[i][j]>=18){
//                 count++;
//             }
//         }
//     }
//     printf("%d são maiores que 18 anos\n", count);
//     for (int i = 0; i < 3; i++){
//         for (int j=0;j<2;j++){
//             if(idades[i][j]<18){
//                 printf("%d anos é menor que 18 anos\n",idades[i][j]);
//             }
//         }
//     }
//     return 0;
// }
// exercicio 3
// #include <stdio.h>
// #include <string.h>

// int main()
// {
//     char nomes[3][30];
//     char menornome[30];
//     int maior = 0;
//     int menor = 0;
//     int var = 0;
//     int comp = 0;
//     int test = 0;
//     for (int i = 0; i < 3; i++)
//     {
//         printf("Nome: ");
//         scanf("%s", nomes[i]);
//         var = strlen(nomes[i]);
//         if (var > maior)
//         {
//             maior = var;
//         }
//         if (var < menor || menor == 0)
//         {
//             menor = var;
//             strcpy(menornome, nomes[i]);
//         }
//         comp = strcasecmp(nomes[i], "ana");
//         if (comp == 0)
//         {
//             test = 1;
//         }
//     }
//     if (test == 1)
//     {
//         printf("Ana foi digitado.\n");
//     }
//     printf("A maior quantidade de caracteres é %d\n", maior);
//     printf("o menor nome é %s\n", menornome);
//     return 0;
// }
// exercicio 4
#include <stdio.h>
#include <string.h>

int main()
{
    char nomes[4][30];
    int idades[4][10];
    char maiornome[30];
    int soma = 0;
    float media = 0;
    int maior = 0;
    int qtdpar = 0;
    for (int i = 0; i < 4; i++)
    {
        printf("Nome: ");
        scanf("%s", nomes[i]);
        printf("Idade: ");
        scanf("%d", &idades[i]);
        soma = soma + idades[i];
        if (idades[i]>maior)
        {
            maior = idades[i];
            strcpy(maiornome, nomes[i]);
        }
        if (idades[i] % 2 == 0)
        {
            qtdpar++;
        }
    }
    media = soma / 4;
    printf("A media é %.2f", media);
    printf("O nome da pessoa mais velha é Sr(a) %c", maiornome);
    printf("%d pessoas possuem idade par", qtdpar);
    return 0;
}