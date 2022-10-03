#include <stdio.h>
#include <ctype.h>
#define SIZE 81

void find(char * ar, int n);
int main(void)
{
	char string[SIZE];
	int i;
	char ch;
	
	puts("请输入字符串：");	
	
	for (i = 0; i < SIZE; i++)
	{
		if ((ch = getchar()) != '\n')
			string[i] = ch;
		else
			break;
	}
	string[i] = '\0';
	find(string, SIZE);

	return 0;
}
void find(char * ar, int n)
{
	int low, up, sp, num;
	int i;
	low = 0;
	up = 0;
	sp = 0;
	num = 0;
	for (i = 0; i < n; i++)
	{
		if (ar[i] == '\0')
			break;
		if (isupper(ar[i]))
			up++;
		else if (islower(ar[i]))
			low++;
		else if (isdigit(ar[i]))
			num++;
		else
			sp++;
	}
	printf("大写字母有：%d个, 小写字母有：%d个, 数字有: %d个, 其他字符有: %d个\n", up, low, num, sp);
}
