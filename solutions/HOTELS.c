#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	long N,M;
	scanf("%ld",&N);
	scanf("%ld",&M);
	long *hotels=(long*)malloc(sizeof(long)*N);
	long i;
	for(i=0;i<N;i++)
		scanf("%ld",&hotels[i]);
	long val=0;
	long maxval=val;
	long left=0,right=0;
	while(1)
	{
		while(val<=M && right<N)
		{
			val+=hotels[right++];
			if(val>maxval && val<=M)
				maxval=val;
		}
	
		while(val>=M && left<right)
		{
			val-=hotels[left++];
			if(val>maxval && val<=M)
				maxval=val;
		}

		if(right==N)
			break;
	}
	printf("\n%ld\n",maxval);
	return 0;
}
