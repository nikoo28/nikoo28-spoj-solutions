#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	long n,jumps;
	scanf("%ld %ld",&n,&jumps);
	char *str=(char *)malloc(sizeof(char)*(jumps+1));
	scanf("%s",str);
	long long **arr=(long long **)calloc(sizeof(long long*),(n));
	long i,j;
	for(i=0;i<n;i++)
		arr[i]=(long long *)calloc(sizeof(long long),(n));
	long long counter=1;
	long row=0;
	long col=1;
	arr[row][0]=1;
	while(1)
	{
		if(row>(n-1) || col>(n-1))
			break;
		while(col>-1)
		{
			arr[row++][col--]=++counter;
			if(row==n)
			{
				row--;
				col++;
				break;
			}
		}
		col++;
		while(row>-1)
		{
			arr[row--][col++]=++counter;
			if(col==n)
			{
				col--;
				row++;
				break;
			}
		}
		row++;
	}
	long long sum=arr[0][0];
	i=0;j=0;
	while(*str)
	{
		switch(*str)
		{
			case 'U':
			i--;
			break;
			
			case 'L':
			j--;
			break;

			case 'R':
			j++;
			break;

			case 'D':
			i++;
			break;			
		}
		sum+=arr[i][j];
		str++;
	}
	printf("%lld",sum);
	return 0;
}
