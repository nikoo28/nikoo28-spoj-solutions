#include<stdio.h>
#include<stdlib.h>

void exchange(long long *a,long long *b)
{
	long temp;
	temp=*a;
	*a=*b;
	*b=temp;
}

long long partition(long long A[],long long si,long long ei)
{
	long long x=A[ei];
	long long i=(si-1);
	long long j;
	for(j=si;j<=ei-1;j++)
		if(A[j]<=x)
		{
			i++;
			exchange(&A[i],&A[j]);
		}
	exchange(&A[i+1],&A[ei]);
	return (i+1);
}

void quick(long long A[],long long si,long long ei)
{
	long long pi;
	if(si<ei)
	{
		pi=partition(A,si,ei);
		quick(A,si,pi-1);
		quick(A,pi+1,ei);
	}
}

int main(void)
{
	long trees;
	scanf("%ld",&trees);
	long long req;
	scanf("%lld",&req);
	int flag=0;
	long long *hts=(long long*)malloc(sizeof(long long)*trees);
	long i;
	long long max=0;
	for(i=0;i<trees;i++)
	{
		scanf("%lld",&hts[i]);
		max+=hts[i];
	}
	if(req==0)
		goto ab;
	flag=1;
	quick(hts,0,(trees-1));
	long long blade=0;
	long long dec=trees;
	long col=0;
	while(max>req)
	{
		max=max-dec;
		blade++;
		while(blade==hts[col])
		{
			col++;
			dec--;
		}
	}
	if(max<req)
		blade--;
ab:	if(flag)
		printf("%lld",blade);
	else
		printf("0");
	return 0;
}
