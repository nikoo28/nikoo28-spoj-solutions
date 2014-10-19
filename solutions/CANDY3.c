#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	long cases;
	scanf("%ld",&cases);
	long i;
	for(i=0;i<cases;i++)
	{
		long long students;
		long long mod=0;
		scanf("%lld",&students);
		long long candy;
		long long j;
		for(j=0;j<students;j++)
		{
			scanf("%lld",&candy);
			mod=(mod+candy)%students;
		}
		if(mod==0)
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}
