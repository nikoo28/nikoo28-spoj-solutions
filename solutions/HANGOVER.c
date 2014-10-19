#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	float val;
	scanf("%f",&val);
	int n;
	float sum;
	while(val!=0.00)
	{
		n=2;
		sum=0;
		while(sum<val)
		{
			sum+=((float)1/(n++));
		}
		printf("%d card(s)\n",(n-2));
		scanf("%f",&val);
	}
	return 0;
}
