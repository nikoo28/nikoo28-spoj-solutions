#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	int cases;
	scanf("%d",&cases);
	long sum;
	long num;
	long i;
	while(cases--)
	{
		scanf("%ld",&num);
		i=1,sum=0;
		if(num==1)
			goto ab;
		for(i=2;(i*i)<=num;i++)
			if(num%i==0)
			{
				sum+=i;
				if((i*i)!=num)
					sum+=(num/i);
			}
		sum+=1;
ab:		printf("%ld\n",sum);
	}
	return 0;
}
