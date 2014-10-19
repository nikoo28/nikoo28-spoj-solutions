#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	long long i,j;
	long long small,large;
	while(scanf("%lld",&i)!=EOF)
	{
		scanf("%lld",&j);
		long long counter=1;
		small=(i<j)?i:j;
		large=(i>j)?i:j;
		long long max=0;
		long long ip,num;
		for(ip=small;ip<=large;ip++)
		{
			num=ip;
			counter=1;
			while(num!=1)
			{
				if(num%2==0)
					num=num/2;
				else
					num=(num*3)+1;
				counter++;
			}
			if(max<counter)
				max=counter;
		}
		printf("%lld %lld %lld\n",i,j,max);
	}
	return 0;
}
