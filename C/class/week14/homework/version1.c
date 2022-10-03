//code UTF-8, c11
#include <stdio.h>
void my_del(char * p, char ch);
int main(void)
{
	char s1[100]={"Lolita, light of my life, fire of my loins. My sin, my soul."};
    char del;//删除的字符
    del = 'l';
    printf("Befor: %s\n", s1);//删除前
	my_del(s1, del);
    printf("Deleted characters is: %c\n", del);//删除的字符
	printf("After: %s\n", s1);//删除后

    return 0;
}
void my_del(char *p, char ch)
{
    int i = 0;
		while (*(p+i) != '\0')//主循环
        {
            if (ch == *(p+i))//查找字符串中，值为ch的元素
            {    
                while (*(p+i) != '\0')
                {
                    *(p+i) = *(p+i+1);//从这个字符开始，后面的所有字符向前移动一位
                    i++;
                }            
                *(p+i) = '\0';//为字符串增加结束标志
                i = 0;//更新i的值，以便主函数从头开始查找
            }
            else
                i++;//如果没有找到，就判断下一个字符
        }

}