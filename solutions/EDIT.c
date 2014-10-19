#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(void)
{
	char str[2000];
	char x;
	int len;
	int count1,count2,i;
	while(scanf("%s",str)!=EOF)
	{
		if(strlen(str)==1)
		{
			printf("0\n");
			continue;
		}
		len=strlen(str);
		if(strlen(str)%2!=0)
		{
			x=str[(strlen(str)-1)];
			str[(strlen(str)-1)]='\0';
		}
		i=0,count1=0,count2=0;
		while(str[i]!='\0')
		{
			if(((int)str[i])>=(int)'a' && ((int)str[i])<=(int)'z')
				count1++;
			if(((int)str[i+1])>=(int)'A' && ((int)str[i+1])<=(int)'Z')
				count1++;
			i+=2;
		}
		i=0;
		while(str[i]!='\0')
		{
			if(((int)str[i])>=(int)'A' && ((int)str[i])<=(int)'Z')
				count2++;
			if(((int)str[i+1])>=(int)'a' && ((int)str[i+1])<=(int)'z')
					count2++;
			i+=2;
		}
		if(len%2!=0)
		{
			if(((int)x)>=(int)'a' && ((int)x)<=(int)'z')
				count1++;
			if(((int)x)>=(int)'A' && ((int)x)<=(int)'Z')
				count2++;
		}		
		printf("%d\n",(count1>count2?count2:count1));
	}
	return 0;
}
