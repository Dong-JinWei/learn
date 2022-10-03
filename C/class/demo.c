#include <stdio.h>
void fun(int * x, int * y);
int main(void)
{
	int x, y;
	puts("Please enter two number:");
	scanf("%d %d", &x, &y);
	fun(&x, &y);
	printf("%d %d\n", x ,y);
	return 0;
}
void fun(int * x, int *y)
{
	int  demo;
	
	demo =*x;
	*x =*y;
	*y = demo;
}
