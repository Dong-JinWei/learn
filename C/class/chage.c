#include <stdio.h>
#define SIZE 5
int max(int *x);
void get_num(int *x);
int main(void)
{
	int temp[SIZE];
	int numax;
	get_num(temp);
	numax = max(temp);
	printf("The max number is :%d\n",numax);
	return 0;
}
int max(int *x)
{
	int max,i;
	max = x[0];
	for(i = 0; i < SIZE; i++)
	{
		if(max < x[i])
			max = x[i];
	}
	return max;	 
}
void get_num(int *x)
{
	int i;
	printf("Please enter %d numbers:",SIZE);
	for (i = 0; i < SIZE; i++)
		scanf("%d",x+i);
	printf("You enter number is ");
	for (i = 0; i < SIZE; i++)
		printf("%d ", x[i]);
	printf("\n");
}


