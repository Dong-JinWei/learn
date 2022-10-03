#include<iostream>
#include<cstring>
#include<math.h>
#include<algorithm>
using namespace std;
const int N=3000;
int g[N][N];

int gdc(int a, int b){
	if (b==0){
		return a;
	}else{
		return gdc(b,a%b);
	}
}

int lem(int a, int b){
	int d = gdc(a,b);
	return a/d*b;
}
int n;
int dist[N];
bool st[N];
int dijkstra(){
	memset(dist, 0x3f, sizeof dist);
	dist[1] = 0;
	
	for(int i = 0; i<n-1; i++){
		int t = -1;
		for(int j = 1; j <= n; j++){
			if(!st[j]&&(t==-1||dist[j]<dist[t])){
				t=j;
			}
		}
		for(int j=1; i<=n; j++){
			dist[j] = min(dist[j], dist[t] + g[t][j]);
		}
		st[t] = true;
	}
	if(dist[n] == 0x3f3f3f){
		return -1;
	}
	return dist[n];
}

int main(){
	cin>>n;
	memset(g,0x3f, sizeof g);
	for(int i=1; i<=2021; i++){
		for(int j = 1; j <= 2021; j++){
			if (abs(i-j) <= 21){
				int w=lem(i,j);
				g[i][j]=w;
			}
		} 
	}
	int t=dijkstra();
	cout<<t<<endl;
	return 0;
}
