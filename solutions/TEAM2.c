#include<stdio.h>
#include<stdlib.h>
#include<math.h>

long max4(long arr[])
{
	long temp=0;
	if(arr[0]>=arr[1] && arr[0]>=arr[2] && arr[0]>=arr[3])
	{
		temp=arr[0];
		arr[0]=-1;
		return temp;
	}
	else if(arr[1]>=arr[0] && arr[1]>=arr[2] && arr[1]>=arr[3])
	{
		temp=arr[1];
		arr[1]=-1;
		return temp;
	}
	else if(arr[2]>=arr[0] && arr[2]>=arr[1] && arr[2]>=arr[3])
	{
		temp=arr[2];
		arr[2]=-1;
		return temp;
	}
	else
	{
		temp=arr[3];
		arr[3]=-1;
		return temp;
	}
}

int main(void)
{
	long a[4];
	int cases=0;
	while(scanf("%ld",&a[0])!=EOF)
	{
		cases++;
		scanf("%ld %ld %ld",&a[1],&a[2],&a[3]);
		long maxi=max4(a);
		maxi+=max4(a);
		printf("Case %d: %ld\n",cases,maxi);
	}
	return 0;
}
