#include<stdio.h>
#include<stdlib.h>

int ismatch(char *a,char *str)
{
	if(a[0]==str[0] && a[1]==str[1] && a[2]==str[2])
		return 1;
	else
		return 0;
}

int main(void)
{
	int cases,xp;
	scanf("%d",&cases);
	while(cases--)
	{
		scanf("%d",&xp);
		char *seq=(char*)malloc(sizeof(char)*42);
		scanf(" %[^\n]s",seq);
		char *s[8]={"TTT","TTH","THT","THH","HTT","HTH","HHT","HHH"};
		int i,j;
		int count[8]={0};
		printf("%d",xp);
		for(i=0;i<8;i++)
		{
			for(j=0;j<38;j++)
				if((ismatch(s[i],(seq+j))))
					count[i]++;
			printf(" %d",count[i]);
		}
		printf("\n");
	}
	return 0;
}
