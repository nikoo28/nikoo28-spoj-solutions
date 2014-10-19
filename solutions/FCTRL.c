#include<stdio.h>
int main(void)
{
	int cases;
	scanf("%d",&cases);
	int i=0;
	long num1,nums;
	long div=5;
	long count=0;
	for(i=0;i<cases;i++)
	{
		scanf("%ld",&num1);
		div=5;
		count=0;
		while((num1/div)>=1)
		{
			count+=(num1/div);
			div*=5;
		}
		printf("%ld\n",count);
//		zeroes(num1);
	}
	return 0;
}
