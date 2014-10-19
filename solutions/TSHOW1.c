#include<stdio.h>
#include<stdlib.h>
#include<math.h>

long long power(long long x, long long y)
{
    long long temp;
    if( y == 0)
        return 1;
    temp = power(x, y/2);
    if (y%2 == 0)
        return temp*temp;
    else
        return x*temp*temp;
}

void printer(int a[],int len)
{
	int i;
	for(i=0;i<len;i++)
		printf("%d",a[i]);
}

int main(void)
{
	int cases;
	scanf("%d",&cases);
	while(cases--)
	{
		long long k;
		scanf("%lld",&k);
		long long loc=k;
		long long x=0;
		long long i=1;
		while(x<k)
		{
			x+=power(2,i);
			loc-=power(2,i);
			i++;
		}
		loc+=power(2,(i-1));
		i--;
		int *ans=(int*)malloc(sizeof(int)*i);
		int track=i-1;
		long long num=1;
		double a;
		int b=0;
		while(track>-1)
		{
			a=(double)loc/num;
			b=ceil(a);
			if(b%2==0)
				ans[track]=6;
			else
				ans[track]=5;
			num=2*num;
			track--;
		}
		printer(ans,i);
		printf("\n");
	}
	return 0;
}
