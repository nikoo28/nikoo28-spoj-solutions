#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<ctype.h>
#include<string.h>

void reverse(char str[])
{
	int i,j,c;
	
	for(i=0,j=(strlen(str)-1);i<j;i++,j--)
	{
		c=str[i];
		str[i]=str[j];
		str[j]=c;
	}
}

void itoa(int n, char s[])
{
	int i,sign;
	
	if((sign=n)<0)				//Record sign
		n=-n;					//Making the number positive
	i=0;
	do
	{							//to generate digits in reverse order
		s[i++]=n%10+'0';
	}while((n/=10)>0);
	if(sign<0)
		s[i++]='-';
	s[i]='\0';
	reverse(s);
}

int main(void)
{
	int cases;
	scanf("%d",&cases);
	while(cases--)
	{
		char a1[100];
		scanf(" %[^\n]s",a1);
		char e1[10],e2[10];
		int i=0;
		int j=0;
		while(a1[i]!=' ')
		{
			e1[j++]=a1[i++];
		}
		e1[j]='\0';
		j=0;
		i++;
		while(a1[i])
			e2[j++]=a1[i++];
		e2[j]='\0';
		j=0;
		int num1=0;
		int num2=0;
		int temp=0;
		while(e1[j])
		{
			temp=1;
			int asc=(int)e1[j++];
			if(asc>49 && asc<58)
			{
				temp=asc-48;
				asc=(int)e1[j++];
				if(asc==109)
					temp=temp*1000;
				if(asc==99)
					temp=temp*100;
				if(asc==120)
					temp=temp*10;
				if(asc==105)
					temp=temp*1;
				num1+=temp;
				continue;
			}
			if(asc==109)
				temp=temp*1000;
			if(asc==99)
				temp=temp*100;
			if(asc==120)
				temp=temp*10;
			if(asc==105)
				temp=temp*1;
			num1+=temp;
		}
		j=0;
		while(e2[j])
		{
			temp=1;
			int asc=(int)e2[j++];
			if(asc>49 && asc<58)
			{
				temp=asc-48;
				asc=(int)e2[j++];
				if(asc==109)
					temp=temp*1000;
				if(asc==99)
					temp=temp*100;
				if(asc==120)
					temp=temp*10;
				if(asc==105)
					temp=temp*1;
				num2+=temp;
				continue;
			}
			if(asc==109)
				temp=temp*1000;
			if(asc==99)
				temp=temp*100;
			if(asc==120)
				temp=temp*10;
			if(asc==105)
				temp=temp*1;
			num2+=temp;
		}
		int res=num1+num2;
		char s[6];
		itoa(res,s);
		int len=strlen(s);
		if(len==4)
		{
			temp=s[0]-'0';
			if(temp==1)
				printf("m");
			else if(temp>1 && temp<10)
				printf("%dm",temp);
			temp=s[1]-'0';
			if(temp==1)
				printf("c");
			else if(temp>1 && temp<10)
				printf("%dc",temp);
			temp=s[2]-'0';
			if(temp==1)
				printf("x");
			else if(temp>1 && temp<10)
				printf("%dx",temp);
			temp=s[3]-'0';
			if(temp==1)
				printf("i");
			else if(temp>1 && temp<10)
				printf("%di",temp);
		}
		if(len==3)
		{
			temp=s[0]-'0';
			if(temp==1)
				printf("c");
			else if(temp>1 && temp<10)
				printf("%dc",temp);
			temp=s[1]-'0';
			if(temp==1)
				printf("x");
			else if(temp>1 && temp<10)
				printf("%dx",temp);
			temp=s[2]-'0';
			if(temp==1)
				printf("i");
			else if(temp>1 && temp<10)
				printf("%di",temp);
		}
		if(len==2)
		{
			temp=s[0]-'0';
			if(temp==1)
				printf("x");
			else if(temp>1 && temp<10)
				printf("%dx",temp);
			temp=s[1]-'0';
			if(temp==1)
				printf("i");
			else if(temp>1 && temp<10)
				printf("%di",temp);
		}
		if(len==1)
		{
			temp=s[0]-'0';
			if(temp==1)
				printf("i");
			else if(temp>1 && temp<10)
				printf("%di",temp);
		}
		printf("\n");
	}
	return 0;
}
