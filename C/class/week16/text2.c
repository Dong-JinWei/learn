#include <stdio.h>
#define SIZE 81
int mystrlen(char * ar, int n);
int main(void)
{
	char string[SIZE];
	
	puts("请输入字符串：");
	scanf("%s",string);
	printf("他的长度是：%d\n", mystrlen(string, SIZE));

	return 0;
}
int mystrlen(char * ar, int n)
{
	int i, sum = 0;
	for (i = 0; i < n; i++)
	{
		if (ar[i] != '\0')
			sum++;
	}
	return sum;
}
