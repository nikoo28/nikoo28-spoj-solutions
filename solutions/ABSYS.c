#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>

int main(void)
{
	int cases;
	scanf("%d",&cases);
	long a,b,c;
	int counter=0;
	int allocate=0;
	while(cases--)
	{
		scanf(" ");
		scanf("\n");
		a=-1,b=-1,c=-1;
		counter=0;
		char str[100];
		scanf("%[^\n]s",str);
//		gets(str);
		int flag=0;
		char *astr=(char*)malloc(sizeof(char)*50);
		char *bstr=(char*)malloc(sizeof(char)*50);
		char *cstr=(char*)malloc(sizeof(char)*50);
		while(str[counter]!='\0')
		{
			flag=0,allocate=0;
			while(str[counter]!=' ')
			{
				if(str[counter]=='m')
					flag=1;
				else
					astr[allocate++]=str[counter];
				counter++;
			}
			if(flag==1)
				a=-1;
			else
			{
				astr[allocate]='\0';
				a=atoi(astr);
			}
			counter+=3;
			allocate=0,flag=0;
			while(str[counter]!=' ')
			{
				if(str[counter]=='m')
					flag=1;
				else
					bstr[allocate++]=str[counter];
				counter++;
			}
			if(flag==1)
				b=-1;
			else
			{
				bstr[allocate]='\0';
				b=atoi(bstr);
			}
			counter+=3;
			allocate=0,flag=0;
			while(str[counter]!='\0')
			{	
				if(str[counter]=='m')
					flag=1;
				else
					cstr[allocate++]=str[counter];
				counter++;
			}
			if(flag==1)
				c=-1;
			else
			{
				cstr[allocate]='\0';
				c=atoi(cstr);
			}
		}
		if(a==-1)
			a=c-b;
		else if(b==-1)
			b=c-a;
		else if(c==-1)
			c=b+a;
		printf("%ld + %ld = %ld",a,b,c);
		printf("\n");
	}
	return 0;
}
