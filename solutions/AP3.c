#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main(void)
{
	int cases;
	scanf("%d",&cases);
	double a,b,c;
	double t3,tn,s;
	long long xt3,xtn,xs;
	double temp1,temp2;
	long long n,first;
	long long i,d;
	while(cases--)
	{
		scanf("%lld %lld %lld",&xt3,&xtn,&xs);
		t3=xt3;
		tn=xtn;
		s=xs;
		b=(-1*((7*t3)+(5*tn)+(2*s)));
		a=(t3+tn);
		c=(12*s);
		temp1=((b*b)-(4*a*c));
		temp1=sqrtl(temp1);
		temp2=((-1*b)+temp1)/(2*a);
		n=floor(temp2);
		printf("%lld\n",n);
		d=((xtn-xt3)/(n-6));
		first=xt3-(2*d);
		printf("%lld",first);
		for(i=1;i<n;i++)
		{
			first+=d;
			printf(" %lld",first);
		}
		printf("\n");
	}
	return 0;
}
