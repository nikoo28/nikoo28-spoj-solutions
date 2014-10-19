#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main()
{
	int cases;
	scanf("%d",&cases);
	double vol,S,a;
	while(cases--)
	{
		scanf("%lf",&vol);
		double b=0.333333333333333333333;
		a=pow(4*vol,b);
		S=3*a*a*sqrt(3)/2;
		printf("%.10lf\n",S);
	}
	return 0;
}
