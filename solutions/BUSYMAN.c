#include<stdio.h>
#include<stdlib.h>

void exchange(long *a,long *b)
{
	long temp;
	temp=*a;
	*a=*b;
	*b=temp;
}

long partition(long A[],long B[],long si,long ei)
{
	long x=A[ei];
	long i=(si-1);
	long j;
	for(j=si;j<=ei-1;j++)
		if(A[j]<=x)
		{
			i++;
			exchange(&A[i],&A[j]);
			exchange(&B[i],&B[j]);
		}
	exchange(&A[i+1],&A[ei]);
	exchange(&B[i+1],&B[ei]);
	return (i+1);
}

void quick(long A[],long B[],long si,long ei)
{
	long pi;
	if(si<ei)
	{
		pi=partition(A,B,si,ei);
		quick(A,B,si,pi-1);
		quick(A,B,pi+1,ei);
	}
}

int main(void)
{
	int cases;
	scanf("%d",&cases);
	long jobs,k,max,jobcount;
	while(cases--)
	{
		scanf("%ld",&jobs);
		jobcount=0;
		long *start=(long*)malloc(sizeof(long)*jobs);
		long *end=(long*)malloc(sizeof(long)*jobs);
		for(k=0;k<jobs;k++)
			scanf("%ld %ld",&start[k],&end[k]);
		quick(end,start,0,(jobs-1));
		max=end[0];
		jobcount++;
		for(k=1;k<jobs;k++)
			if(start[k]>=max)
			{
				max=end[k];
				jobcount++;
			}
		printf("%ld\n",jobcount);
	}
	return 0;
}
