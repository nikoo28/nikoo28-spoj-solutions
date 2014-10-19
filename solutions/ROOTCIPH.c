#include<stdio.h>
#include<stdlib.h>

int main()
{
	int cases;
	scanf("%d",&cases);
	long long a,b,c;
	while(cases--)
	{
		scanf("%lld %lld %lld",&a,&b,&c);
		long long res=(a*a)-(2*b);
		printf("%lld\n",res);
	}
	return 0;
}
