#include <stdio.h>
// 1
// float multiplicar(float x, float y);
// int main()
// {
//     float n1 = 0, n2 = 0;
//     printf("n1:");
//     scanf("%f", &n1);
//     printf("n2:");
//     scanf("%f", &n2);
//     printf("%.2f*%.2f=%.2f\n", n1, n2, multiplicar(n1, n2));
//     return 0;
// }
// float multiplicar(float x, float y)
// {
//     return x * y;
// }

// 2
// void verificar(int i);
// int main()
// {
//     int idade = 0;
//     printf("Idade: ");
//     scanf("%d", &idade);
//     verificar(idade);
// }
// void verificar(int i)
// {
//     if (i >= 18 && i <= 70)
//     {
//         printf("Pode votar");
//     }
//     else
//     {
//         printf("Nao pode votar");
//     }
// }

// 3
// int dvida(int x, int y, int z);
// int main()
// {
//     int anos = 0;
//     int meses = 0;
//     int dias = 0;

//     printf("anos:");
//     scanf("%d", &anos);
//     printf("meses:");
//     scanf("%d", &meses);
//     printf("dias:");
//     scanf("%d", &dias);
//     printf("\n%d dias de vida", dvida(anos, meses, dias));
// }
// int dvida(int x, int y, int z)
// {
//     x = x * 365;
//     y = y * 30;
//     int t = x + y + z;
//     return t;
// }

// 4
float valor(char tamanho, char sexo);
int main()
{
    char tamanho;
    char sexo;
    float valorFinal = 0;
    printf("Tamanho: ");
    scanf(" %c", &tamanho);
    printf("sexo: ");
    scanf(" %c", &sexo);
    valorFinal = valor(tamanho, sexo);
    printf("A sua camisa de tamanho %c do sexo %c custa %.2f\n", tamanho, sexo, valorFinal);
}
float valor(char tamanho, char sexo)
{
    float t = 0;

    if (tamanho == 'p' && sexo == 'm')
    {
        float t = 22.25;
        return t;
    }
    else if (tamanho == 'm' && sexo == 'm')
    {
        float t = 27.15;
        return t;
    }
    else if (tamanho == 'g' && sexo == 'm')
    {
        float t = 40;
        return t;
    }
    else if (tamanho == 'p' && sexo == 'f')
    {
        float t = 28.75;
        return t;
    }
    else if (tamanho == 'm' && sexo == 'f')
    {
        float t = 39.99;
        return t;
    }
    else if (tamanho == 'g' && sexo == 'f')
    {
        float t = 51;
        return t;
    }
}