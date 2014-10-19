#include<stdio.h>
#include<stdlib.h>

void exchange(int *a,int *b)
{
	int temp;
	temp=*a;
	*a=*b;
	*b=temp;
}

int partition(int A[],int si,int ei)
{
	int x=A[ei];
	int i=(si-1);
	int j;
	for(j=si;j<=ei-1;j++)
		if(A[j]<=x)
		{
			i++;
			exchange(&A[i],&A[j]);
		}
	exchange(&A[i+1],&A[ei]);
	return (i+1);
}

void quick(int A[],int si,int ei)
{
	int pi;
	if(si<ei)
	{
		pi=partition(A,si,ei);
		quick(A,si,pi-1);
		quick(A,pi+1,ei);
	}
}

int main(void)
{
	int cases;
	scanf("%d",&cases);
	long hotness;
	int i,participants,j;
	for(i=0;i<cases;i++)
	{
		participants=0;
		hotness=0;
		scanf("%d",&participants);
		int *men=(int*)malloc(sizeof(int)*participants);
		int *women=(int*)malloc(sizeof(int)*participants);
		for(j=0;j<participants;j++)
			scanf("%d",&men[j]);
		for(j=0;j<participants;j++)
			scanf("%d",&women[j]);
		quick(men,0,(participants-1));
		quick(women,0,(participants-1));
		for(j=0;j<participants;j++)
			hotness+=(men[j]*women[j]);
		printf("%ld\n",hotness);
	}
	return 0;
}
