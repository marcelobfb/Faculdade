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
int dvida(int x, int y, int z);
int main()
{
    int anos = 0;
    int meses = 0;
    int dias = 0;

    printf("anos:");
    scanf("%d", &anos);
    printf("meses:");
    scanf("%d", &meses);
    printf("dias:");
    scanf("%d", &dias);
    printf("\n%d dias de vida", dvida(anos, meses, dias));
}
int dvida(int x, int y, int z)
{
    x = x * 365;
    y = y * 30;
    int t = x + y + z;
    return t;
}