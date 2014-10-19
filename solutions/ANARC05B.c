#include<stdio.h>
#include<stdlib.h>
#define BILLION 10000000

int main(void)
{
	int nh1,nh2,i,j;
	while(1)
	{
		scanf("%d",&nh1);
		if(nh1==0)
			break;
		long *h1=(long*)malloc(sizeof(long)*(nh1+1));
		for(i=0;i<nh1;i++)
			scanf("%ld",&h1[i]);
		h1[i]=BILLION;
		scanf("%d",&nh2);
		long *h2=(long*)malloc(sizeof(long)*(nh2+1));
		for(i=0;i<nh2;i++)
			scanf("%ld",&h2[i]);
		h2[i]=BILLION;
		long sum1=0,sum2=0;
		long sum=0;
		i=0,j=0;
		while(h1[i]<BILLION || h2[j]<BILLION)
		{
			if(h1[i]<h2[j])
				sum1+=h1[i++];
			else if(h2[j]<h1[i])
				sum2+=h2[j++];
			else
			{
				sum+=(sum1>sum2)?sum1:sum2;
				sum+=h1[i];
				sum1=sum2=0;
				++i;
				++j;
			}
		}
		printf("%ld\n",sum+((sum1>sum2)?sum1:sum2));
	}
	return 0;
}
