#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	int cases,i;
	scanf("%d",&cases);
	long arr[]={0,2,4,9,16,25,64,289, 729, 1681, 2401, 3481, 4096, 5041, 7921, 10201, 15625, 17161, 27889, 28561, 29929, 65536, 83521, 85849, 146689, 262144, 279841, 458329, 491401, 531441, 552049, 579121, 597529, 683929, 703921, 707281, 734449, 829921, 1190281};
	while(cases--)
	{
		long x,y;
		scanf("%ld %ld",&x,&y);
		int c1=0,c2=0;
		for(i=1;i<40;i++)
			if(arr[i]<x)
				c1++;
			else
				break;
		for(i=1;i<40;i++)
			if(arr[i]<=y)
				c2++;
			else
				break;
		printf("%d\n",(c2-c1));
	}
	return 0;
}
