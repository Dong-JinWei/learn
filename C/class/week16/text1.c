#include <stdio.h>
#define M 3      //班级的人数
#define NAME 10  //名字的长度
struct Student
{
	int id;
	char name[NAME];
	float match;
	float english;
	float computer;
};
int main(void)
{
	int i;
	struct Student student[M];

	for (i = 0; i < M; i++)
	{
		printf("请输入，学号，姓名，数学成绩，英语成绩，计算机成绩(空格分割)：\n");
		scanf("%d %s %f %f %f", &student[i].id, student[i].name, &student[i].match, &student[i].english, &student[i].computer);
	}
	
	printf("学号\t姓名\t数学成绩\t英语成绩\t计算机成绩\t平均分\n"); 
	for (i = 0; i < M; i++)
	{
		printf("%d\t%s\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\n", student[i].id, student[i].name, student[i].match, student[i].english, student[i].computer,
								(student[i].match+student[i].english+student[i].computer)/3);
	}


	return 0;
}
