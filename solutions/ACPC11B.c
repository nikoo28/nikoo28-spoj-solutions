/*#include<stdio.h>
#include<stdlib.h>
#include<math.h>

void exchange(long *a,long *b)
{
	long temp;
	temp=*a;
	*a=*b;
	*b=temp;
}

long partition(long A[],long si,long ei)
{
	long x=A[ei];
	long i=(si-1);
	long j;
	for(j=si;j<=ei-1;j++)
		if(A[j]<=x)
		{
			i++;
			exchange(&A[i],&A[j]);
		}
	exchange(&A[i+1],&A[ei]);
	return (i+1);
}

void quick(long A[],long si,long ei)
{
	long pi;
	if(si<ei)
	{
		pi=partition(A,si,ei);
		quick(A,si,pi-1);
		quick(A,pi+1,ei);
	}
}

int main(void)
{
	int cases;
	scanf("%d",&cases);
	int i,j,k;
	int pA,pB;
	long mindiff,diff1,diff2;
	long newdiff,l;
	long sum=0;
	for(i=0;i<cases;i++)
	{
		mindiff=0;
		sum=0;
		scanf("%d",&pA);
		long *hA=(long*)malloc(sizeof(long)*pA);
		for(j=0;j<pA;j++)
			scanf("%ld",&hA[j]);
			
		scanf("%d",&pB);
		long *hB=(long*)malloc(sizeof(long)*pB);
		for(k=0;k<pB;k++)
			scanf("%ld",&hB[k]);
		sum=pA+pB;	
		quick(hA,0,(pA-1));
		quick(hB,0,(pB-1));
		
		j=0,k=0;
		mindiff=abs(hA[j]-hB[k]);
		diff1=mindiff;
		diff2=mindiff;
		
		for(l=0;l<sum;l++)
		{
			if((j+1)!=pA)
			{
				j++;
				diff1=abs(hA[j]-hB[k]);
			}
			if((k+1)!=pB)
			{
				k++;
				diff2=abs(hA[j]-hB[k]);
			}
			if(diff1<diff2)
				newdiff=diff1;
			else
				newdiff=diff2;
			if(newdiff<mindiff)
				mindiff=newdiff;
		}
		free(hA);
		free(hB);
		printf("%ld\n",mindiff);
	}
	return 0;
}*/
#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main(void)
{
	int cases;
	scanf("%d",&cases);
	int i,j,k;
	int pA,pB;
	long mindiff;
	long newdiff,l;
	long sum=0;
	for(i=0;i<cases;i++)
	{
		mindiff=0;
		sum=0;
		scanf("%d",&pA);
		long *hA=(long*)malloc(sizeof(long)*pA);
		for(j=0;j<pA;j++)
			scanf("%ld",&hA[j]);
			
		scanf("%d",&pB);
		long *hB=(long*)malloc(sizeof(long)*pB);
		for(k=0;k<pB;k++)
			scanf("%ld",&hB[k]);
		
		mindiff=abs(hA[0]-hB[0]);
		for(j=0;j<pA;j++)
		{
			for(k=0;k<pB;k++)
			{
				newdiff=abs(hA[j]-hB[k]);
				if(newdiff<mindiff)
					mindiff=newdiff;
			}
		}
		printf("%ld\n",mindiff);
		free(hA);
		free(hB);
	}
	return 0;
}
