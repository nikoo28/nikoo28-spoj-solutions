#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void exchange(int *a,int *b)
{
	int temp;
	temp=*a;
	*a=*b;
	*b=temp;
}

int partition(int A[],int B[],int si,int ei)
{
	int x=A[ei];
	int i=(si-1);
	int j;
	for(j=si;j<=ei-1;j++)
		if(A[j]>=x)
		{
			i++;
			exchange(&A[i],&A[j]);
			exchange(&B[i],&B[j]);
		}
	exchange(&A[i+1],&A[ei]);
	exchange(&B[i+1],&B[ei]);	
	return (i+1);
}

void quick(int A[],int B[],int si,int ei)
{
	int pi;
	if(si<ei)
	{
		pi=partition(A,B,si,ei);
		quick(A,B,si,pi-1);
		quick(A,B,pi+1,ei);
	}
}

char shift(char x,int num)
{
	int p=(int)x;
	int newc=p-num;
	if(newc>64)
		return (char)newc;
	newc=65-newc;
	newc=91-newc;
	return (char)newc;
}

int main()
{
	int cases;
	scanf("%d",&cases);
	while(cases--)
	{
		char str[2000];
		scanf(" %[^\n]s",str);
		int vals[26]={0};
		int i=0;
		int chars[26]={0};
		i=0;
		for(i=65;i<91;i++)
			chars[i-65]=i;
		int x=strlen(str);
		str[x]='*';
		str[x+1]='\0';
		i=0;
		while(str[i]!='*')
		{
			if(str[i]==' ')
				i++;
			else
			{
				x=(int)str[i];
				vals[x-65]++;
				i++;
			}
		}
		quick(vals,chars,0,25);
		if(vals[0]==vals[1])
		{
			printf("NOT POSSIBLE\n");
			continue;
		}
		x=(int)chars[0];
		int cipher=0;
		if(x>69)
			cipher=x-69;
		else
		{
			cipher=69-x;
			cipher=26-cipher;
		}
		if(cipher==26)
			cipher=0;
		printf("%d ",cipher);
		i=0;
		while(str[i]!='*')
		{
			if(str[i]==' ')
				printf(" ");
			else
				printf("%c",shift(str[i],cipher));
			i++;
		}
		printf("\n");
	}
	return 0;
}
