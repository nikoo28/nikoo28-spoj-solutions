#include<stdio.h>
#include<stdlib.h>

long rectangles(int n)
{
	int base=1,height,count=0;
	while(1)
	{
		if((n%base)==0)
		{
			height=n/base;
			count++;
		}
		base++;
		if(base>height || base==height)
			break;
	}
	return count;
}

int main()
{
	int x,i;
	scanf("%d",&x);
	long *total=(long *)malloc(sizeof(long)*x);
	total[0]=1;
	for(i=1;i<x;i++)
		total[i]=total[i-1]+(rectangles(i+1));
	printf("%ld\n",total[x-1]);
	return 0;
}
