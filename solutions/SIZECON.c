#include<stdio.h>
int main()
{
	long n,s=0;
	scanf("%ld",&n);
	while(scanf("%ld",&n)!=EOF)
		if(n>0)
			s+=n;
	printf("%ld",s);
	return 0;
}
