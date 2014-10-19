#include<stdio.h>
#include<stdlib.h>
#include<math.h>

double orexp(double a,double b,double c,double x)
{
	double res=((a*x)+(b*(double)sin(x)))-c;
//	printf("res= %lf\n",res);
	return res;
}

double dfexp(double a,double b,double x)
{
	double res=a+(b*(double)cos(x));
	return res;
}

int main(void)
{
	double a,b,c;
	int cases;
	scanf("%d",&cases);
	double x1=0,x2;
	int i;
	while(cases--)
	{
		scanf("%lf %lf %lf",&a,&b,&c);
		x1=c/a;
		x2=x1-((orexp(a,b,c,x1))/(dfexp(a,b,x1)));
		x1=x2;
		for(i=0;i<50;i++)
		{
			x2=x1-((orexp(a,b,c,x1))/(dfexp(a,b,x1)));
			x1=x2;
		}
		printf("%lf\n",x2);
	}
	return 0;
}
