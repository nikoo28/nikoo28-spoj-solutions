#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<ctype.h>
#include<string.h>
#define LLU long long unsigned int
#define LLD long long double
#define FOR(i,N) for(i=0;i<(N);i++)
int one[5010],two[5010],ways[5010];
int main()
{
	int N;
	char *str=(char*)malloc(sizeof(char)*5000);
	int i;
	while(1)
	{
		scanf("%s",str);
		if(str[0]=='0')
			break;
		N=strlen(str);
		if(N<2)
		{
			printf("1");
			goto ab;
		}
		FOR(i,N)
			one[i]=str[i]-'0';
		for(i=1;i<N;i++)
			two[i]=10*one[i-1]+one[i];
		ways[0]=1;
		if(one[1])
			ways[1]=1;
		else
			ways[1]=0;
		if(two[1]>9 && two[1]<27)
			ways[1]++;
		for(i=2;i<N;i++)
		{
			if(one[i])
				ways[i]=ways[i-1];
			else
				ways[i]=0;
			if(two[i]>9 && two[i]<27)
				ways[i]+=ways[i-2];
		}
		printf("%d",ways[N-1]);
ab:		printf("\n");
	}
}
