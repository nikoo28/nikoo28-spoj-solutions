#include<stdio.h>
#include<stdlib.h>

int sumofdig(long long n)
{
	int sum=0;
	while(n!=0)
	{
		sum+=((n%10)*(n%10));
		n=n/10;
	}
	return sum;
}

int main(void)
{
	unsigned long long n;
	scanf("%lld",&n);
	int x=sumofdig(n);
	int count=1;
	int num[40]={0};
	int i=0,arc=0;
	while(x!=1)
	{
		x=sumofdig(x);
		for(i=0;i<40;i++)
			if(x==num[i])
			{
				count=-1;
				goto ab;
			}
		count++;
		num[arc++]=x;
	}
ab:	printf("%d",count);
	return 0;
}
