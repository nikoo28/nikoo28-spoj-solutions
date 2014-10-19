#include<stdio.h>

int last(int base,long long pow)
{
	short i,last,vals[10],cp=0,count=1;
	if(pow==0)
		return 1;
	if(base%10==0)
		return 0;
	else if(base%10==1)
		return 1;
	else
	{
		last=base%10;
		for(i=1;i<20;i++)
		{
			vals[cp++]=last;
			last=last*base%10;
			last=last%10;
			if(last==0)
				return 0;
			if(last==(base%10))
				break;
			count++;
		}
	}
	short rem=pow%count;
	if(rem==0)
		return vals[count-1];
	else
		return vals[rem-1];
}

int main(void)
{
	int cases;
	scanf("%d",&cases);
	int i,base;
	long long pow;
	for(i=0;i<cases;i++)
	{
		scanf("%d",&base);
		scanf("%lld",&pow);
		printf("%d\n",last(base,pow));
	}
	return 0;
}
