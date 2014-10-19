#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	unsigned long long num,i;
	int cases;
	scanf("%d",&cases);
	int flag=1;
	while(cases--)
	{
		scanf("%lld",&num);
		flag=1;
		if(num==2)
		{
			printf("YES\n");
			continue;
		}
		if(num%2==0)
		{
			printf("NO\n");
			continue;
		}		
		for(i=3;(i*i)<num;i+=2)
			if(num%i==0)
			{
				flag=0;
				break;
			}
		if(flag==1)
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}
