#include<stdio.h>
#include<stdlib.h>

int main()
{
	//0-Male 1-Female
	int cases;
	scanf("%d",&cases);
	while(cases--)
	{
		int n,ans=0,count=0;
		long long k;
		scanf("%d %lld",&n,&k);
		k--;
		while(k)
		{
			count+=(k & 1);
			k=k>>1;
		}
		if(count & 1)
			ans=1;
		if(ans)
			printf("Female\n");
		else
			printf("Male\n");
	}
	return 0;
}
