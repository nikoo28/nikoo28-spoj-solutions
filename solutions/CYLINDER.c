#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#define MIN(a,b) ((a)<(b)?(a):(b))

int main(void)
{
	double w,h;
	double r1,h1,r2,h2,vol1,vol2,vol;
	while(1)
	{
		scanf("%lf %lf",&w,&h);
		if(w==0 || h==0)
			break;
		r1=w/(2.0*M_PI);
		h1=h-(2.0*r1);
		r2=MIN(h/(2.0*(M_PI+1.0)),w/2.0);
		h2=w;
		vol1=(M_PI*r1*r1*h1);
		vol2=(M_PI*r2*r2*h2);
		vol=vol1>vol2?vol1:vol2;
		printf("%.3lf\n",vol);
	}
	return 0;
}
