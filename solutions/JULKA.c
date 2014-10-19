#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char * divbynum(char s[],int num)
{	
	long x=strlen(s);
	long i;
	int dig;
	int rem=0;
	for(i=0;i<x;i++)
	{
		dig=(s[i]-'0')+(10*rem);
		rem=dig%num;
		dig=dig/num;
		s[i]=(char)(dig+(int)'0');			
	}
	i=0;
	while(s[i]=='0')
		s++;
	return s;
}

void * addbig(char a1[],char a2[])
{
	int l1=strlen(a1);
	int l2=strlen(a2);
	int l3;
	char *res;
	if(l1>=l2)
	{
		res=(char*)malloc(sizeof(char)*(l1+2));
		l3=l1+1;
	}
	else
	{
		res=(char*)malloc(sizeof(char)*(l2+2));
		l3=l2+1;
	}
	res[l3]='\0';
	l3--;l1--;l2--;
	int sum=0;
	int carry=0;
	int num1=0,num2=0;
	while(l1!=-1 || l2!=-1)
	{
		if(l1<=-1)
			num1=0;
		else
			num1=a1[l1]-'0';
		if(l2<=-1)
			num2=0;
		else
			num2=a2[l2]-'0';
		sum=num1+num2+carry;
		carry=sum/10;
		res[l3]=(char)((sum%10)+(int)'0');
		if(l1>-1)
			l1--;
		if(l2>-1)
			l2--;
		l3--;
	}
	res[l3]=(char)(carry+(int)'0');
	if(res[0]=='0')
		res++;
	return res;
}

char *subtractor(char a1[],char a2[])
{
	int l1=strlen(a1);
	int l2=strlen(a2);
	int l3;
	char *res;
	if(l1>=l2)
		l3=l1;
	else
		l3=l2;
	res=(char*)malloc(sizeof(char)*l3);
	res[l3]='\0';
	int xp=0;
	for(xp=0;xp<l3;xp++)
		res[xp]='0';
	l3--;
	l2--;
	l1--;
	int diff=0;
	int borrow=0;
	int num1=0,num2=0;
	while(l1!=-1 || l2!=-1)
	{
		if(l1<=-1)
			num1=0;
		else
		{
			num1=(a1[l1]-'0')-borrow;
			borrow=0;
		}
		if(l2<=-1)
			num2=0;
		else
			num2=a2[l2]-'0';
		diff=num1-num2;
		if(diff<0)
		{
			borrow=1;
			diff=(num1+10)-num2;
		}
		res[l3]=(char)(diff+(int)'0');
		if(l1>-1)
			l1--;
		if(l2>-1)
			l2--;
		l3--;
	}
	int i=0;
	while(res[i]=='0')
	{
		if(res[i+1]=='\0')
			break;
		else
			res++;
	}
	return res;
}

int main(void)
{
	int cases=10;
	char str1[1000];
	char str2[1000];
	while(cases--)
	{
		scanf("%s",str1);
		scanf("%s",str2);
		char *n=addbig(str1,str2);
		char *k=divbynum(n,2);
		printf("%s\n",k);
		char *p=subtractor(k,str2);
		printf("%s\n",p);
	}
	return 0;
}
