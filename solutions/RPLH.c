#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main(void)
{
	int cases,i;
	scanf("%d",&cases);
	double g=9.806;
	double pi=2*acos(0.0);
//	printf("pi= %lf",pi);
	for(i=1;i<=cases;i++)
	{
		double spd,dst,angl;
		scanf("%lf %lf",&dst,&spd);
		dst=dst*g;
		dst=dst/(spd*spd);
		if(dst>1 || dst<-1)
		{
			printf("Scenario #%d: -1\n",i);
			continue;
		}
		dst=asin(dst);
		dst=dst/2.0;
		dst=dst*57.2957795;
		printf("Scenario #%d: %.2lf\n",i,dst);
	}
	return 0;
}
