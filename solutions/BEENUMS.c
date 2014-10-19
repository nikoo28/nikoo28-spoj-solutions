#include<stdio.h>
#include<stdlib.h>
int main(void)
{
	long long i;
	while(1)
	{
		scanf("%lld",&i);
		if(i==-1)
			break;
		i--;
		if(i%3)
		{
			printf("N\n");
			continue;
		}
		i/=3;
		long long x=0;
		long long prod=0;
		for(x=0;x<1000000000;x++)
		{
			prod=x*(x+1);
			if(prod==i)
			{
				printf("Y\n");
				break;
			}
			else if(prod>i)
			{
				printf("N\n");
				break;
			}
		}
	}
	return 0;
}
