#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(void)
{
	int cases;
	scanf("%d",&cases);
	while(cases--)
	{
		int n,i;
		scanf("%d",&n);
		char m[3000];
		scanf("%s",m);
		scanf("%d",&i);
		char j[3000];
		scanf("%s",j);
		int len=strlen(m);
		int num=m[--len];
		len=strlen(j);
		int num2=j[--len];
		if((n & 1) && (num & 1))
		{
			if((i+num2)& 1)
				printf("Impossible.\n");
			else
				printf("Possible.\n");
		}
		else
			printf("Impossible.\n");
	}
	return 0;
}
