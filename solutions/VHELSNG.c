#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main()
{
	int cases;
	scanf("%d",&cases);
	while(cases--)
	{
		double r;
		scanf("%lf",&r);
		double vol=(8.0*(2.0-(sqrt(2))))*(r*r*r);
		printf("%.4lf\n",vol);
	}
	return 0;
}
