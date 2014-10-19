#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main(void)
{
	int cases;
	scanf("%d",&cases);
	long long W,V,u,U,v,w;
	long long X,Y,Z,x,y,z;
	double a,b,c,d;
	double volume;
	double temp1,temp2;
	while(cases--)
	{
		scanf("%lld%lld%lld%lld%lld%lld",&W,&V,&u,&U,&v,&w);
		X=(w-U+v)*(U+v+w);
		x=(U-v+w)*(v-w+U);
		Y=(u-V+w)*(V+w+u);
		y=(V-w+u)*(w-u+V);
		Z=(v-W+u)*(W+u+v);
		z=(W-u+v)*(u-v+W);
		a=sqrt((x*Y*Z));
		b=sqrt((y*Z*X));
		c=sqrt((z*X*Y));
		d=sqrt((x*y*z));
		temp1=((b+c+d-a)*(a-b+c+d)*(a+b-c+d)*(a+b+c-d));
		temp1=sqrt(temp1);
		temp2=192*u*v*w;
		volume=temp1/temp2;
		printf("%.4lf\n",volume);
	}
	return 0;
}
