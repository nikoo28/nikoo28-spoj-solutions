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
	int a=1,d=1,i;
	scanf("%d %d",&a,&d);
	while(a && d)
	{
		int *b=(int*)malloc(sizeof(int)*a);
		int *c=(int*)malloc(sizeof(int)*d);
		for(i=0;i<a;i++)
			scanf("%d",&b[i]);
		for(i=0;i<d;i++)
			scanf("%d",&c[i]);
		quick(b,0,(a-1));
		quick(c,0,(d-1));
		if(c[1]>b[0])
			printf("Y\n");
		else
			printf("N\n");
		scanf("%d %d",&a,&d);
	}
	return 0;
}
