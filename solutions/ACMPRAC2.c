#include<stdio.h>
#include<stdlib.h>
#define MAX 65000

void merge(int arr[],int temp[],int low1,int low2,int up1,int up2)
{
	int i=low1;
	int j=low2;
	int k=low1;
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

void copy(int arr[],int temp[],int low,int high)
{
	while(low<=high)
	{
		arr[low]=temp[low];
		low++;
	}
}

void mergesort(int arr[],int low,int high)
{
	int temp[MAX];
	if(low<high)
	{
		int mid=(low+high)/2;
		mergesort(arr,low,mid);
		mergesort(arr,mid+1,high);
		merge(arr,temp,low,mid+1,mid,high);
		copy(arr,temp,low,high);
	}
}

int main()
{
	int cases;
	scanf("%d",&cases);
	while(cases--)
	{
		int meals;
		scanf("%d",&meals);
		char str[200000];
		scanf("%s",str);
		int vals[200000];
		long counter=0,len=0,i=0;
		while(str[i]!='\0')
		{
			char a=str[i];
			i++;
			len=1;
			while(str[i]==a)
			{
				len++;
				i++;
			}
			vals[counter++]=len;
		}
		long sum=0;
		mergesort(vals,0,counter-1);
		for(i=0;i<meals;i++)
			sum+=vals[i];
		printf("%ld\n",sum);
	}
	return 0;
}
