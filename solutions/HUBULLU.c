#include<stdio.h>
#include<stdlib.h>

int main()
{
	int cases;
	scanf("%d",&cases);
	while(cases--)
	{
		long long x;
		int i;
		scanf("%lld %d",&x,&i);
		if(i==0)
			printf("Airborne wins.\n");
		else
			printf("Pagfloyd wins.\n");
	}
	return 0;
}
