#include<stdio.h>
#include<stdlib.h>

const long long ending[]={192ll,442ll,692ll,942ll};

int main(void)
{
	int cases;
	scanf("%d",&cases);
	int i;
	long long k;
	for(i=0;i<cases;i++)
	{
		scanf("%lld",&k);
		k--;
		printf("%lld\n",1000ll*(k/4ll)+ending[k%4ll]);
	}
	return 0;
}
