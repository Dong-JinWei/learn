#include <stdio.h>
void my_con(char * p,char * q,char * r);
int main(void)
{
	char s1[]={"this is my "};
	char s2[]={"program code."};
	char s3[100];
	my_con(s1,s2,s3);
	puts(s3);

	return 0;
}
void my_con(char * p,char * q,char * r)
{
	int i = 0;
	int m = 0;
	while(*(p+i) != '\0')
	{	
		*(r+i) = *(p+i);
		i++;
	}
	while(*(q+m) != '\0')
	{	
		*(r+i) = *(q+m);
		i++;
		m++;
	}
	*(r+i) = '\0';
}