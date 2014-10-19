#include<stdio.h>
#define BREAKER if(counter==lim) break;

int main(void)
{
	int cases;
	scanf("%d",&cases);
	int i;
	int x=0,y=0;
	long counter;
	long lim;
	for(i=0;i<cases;i++)
	{
		counter=1;
		x=1,y=1;
		scanf("%ld",&lim);
		while(counter!=lim)
		{
			BREAKER;
			y++;
			counter++;
			BREAKER;
			while(y!=1)
			{
				y--;
				x++;
				counter++;
				if(counter==lim)
					goto xy;
			}
			x++;
			counter++;
			BREAKER;
			while(x!=1)
			{
				x--;
				y++;
				counter++;
				if(counter==lim)
					goto xy;
			}
			BREAKER;
		}
xy:		printf("TERM %ld IS %d/%d",lim,x,y);
		printf("\n");
	}
	return 0;
}
