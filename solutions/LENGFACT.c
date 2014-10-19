#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main()
{
	int cases;
	scanf("%d",&cases);
	long long num;
	while(cases--)
	{
		scanf("%lld",&num);
		if(num==0 || num==1)
		{
			printf("1\n");
			continue;
		}
		double result=floor((log(2*M_PI*num)/2 + num*(log(num)-1) + 1/(12*num)) / log(10))+1;
		printf("%.0lf\n",result);
	}
	return 0;
}
