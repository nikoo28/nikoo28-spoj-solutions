/*#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#define MOD 10000007

int main(void)
{
	long long n,k;
	while(1)
	{
		scanf("%lld %lld",&n,&k);
		if(n==0 && k==0)
			break;
		long long p=0,s=0;
		long long i,x;
		for(i=0;i<n;i++)
		{
			x=pow(i,i);
			p+=(x%MOD);
		}
		for(i=0;i<n;i++)
		{
			x=pow(i,k);
			s+=(x%MOD);
		}
		long long ans=s+p;
		s=0;
		p=0;
		n--;
		for(i=0;i<n;i++)
		{
			x=pow(i,i);
			p+=(x%MOD);
		}
		for(i=0;i<n;i++)
		{
			x=pow(i,k);
			s+=(x%MOD);
		}
		ans+=(s+p);
		n--;
		s=0;
		p=0;
		for(i=0;i<n;i++)
		{
			x=pow(i,i);
			p+=(x%MOD);
		}
		for(i=0;i<n;i++)
		{
			x=pow(i,k);
			s+=(x%MOD);
		}
		ans-=(2*(s+p));
		printf("%lld\n",ans);
	}
	return 0;
}

*/
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#define MOD 10000007

int mult(long long a,long long b){
    long long temp = 1,ans = 1;
    while(b>0){
        if(b & temp){
            ans = (ans * a) % MOD;
            b = b - temp;
        }
        temp = temp << 1;
        a = (a * a) % MOD;
    }
    return ans % MOD;
}
int main()
{
 long long n,k;
 while(1){
        scanf("%lld %lld",&n,&k);
        if(n == 0 && k == 0)
            break;
        int ans = (2*mult(n-1,k)) % MOD  +  (2*mult(n-1,n-1)) % MOD  +  mult(n,k) % MOD +  mult(n,n) % MOD;
        ans = ans % MOD;
        printf("%d\n",ans);
    }
 return 0;
}
