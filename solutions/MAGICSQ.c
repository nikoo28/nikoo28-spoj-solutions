#include<stdio.h>
#include<stdlib.h>

long long power(int x,int y)
{
	x=x*x;
	x=x*x;
	return x;
}

int main(void)
{
	int cases;
	scanf("%d",&cases);
	while(cases--)
	{
		long long x;
		scanf("%lld",&x);
		long long ans=(power(x,4))-(power((x-1),4));
		printf("%lld\n",ans);
	}
	return 0;
}
