#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	unsigned long long n;
	scanf("%lld",&n);
	unsigned long long temp=2;
	int flag=1;
	while(temp<=n)
	{
		if(temp==n)
			flag=0;
		temp=temp*2;
	}
	if(n==1 || n==0)
		flag=0;
	if(flag==1)
		printf("NIE\n");
	else
		printf("TAK\n");
	return 0;
}
