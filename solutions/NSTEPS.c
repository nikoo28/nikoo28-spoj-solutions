#include <stdlib.h>
#include <stdio.h>

int main(void)
{
	int cases;
	scanf("%d",&cases);
	int i,x,y;
	for(i=0;i<cases;i++)
	{
		scanf("%d",&x);
		scanf("%d",&y);
		if(x>=y)
			if(x==y)
				if(x%2==0)
					printf("%d",(2*x));
				else
					printf("%d",((2*x)-1));
			else if((x-y)==2)
				if(x%2==0)
					printf("%d",(x+y));
				else
					printf("%d",((x+y)-1));
			else
				printf("No Number");
		else
			printf("No Number");
		printf("\n");
	}
	return 0;
}
