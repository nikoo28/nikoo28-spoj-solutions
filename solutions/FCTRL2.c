#include<stdio.h>
#include<stdlib.h>
int size;
int nod(int);
void intcon(int *,int);
void intadd(int *,int *);
void setzero(int *);
void intcpy(int *,int *);
int main()
{
    int i,n,j;
    int *fact;
    int *n1;
    int cases;
    scanf("%d",&cases);
    while(cases--)
    {
		scanf("%d",&n);
		size=nod(n);
		//printf("%d\n",size);
		fact=(int*) malloc(size*sizeof(int));
		n1=(int*) malloc(size*sizeof(int));
		setzero(fact);
		setzero(n1);
		intcon(n1,n);
		for(i=n-1;i>1;i--)
		{
		    intcpy(fact,n1);
		    for(j=1;j<i;j++)
		    {
		        intadd(n1,fact);
		    }
		}
		i=0;
		while (n1[i]==0)
		{
		    i++;
		}
		while(i<size)
		{
		    printf("%d",n1[i]);
		    i++;
		}
		printf("\n");
	}
    return(0);
}
int nod(int n)
{
        int bakp,i,bakn;
    bakn=n;
    int p=0;
    while(n!=0)
    {
        n=n/10;
        p=p+1;
    }
    p++;
        bakp=p;
        for(i=0;i<bakn-1;i++)
        {
        p=p+bakp;
    }
    return(p);
}
void intcon(int *z,int f)
{
    int i;
    for(i=size-1;i>=0;i--)
    {
        *(z+i)=f%10;
        f=f/10;
    }
    return;
}
void setzero(int *z)
{
    int i;
    for(i=0;i<size;i++)
    {
        *(z+i)=0;
    }
    return;
}
void intadd(int *p,int *q)
{
    int i;
    int f,carry=0;
    for(i=size-1;i>=0;i--)
    {
        f=(*(p+i))+(*(q+i))+carry;
        *(p+i)=f%10;
        carry=f/10;
    }
    return;
}
void intcpy(int *p,int *q)
{
    int i;
    for(i=size-1;i>=0;i--)
    {
        *(p+i)=*(q+i);
    }
    return;
}
