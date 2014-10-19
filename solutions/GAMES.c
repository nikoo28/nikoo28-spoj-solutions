#include<stdio.h>
#include<stdlib.h>
#include<math.h>

struct type{
	int digits;
	long number;
};

long gcd(long a,long b)				// to get the gcd
{
	if(b==0)
		return a;
	else
		return gcd(b,a%b);
}

long lcm(long a,long b)				// to get lcm
{
	long x=gcd(a,b);
	return ((a*b)/x);
}

struct type extract(char *str)		// to get the number after decimal
{
	int flag=0;
	struct type my;
	my.digits=0;
	my.number=0;
	while(*str!='.' && *str)
	{
		str++;
		if(*str=='.')
			flag=1;
	}
	if(flag==0)
		return my;
	str++;
	while(*str && my.digits<4)
	{
		my.number=(my.number*10)+(*str-'0');
		my.digits++;
		str++;
	}
	return my;
}

int main(void)
{
	int cases;
	scanf("%d",&cases);
	while(cases--)
	{
		long num;
		char a[20];
		scanf("%s",a);
		struct type work=extract(a);
		if(work.number==0)
		{
			printf("1\n");
			continue;
		}
		long other=10;
		int i=1;
		for(i=1;i<work.digits;i++)
			other*=10;
		long lc=lcm(work.number,other);
		printf("%ld\n",(lc/work.number));
	}
	return 0;
}
