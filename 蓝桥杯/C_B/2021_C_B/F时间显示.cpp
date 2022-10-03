#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int main()
{
    ll n;
    scanf("%lld",&n);
    n/=1000;
    n%=(24*60*60);
    int ss=n%60;
    n/=60;
    int mm=n%60;
    n/=60;
    int hh=n%60;
    n/=60;
    printf("%02d:%02d:%02d",hh,mm,ss);
    return 0;
}
