#include<stdio.h>
#include<stdlib.h>

int main()
{
	int cases,i;
	scanf("%d",&cases);
	for(i=1;i<=cases;i++)
	{
		double r;
		scanf("%lf",&r);
		double s=(r*r*4.0)+(0.25);
		printf("Case %d: %.2lf\n",i,s);
	}
	return 0;
}
