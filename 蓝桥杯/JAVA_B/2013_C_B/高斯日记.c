/*
����ѧ�Ҹ�˹�и���ϰ�ߣ�������ζ�Ҫ���ռǡ�

�����ռ��и����ڲ�ͬ�ĵط������Ӳ�ע�������գ�������һ���������棬���磺4210

��������֪�����Ǹ������������ڣ�����ʾ��һ���Ǹ�˹������ĵڼ��졣�����Ҳ�Ǹ���ϰ�ߣ���ʱʱ�̿����������ˣ������ֹ�ȥһ�죬���ж���ʱ����������˷��أ�

��˹�����ڣ�1777��4��30�ա�

�ڸ�˹���ֵ�һ����Ҫ������ռ��ϱ�ע�ţ�5343����˿���������ǣ�1791��12��15�ա�

��˹��ò�ʿѧλ�������ռ��ϱ��ţ�8113   

���������˹��ò�ʿѧλ�������ա�

*/ 

#include <stdio.h>


int isLeapYear(int year){
	return (year%4 == 0 && year%100 != 0) || (year%400 == 0);
}

int main(){
	int year = 1777; //������ 
	int month = 4;  //������ 
	int day = 30;  //������ 
	
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
