#include <stdio.h>
#define SIZE 10
void inv(int x[], int n);
void show(int x[], int n);
int main(void)
{
    int a[SIZE] = {3,7,9,11,0,6,7,5,4,2};
    printf("You array is (before) :");
    show(a, SIZE);
    inv(a, SIZE);
    printf("You array is (after): ");
    show(a, SIZE);
    return 0;
}
void show(int x[], int n)
{
    int i;
    for (i = 0; i < n; i++)
        printf("%d ", x[i]);
    printf("\n");
}
void inv(int x[] , int n)
{
    int i;
    int temp[SIZE];
    int * demo;
    demo = x;
    for(i = 0; i < n; i++)
    {
        temp[i] = x[SIZE - 1 - i];
    }
    for (i = 0; i < n; i++)
    {
        demo[i] = temp[i];
    }
    printf("Chage is ok!\n");
}