#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	int cases;
	scanf("%d",&cases);
	long long tot;
	long long level;
	while(cases--)
	{
		scanf("%lld",&level);
		tot=level*((3*level)+1)/2;
		tot%=1000007;
		printf("%lld\n",tot);
	}
	return 0;
}
