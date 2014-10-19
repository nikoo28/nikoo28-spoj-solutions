#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int ismirror(char s[],long temp)
{
	long left,right;
	if(strlen(s)%2==0)
	{
		left=temp-1;
		right=temp;
	}
	else
	{
		left=temp-2;
		right=temp;
	}
	while(right<strlen(s))
		if(s[right++]>s[left--])
			return 0;
	return 1;
}

int ispalin(char s[],long temp)
{
	long left,right;
	long start=0,end=strlen(s)-1;
	if(strlen(s)%2==0)
	{
		left=temp-1;
		right=temp;
	}
	else
	{
		left=temp-2;
		right=temp;
	}
	while(start<left)
		if((s[right++]!=s[left--]) || (s[start++]!=s[end--]))
			return 0;
	return 1;

}

void getpalin(char s[])
{
	long left,right;
	if((strlen(s))%2==0)
	{
		left=((strlen(s))/2)-1;
		right=((strlen(s))/2);
	}
	else
	{
		left=((((strlen(s))+1)/2))-2;
		right=((((strlen(s))+1)/2));
	}
	while(right<strlen(s))
		s[right++]=s[left--];
	printf("%s",s);
}

void nextpalin(char s[],char upper[],char lower[],long temp)
{
	long p=temp-1;
	int carry;
	if((ispalin(s,temp))==1)
		goto nc;
	if((ismirror(s,temp))==1)
	{
		getpalin(s);
		return;
	}
nc:	do
	{
		carry=0;
		if(((upper[p+1]-'0')+1)==10)
		{
			carry=1;
			upper[p+1]='0';
		}
		else
			upper[p+1]=(char)(((int)'0')+((upper[p+1]-'0')+1));		
		p--;
	}
	while(carry==1);
	if(upper[0]=='0')
		upper++;
	s=strcat(upper,lower);
	getpalin(s);
}

int main(void)
{
	int cases;
	scanf("%d",&cases);
	int i;
	long x,y,temp,len;
	for(i=0;i<cases;i++)
	{
		x=0,y=0;
		char *num=(char*)malloc(sizeof(char)*1000002);
		char *upper=(char*)malloc(sizeof(char)*500010);
		char *lower=(char*)malloc(sizeof(char)*500010);
		scanf("%s",num);
		len=strlen(num);
		if(len%2==0)
			temp=len/2;
		else
			temp=(len+1)/2;
		while(x<temp)
		{
			upper[x+1]=num[x];
			if(num[x+temp]!='\0')
				lower[y]=num[temp+x];
			x++;
			y++;
		}
		upper[0]='0';
		upper[x+1]='\0';
		lower[x]='\0';
		nextpalin(num,upper,lower,temp);
		free(num);
		free(upper);
		free(lower);
		printf("\n");
	}
	return 0;
}
