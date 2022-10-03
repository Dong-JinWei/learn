#include <stdio.h>
#define SIZE 5 

void sort(int * pt, int n);

int main(void)
{
	int num[SIZE];
	int i;
	puts("请输入数字：");
	
	for (i = 0; i < SIZE; i++)
		scanf("%d", &num[i]);
	sort(num, SIZE);

	for (i = 0; i < SIZE; i++)
		printf("%d ", num[i]);
	printf("\n");

	return 0;
}

void sort(int * pt, int n)
{
	int i, m;
	int temp;

	for (i = 0; i < n-1; i++)
		for (m = i+1; m < n; m++)
		{	
			if (pt[i] > pt[m])
			{
				temp = pt[m];
				pt[m] = pt[i];
				pt[i] = temp;
			}
		}	
}
