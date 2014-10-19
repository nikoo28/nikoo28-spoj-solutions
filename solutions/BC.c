#include<stdio.h>
#include<stdlib.h>

int nextperfectcube(long long x)
{
	int count=0;
	long long temp=x;
	while(temp!=1)
	{
		temp=temp/2;
		count++;		
	}
	return (count+1);
}

long long iscube(long long vol)
{
	long long i=2;
	int count=1;
	while(i<=vol)
	{
		if(i==vol)
			return count;
		i=i*2;
		count++;
	}
	return 50;
}

int main(void)
{
	int cases;
	scanf("%d",&cases);
	int i;
	long long L,M,N;
	long long vol;
	long long p;
	for(i=0;i<cases;i++)
	{
		scanf("%lld %lld %lld",&L,&M,&N);
		vol=L*M*N;
		if(vol==1)
			printf("Case #%d: 0 0\n",(i+1));
		else if(vol==2)
			printf("Case #%d: 1 1\n",(i+1));
		else
		{
			p=iscube(vol);
			if(p==50)
				printf("Case #%d: %lld %d\n",(i+1),(vol-1),nextperfectcube(vol));
			else
				printf("Case #%d: %lld %lld\n",(i+1),(vol-1),p);
		}
	}
	return 0;
}
