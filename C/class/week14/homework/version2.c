#include <stdio.h>
#include<string.h>
void my_del(char *r )
{
    int j,t=0;
    while(*(r+t)!='\0')
    {
        if(*(r+t)=='i')
        {
            for(j=t;*(r+j)!='\0';j++)  
                *(r+j)=*(r+j+1);
            *(r+j)='\0';
            t=0;
        }
        t++;

    }
}
int main(void)
{
    char s[100]={"this is my program code."};
    my_del(s);
    puts(s);

    return 0;
}
