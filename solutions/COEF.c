#include<stdio.h>
#include<stdlib.h>

long fact(int n)
{
	if(n==0)
		return 1;
	int fact=1;
	int i=n;
	for(i=n;i>=1;i--)
		fact*=i;
	return fact;
}

int main()
{
	int n,k;
	while(scanf("%d %d",&n,&k)!=EOF)
	{	
		long sum=1;
		long *x=(long*)malloc(sizeof(long)*k);
		int i=0;
		for(i=0;i<k;i++)
		{
			scanf("%ld",&x[i]);
			sum*=fact(x[i]);
		}
		long res=fact(n)/sum;
		printf("%ld\n",res);
	}
	return 0;
}
