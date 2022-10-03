#include<bits/stdc++.h>
using namespace std;
set<pair<double,double> > line_set;

int main()
{
    int x1,y1,x2,y2;S
    for(x1=0;x1<20;x1++){
        for(y1=0;y1<21;y1++){
            for(x2=0;x2<20;x2++){
                for(y2=0;y2<21;y2++){
                    if(x1!=x2&&y1!=y2){
                        double k=(y2-y1)*1.0/(x2-x1);
                        double b=(y2*(x2-x1)-(y2-y1)*x2)*1.0/(x2-x1);

                        pair<double ,double> newline;
                        newline.first=k;
                        newline.second=b;
                        line_set.insert(newline);
                    }
                }
            }
        }
    }
    printf("%d",line_set.size()+20+21);
    return 0;
}
//40257
