#include<stdio.h>
int main()
{
	int n,k,i,j,ctr=1;
	long long x[100],p,ans,c[1000];
	scanf("%d",&n);
	while(n!=-1)
	{
		for(i=n;i>=0;i--)
			scanf("%lld",&c[i]);
		scanf("%d",&k);
		for(i=0;i<k;i++)
			scanf("%lld",&x[i]);
		printf("Case %d:\n",ctr++);
		for(j=0;j<k;j++)
		{
			for(p=1,ans=i=0;i<=n;i++)
			{
				ans+=(p*c[i]);
				p*=x[j];
			}
			printf("%lld\n",ans);
		}
		scanf("%d",&n);
	}
	return 0;
} 

/*
#include<stdio.h>
#include<stdlib.h>

float power(float x, int y)
{
    float temp;
    if( y == 0)
       return 1;
    temp = power(x, y/2);      
    if (y%2 == 0)
        return temp*temp;
    else
    {
        if(y > 0)
            return x*temp*temp;
        else
            return (temp*temp)/x;
    }
}

int main(void)
{
	int maxcoff,xrange,i,j,cases=0;
	while(1)
	{
		scanf("%d",&maxcoff);
		if(maxcoff<0)
			break;
		int cs[1000];
		for(i=0;i<=maxcoff;i++)
			scanf("%d",&cs[i]);
		scanf("%d",&xrange);
		int xs[100];
		for(i=0;i<xrange;i++)
			scanf("%d",&xs[i]);
		long sum=0;
		printf("Case %d:\n",(++cases));
		for(i=0;i<xrange;i++)
		{
			for(j=0,sum=0;j<=maxcoff;j++)
				sum+=((cs[j])*(power(xs[i],(maxcoff-j))));
			printf("%ld\n",sum);
		}
	}
	return 0;
}

*/

/*#include<stdio.h>
#include<math.h>
#include<stdlib.h>

struct expnode{
	int data;
	int x;
	int coff;
	struct expnode *next;
};

struct expnode * append(struct expnode *tail,int c,int xval,int pow)
{
	struct expnode * temp=(struct expnode*)malloc(sizeof(struct expnode));
	temp->data=c;
	temp->x=xval;
	temp->coff=pow;
	temp->next=NULL;
	if(tail==NULL)
		return temp;
	tail->next=temp;
	tail=tail->next;
	return tail;
}

long evaluate(struct expnode *start)
{
	long sum=0;
	while(start)
	{
		sum+=((start->data)*(pow((start->x),(start->coff))));
		start=start->next;
	}
	return sum;
}

int main(void)
{
	int maxcoff;
	int xrange;
	int i,j;
	int cases=0;
	while(1)
	{
		scanf("%d",&maxcoff);
		if(maxcoff==-1)
			break;
		if(maxcoff==0)
		{
			printf("0\n");
			cases++;
			continue;
		}
		int *cs=(int *)malloc(sizeof(int)*(maxcoff+1));
		for(i=0;i<=maxcoff;i++)
			scanf("%d",&cs[i]);
		xrange=0;
		scanf("%d",&xrange);
		int *xs=(int*)malloc(sizeof(int)*xrange);
		for(i=0;i<xrange;i++)
			scanf("%d",&xs[i]);
		struct expnode *start=NULL;
		struct expnode *tail=NULL;
		long sum=0;
		printf("Case %d:\n",(cases++));
		for(i=0;i<xrange;i++)
		{
			start=NULL;
			tail=NULL;
			sum=0;
			for(j=0;j<=maxcoff;j++)
			{
				if(start==NULL)
				{
					start=append(start,cs[j],xs[i],(maxcoff-j));
					tail=start;
				}
				else
					tail=append(tail,cs[j],xs[i],(maxcoff-j));
			}
			sum=evaluate(start);
			printf("%ld\n",sum);
		}
	}
	return 0;
}*/

