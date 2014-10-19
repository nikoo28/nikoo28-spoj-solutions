#include<stdio.h>
#include<stdlib.h>
#include<math.h>

unsigned long long fact(unsigned long long x)
{
	unsigned long long ans=1;
	unsigned long long i=x;
	for(i=x;i>=1;i--)
		ans=ans*i;
	return ans;
}

int main(void)
{
	unsigned long long n;
	scanf("%lld",&n);
	unsigned long long result=fact(n);
	result+=pow(2,n);
	result-=n;
	printf("%lld",result);
	return 0;
}
