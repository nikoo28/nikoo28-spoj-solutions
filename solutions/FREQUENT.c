#include<stdio.h>
#include<stdlib.h>

void merge(long arr[],long temp[],long low1,long low2,long up1,long up2)
{
	long i=low1;
	long j=low2;
	long k=low1;
	while(i<=up1 && j<=up2)
		if(arr[i]>=arr[j])
			temp[k++]=arr[i++];
		else
			temp[k++]=arr[j++];
	while(i<=up1)
		temp[k++]=arr[i++];
	while(j<=up2)
		temp[k++]=arr[j++];
}

void copy(long arr[],long temp[],long low,long high)
{
	while(low<=high)
	{
		arr[low]=temp[low];
		low++;
	}
}

void mergesort(long arr[],long low,long high)
{
	long temp[100000];
	if(low<high)
	{
		long mid=(low+high)/2;
		mergesort(arr,low,mid);
		mergesort(arr,mid+1,high);
		merge(arr,temp,low,mid+1,mid,high);
		copy(arr,temp,low,high);
	}
}


int main(void)
{
	while(1)
	{
		long nums,i,qur;
		scanf("%ld",&nums);
		if(nums==0)
			break;
		long *vals=(long*)malloc(sizeof(long)*nums);
		scanf("%ld",&qur);
		for(i=0;i<nums;i++)
			scanf("%ld",&vals[i]);
//		mergesort(vals,0,(nums-1));
		while(qur--)
		{
			long upper,lower,count=1,x,y,maxcount=1;
			scanf("%ld %ld",&lower,&upper);
//			upper++;
			lower--;
			x=lower;
			while(x<upper)
			{
				y=vals[x];
				x++;
				if(x==upper)
					break;				
				count=1;
				while(vals[x]==y)
				{
					count++;
					x++;
					if(x==upper)
						break;
				}
				if(count>maxcount)
					maxcount=count;
			}
			printf("%ld\n",maxcount);
		}
	}
	return 0;
}
