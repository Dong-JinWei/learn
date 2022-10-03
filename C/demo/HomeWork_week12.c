#include <stdio.h>
#include <ctype.h>
#define SIZE 10
int main(void)
{
	char ch[SIZE];
	int i = 0;
	int upper,lower,sp,num;
	upper = 0;
	lower = 0;
	sp = 0;
	num = 0;

	printf("Please enter a string:");
	gets(ch);
	printf("你输入的字符串是：%s\n",ch);
	while (ch[i] != '\0')
	{
		if (isupper(ch[i]))
			upper++;
		else if (islower(ch[i]))
			lower++;
		else if (isdigit(ch[i]))
			num++;
		else
			sp++;
		i++;
	}
	printf("大写字母有：%d\n小写字母有：%d\n数字有：%d\n特殊字符有：%d\n",upper, lower, num, sp);

	return 0;
}