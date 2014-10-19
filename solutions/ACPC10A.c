#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	long x,y,z;
	scanf("%ld",&x);
	scanf("%ld",&y);
	scanf("%ld",&z);
	while(x!=0 || y!=0 || z!=0)
	{
		if((2*y)==(x+z))
			printf("AP %ld\n",(z+(y-x)));
		else if((y*y)==(x*z))
			printf("GP %ld\n",(z*(y/x)));
		scanf("%ld",&x);
		scanf("%ld",&y);
		scanf("%ld",&z);
	}
	return 0;
}
