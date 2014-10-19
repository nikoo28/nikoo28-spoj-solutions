#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>

char *mulby2(char s[])
{
	int l1=strlen(s);
	char *res=(char*)malloc(sizeof(char)*(l1+2));
	res[0]='\0';
	int carry=0;
	int counter=l1;
	res[l1+1]='\0';
	int i,number,num;
	for(i=(l1-1);i>=0;i--)
	{
		num=s[i]-'0';
		number=(2*num)+carry;
		if(number>=10)
		{
			res[counter--]=(char)((number%10)+(int)'0');
			carry=1;
		}
		else
		{
			res[counter--]=(char)(number+(int)'0');
			carry=0;
		}
	}
	if(carry==1)
		res[0]='1';
	else
		res[0]='\0';
	if(res[0]=='\0')
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
	char num[2000];
	while((scanf("%s",num))!=EOF)
	{
		if(num[0]=='1' && num[1]=='\0')
		{
			printf("1\n");
			continue;
		}
		if(num[0]=='0' && num[1]=='\0')
		{
			printf("0\n");
			continue;
		}
		char *x=mulby2(num);
		char *two=(char*)malloc(sizeof(char)*2);
		two[0]='2';
		two[1]='\0';
		char *ans=subtractor(x,two);
		printf("%s\n",ans);
	}
	return 0;
}
