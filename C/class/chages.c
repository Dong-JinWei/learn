/*如何使用指针
1.指针作为函数的参数。
2.指针和数组的关系
3.指针的偏移量由数据类型决定
*/
#include <stdio.h>
#include <string.h>

void get_values(int *q)
{
	int i;
	for(i=0;i<10;i++)
		scanf("%d",q+i);
}

void put_values(int *s)
{
	int i;
	for(i=0;i<10;i++)
		printf("%d\t",*(s+i));
}

int a_max(int *r)
{
	int m,i;
	m=*r;
	for(i=0;i<10;i++,r++)
	{
		if(*r>m)
			m=*r;
	}
	return m;
}

int main()
{
	int a[10],max;
	get_values(a);
	put_values(a);
	max=a_max(a);
	printf("max is %d!\n",max);
	return 0;
}




