# include<stdio.h>

void mul(long long F[][2],long long M[][2]) // FUNCTION TO MULTIPLY TWO MATRIX
{
	long long x=((F[0][0]*M[0][0])%1000000007 + (F[0][1]*M[1][0])%1000000007)%1000000007;
	long long y=((F[0][0]*M[0][1])%1000000007 + (F[0][1]*M[1][1])%1000000007)%1000000007;
	long long z=((F[1][0]*M[0][0])%1000000007 + (F[1][1]*M[1][0])%1000000007)%1000000007;
	long long w=((F[1][0]*M[0][1])%1000000007 + (F[1][1]*M[1][1])%1000000007)%1000000007;
	F[0][0]=x;
	F[0][1]=y;
	F[1][0]=z;
	F[1][1]=w;
}
void powerf(long long F[2][2],long long n) // RECURSIVE FUNCTION FOR MATRIX
{
	if(n==0 || n==1)
		return;
		
	long long M[2][2]={0,1,1,1};
	
	powerf(F,n/2);
	mul(F,F);
	if(n%2!=0)
		mul(F,M);
}

long long fib(long long n) //FUNCTION CALLED FROM main
{
	long long F[2][2]={0,1,1,1};
	long long result;
	
	if(n==1 || n==2)
		return 1;
		
	powerf(F,(n-1));
	
	return (F[0][0]+F[0][1]);
}


int main()
{
	int i;
	long long ans=0;
	scanf("%d",&i);
	while(i--)
	{
		scanf("%lld",&ans);
		if(ans==0)
		{
			printf("0\n");
			continue;
		}
	/*You can also calculate sum from F[10] to F[19] as F[21]-F[11]
	  because S[n]=F[n+2]-1;
	  => S[19]=F[21]-1 and S[9]=F[11]-1
	*/
	printf("%lld\n",fib(fib(ans)));
	}
	
	return 0;
}
