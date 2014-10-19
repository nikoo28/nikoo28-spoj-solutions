#include<ctype.h>
#include<stdio.h>

int first[1024],second[1024];
int operator;

void read_expression(void)
{
	static int input[1024];
	int len,c,i;
	while(!isdigit(c=getchar()));
	input[0]=c;
	len=1;
	while(isdigit(c=getchar()))
		input[len++]=c;
	first[0]=len;
	for(i=0;i<len;i++)
		first[len-i]=input[i]-'0';
	while((c!='+') && (c!='-') && (c!='*'))
		c=getchar();
	operator=c;
	while(!isdigit(c=getchar()));
	input[0]=c;
	len=1;
	while(isdigit(c=getchar()))
		input[len++]=c;
	second[0]=len;
	for(i=0;i<len;i++)
		second[len-i]=input[i]-'0';
}

void add(int sum[],int a[],int b[])
{
	int i,carry=0;
	for(i=1;(i<=a[0]) || (i<=b[0]);i++)
	{
		sum[i]=carry;
		if(i<=a[0])
			sum[i]+=a[i];
		if(i<=b[0])
			sum[i]+=b[i];
		if(sum[i]>9)
		{
			sum[i]-=10;
			carry=1;
		}
		else
			carry=0;
	}
	if(carry)
		sum[i++]=carry;
	sum[0]=i-1;
}

void sub(int dif[],int a[],int b[])
{
	int i,borrow=0;
	for(i=1;i<=a[0];i++)
	{
		dif[i]=a[i]-borrow;
		if(i<=b[0])
			dif[i]-=b[i];
		if(dif[i]<0)
		{
			dif[i]+=10;
			borrow=1;
		}
		else
			borrow=0;
	}
	i--;
	while((i>1) && (dif[i]==0))
		i--;
	dif[0]=i;
}

void intmul(int prod[],int a[],int n)
{
	int i,carry=0;
	if((n==0) || ((a[0]==1) && (a[1]==0)))
	{
		prod[0]=1;
		prod[1]=0;
		return;
	}
	for(i=1;(i<=a[0]) || carry;i++)
	{
		prod[i]=carry;
		if(i<=a[0])
			prod[i]+=a[i]*n;
		carry=prod[i]/10;
		prod[i]%=10;
	}
	prod[0]=i-1;
}

void add_shifted(int a[],int b[],int shift)
{
	int i,carry=0;
	for(i=1;(i<=a[0]) || (i<=b[0]+shift) || carry;i++)
	{
		if(i<=a[0])
			a[i]+=carry;
		else
			a[i]=carry;
		if((i>shift) && (i<=b[0]+shift))
			a[i]+=b[i-shift];
		if(a[i]>9)
		{
			a[i]-=10;
			carry=1;
		}
		else
			carry=0;
	}
	i--;
	while((i>1) && (a[i]==0))
		i--;
	a[0]=i;
}

int middle[500][1024];
int middles;
int last[1024];

void fullmul(int a[],int b[])
{
	int i;
	for(i=0;i<b[0];i++)
		intmul(middle[i],a,b[i+1]);
	if((middles=i)==1)
		return;
	for(i=0;i<=middle[0][0];i++)
		last[i]=middle[0][i];
	for(i=1;i<middles;i++)
		add_shifted(last,middle[i],i);
}

void print_num(int n[])
{
	int i;
	for(i=n[0];i>0;i--)
		putchar(n[i]+'0');
}

void print_spaces(int n)
{
	while(n--)
		putchar(' ');
}

void print_results(void)
{
	int i;
	int len;
	int hyphens;
	
	len=(first[0]>second[0])?first[0]:second[0]+1;
	for(i=0;i<middles;i++)
		if(middle[i][0]+i>len)
			len=middle[i][0]+i;
	if(middles>1)
		if(last[0]>len)
			len=last[0];
			
	print_spaces(len-first[0]);
	print_num(first);
	putchar('\n');
	print_spaces(len-second[0]-1);
	putchar(operator);
	print_num(second);
	putchar('\n');
	hyphens=(middle[0][0]>second[0])?middle[0][0]:second[0]+1;
	print_spaces(len-hyphens);
	while(hyphens--)
		putchar('-');
	putchar('\n');
	for(i=0;i<middles;i++)
	{
		print_spaces(len-middle[i][0]-i);
		print_num(middle[i]);
		putchar('\n');
	}
	if(middles>1)
	{
		hyphens=(last[0]>middle[middles-1][0]+middles-1)?last[0]:middle[middles-1][0]+middles-1;
		print_spaces(len-hyphens);
		while(hyphens--)
			putchar('-');
		putchar('\n');
		print_spaces(len-last[0]);
		print_num(last);
		putchar('\n');
	}
}

int main(void)
{
	int cases,caseno;
	
	scanf("%d",&cases);
	for(caseno=0;caseno<cases;caseno++)
	{
		read_expression();
		if(operator=='+')
		{
			add(middle[0],first,second);
			middles=1;
		}
		else if(operator=='-')
		{
			sub(middle[0],first,second);
			middles=1;
		}
		else fullmul(first,second);
		print_results();
		putchar('\n');
	}
	return 0;
}
