#include <stdio.h>
// tipo_retornado nome_funcao(parametros){
//     conjunto de declaração e comandos
// }
void linha();
float soma(float x, float y);
float multiplicar(float x, float y);
float dividir(float x, float y);
int main()
{
    float n1 = 0, n2 = 0;
    linha();
    printf("n1:");
    scanf("%f", &n1);
    linha();
    printf("n2:");
    scanf("%f", &n2);
    linha();
    printf("%.2f+%.2f=%.2f\n", n1, n2, soma(n1, n2));
    printf("%.2f*%.2f=%.2f\n", n1, n2, multiplicar(n1, n2));
    printf("%.2f/%.2f=%.2f\n", n1, n2, dividir(n1, n2));
    linha();
    return 0;
}
void linha()
{
    printf("--------------------------------------------------------------------------\n");
}
float soma(float x, float y)
{
    return x + y;
}
float multiplicar(float x, float y)
{
    return x * y;
}
float dividir(float x, float y)
{
    float t = x / y;
    return t;
}