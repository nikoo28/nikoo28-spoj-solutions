#include<stdio.h>
#include<stdlib.h>

int main()
{
	int cases,i;
	scanf("%d",&cases);
	long long health,min,sum,cokes,j;
	for(i=1;i<=cases;i++)
	{
		scanf("%lld",&cokes);
		long long *c=(long long*)malloc(sizeof(long long)*cokes);
		scanf("%lld",&c[0]);
		sum=c[0];
		min=sum;
		for(j=1;j<cokes;j++)
		{
			scanf("%lld",&c[j]);
			sum+=c[j];
			if(min>sum)
				min=sum;
		}
		health=(min>0)?1:((-1*min)+1);
		printf("Scenario #%d: %lld\n",i,health);
	}
	return 0;
}
