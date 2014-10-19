#include <stdlib.h>
#include <stdio.h>

int main(void)
{
    long i,j,k;
    long from;
    long to;
    int cases;
	scanf("%d",&cases);
    for(k=0;k<cases;k++)
    {
	    scanf("%ld",&from);
	    scanf("%ld",&to);
	    long *sieve=(long*)malloc(sizeof(long)*to);
	    for(i=0;i<to;i++)
	    	sieve[i]=i+1;
	    for(i=2;(i*i)<to;i++)
	    	for(j=((i+i)-1);j<to;j+=i)
	    		if(sieve[j]%i==0)
	    			sieve[j]=0;
	    for(i=(from-1);i<to;i++)
	    	if(sieve[i]!=0)
	    		printf("%ld\n",sieve[i]);
	    free(sieve);
	}
    return 0;
}
