#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main(void)
{
	long cases;
	scanf("%ld",&cases);
	while(cases--)
	{
		double x,y,z;
		scanf("%lf %lf %lf",&x,&y,&z);
		if(x==0)
		{
			printf("0\n");
			continue;
		}
		if(x==z)
		{
			printf("%.0lf\n",x);
			continue;
		}
		double ang1=0;
		double ang1_twice=0;
		double ang2=0;
		double i;
		int flag=0;
		long long low=0;
		long long high=x;
		i=(low+high)/2;
		int count=0;
		while(high>=low)
		{
			count++;
			if(count==200)
				break;
			char ab[1000000];
			ang1=(double)(atan(z/i));
			ang1_twice=2.0*ang1;
			ang2=(double)(atan((y)/(x-i)));
			sprintf(ab,"%lf\t%lf",ang1_twice,ang2);
			if(ang2>ang1_twice)
				low=i+1;
			else if(ang1_twice==ang2)
			{
				flag=1;
				printf("%.0lf\n",i);
				break;
			}
			else
				high=i-1;
			i=(low+high)/2;
		}
		if(!flag)
			printf("Not this time.\n");
	}
	return 0;
}
