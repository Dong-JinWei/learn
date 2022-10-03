/*
大数学家高斯有个好习惯：无论如何都要记日记。

他的日记有个与众不同的地方，他从不注明年月日，而是用一个整数代替，比如：4210

后来人们知道，那个整数就是日期，它表示那一天是高斯出生后的第几天。这或许也是个好习惯，它时时刻刻提醒着主人：日子又过去一天，还有多少时光可以用于浪费呢？

高斯出生于：1777年4月30日。

在高斯发现的一个重要定理的日记上标注着：5343，因此可算出那天是：1791年12月15日。

高斯获得博士学位的那天日记上标着：8113   

请你算出高斯获得博士学位的年月日。

*/ 

#include <stdio.h>


int isLeapYear(int year){
	return (year%4 == 0 && year%100 != 0) || (year%400 == 0);
}

int main(){
	int year = 1777; //出生年 
	int month = 4;  //出生月 
	int day = 30;  //出生日 
	
	int i;
	for (i = 0; i < 8122; ++i){
		day++;
		if (month == 12 && day == 32){
			year++;
			month = 1;
			day = 1;
			continue;	
		}
		if ((month == 1 && month == 3 && month == 5 && month == 7 && month == 8 && month == 10 && month == 12) && day == 32){
			month++;
			day=1;
			continue;
		}
		if ((month == 4 && month == 6 && month == 9 && month == 10 && month == 11) && day == 31){
			month++;
			day=1;
			continue;
		}
		if (month == 2 && isLeapYear(year) && day == 30){
			month++;
			day=1;
			continue;
		}
		if (month == 2 && !isLeapYear(year) && day == 29){
			month++;
			day=1;
			continue;
		}
	}
	printf("%d  %d  %d",year,month,day);
	return 0;
}
