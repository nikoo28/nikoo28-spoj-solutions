#include<stdio.h>
#include<stdlib.h>

int main()
{
	int cases;
	scanf("%d",&cases);
	while(cases--)
	{
		long n,i;
		scanf("%ld",&n);
		int *num=(int*)malloc(sizeof(int)*(n+3));
		for(i=0;i<n;i++)
			scanf("%d",&num[i]);
		int flag=0,x,y;
		long vals[10]={0};
		i=(n-1);
		while(i>0)
		{
			vals[num[i]]++;
			x=num[i-1];
			if(x==9)
			{
				i--;
				continue;
			}
			for(y=x+1;y<10;y++)
				if(vals[y]>0)
				{
					vals[x]++;
					x=y;
					vals[y]--;
					flag=1;
					break;
				}
			if(flag==1)
				break;
			i--;
		}
		if(flag==0)
		{
			printf("-1\n");
			continue;
		}
		for(y=0;y<(i-1);y++)
			printf("%d",num[y]);
		printf("%d",x);
		for(x=0;x<10;x++)
			for(y=0;y<vals[x];y++)
				printf("%d",x);
		printf("\n");
	}
	return 0;
}
