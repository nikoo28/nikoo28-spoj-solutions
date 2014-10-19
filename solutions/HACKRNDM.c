#include<stdio.h>
#include<stdlib.h>

int main()
{
	long long n,k;
	scanf("%lld %lld",&n,&k);
	long long *vals=(long long*)malloc(sizeof(long long)*(n+1));
	long long count[900000];
	long long i,x,y,z,total=0;
	for(i=0;i<n;i++)
	{
		scanf("%lld",&vals[i]);
		count[vals[i]]=1;
	}
	for(i=0;i<n;i++)
	{
		x=vals[i];
		y=x+k;
		z=x-k;
		if(count[y]==1)
			total++;
		if(count[z]==1)
			total++;
	}
	printf("%lld\n",(total/2));
	return 0;
}
