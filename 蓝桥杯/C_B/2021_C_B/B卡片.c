#include <stdio.h>

int arr[10];

int del(int n){
	while(n){
		int temp = n % 10;
		if (arr[temp] == 0){
			return 0;
		}else{
			arr[temp]--;
			n = n / 10;
		}
	}
	return 1;
}

int main(){
	
	int i, count = 0;
	int num = 1;
	
	for (i = 0; i < 10; i++){
		arr[i] = 2021;
	}
		
	
	while(1){
		int flag = del(num);
		if (flag){
			num++;
			count++;
		}else{
			break;
		}
	}
	printf("%d", count);

} 
