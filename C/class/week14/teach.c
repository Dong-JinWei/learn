#include <stdio.h>
#include <string.h>
void my_con(char *p,char *q,char *r)
{
	while(*p!='\0')  //将s1拷贝到s3
	{
		*r=*p;
		r++;
		p++;
	}    
	while(*q!='\0')    //将s2拷贝到s3
	{
		*r=*q;
		r++;
		q++;
	}
	*r='\0';
	
}
int main(void)
{
	int len;
	char s1[]={"this is my "};
	char s2[]={"program code"};
	char s3[30];
	len=strlen(s1)+strlen(s2);
	if(len<=30)
	{
		my_con(s1,s2,s3);//将s1和s2的内容合并后存储到s3中。
		puts(s3);
	}
	else
		printf("需要合并的字符串长度超限！！");	
}