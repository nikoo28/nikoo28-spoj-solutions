#include<stdio.h>
#include<stdlib.h>
#include<math.h>

long gcd(long a,long b)
{
	int temp;
	while(b)
	{
		temp=a%b;
		a=b;
		b=temp;
	}
	return a;
}

int main(void)
{
	long cases,a,b,x;
	scanf("%ld",&cases);
	while(cases--)
	{
		scanf("%ld %ld",&a,&b);
		x=(a-b)/(gcd(((abs)(a)),((abs)(b))));
		if(x<0)
			x*=-1;
		printf("%ld\n",x);
	}
	return 0;
}	
