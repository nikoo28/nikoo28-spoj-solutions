# include<stdio.h>
 
void mul(long long F[][2],long long M[][2],long long ML) // FUNCTION TO MULTIPLY TWO MATRIX
{
long long x=((F[0][0]*M[0][0])%ML + (F[0][1]*M[1][0])%ML)%ML;
long long y=((F[0][0]*M[0][1])%ML + (F[0][1]*M[1][1])%ML)%ML;
long long z=((F[1][0]*M[0][0])%ML + (F[1][1]*M[1][0])%ML)%ML;
long long w=((F[1][0]*M[0][1])%ML + (F[1][1]*M[1][1])%ML)%ML;
F[0][0]=x;
F[0][1]=y;
F[1][0]=z;
F[1][1]=w;
}
void powerf(long long F[2][2],long long n,long long ML) // RECURSIVE FUNCTION FOR MATRIX
{
if(n==0 || n==1)
return;
long long M[2][2]={0,1,1,1};
powerf(F,n/2,ML);
mul(F,F,ML);
if(n%2!=0)
mul(F,M,ML);
}
 
long long fib(long long n,long long ML) //FUNCTION CALLED FROM main
{
long long F[2][2]={0,1,1,1};
long long result;
if(n==0)
return 0;
else if(n==1 || n==2)
return 1;
powerf(F,(n-1),ML);
return (F[0][0]+F[0][1]);
}
 
 
int main()
{
int t;
long long k,n,ML;
int i=0;
scanf("%d",&t);
while(t--)
{
long long ans=0;
scanf("%lld %lld %lld",&k,&n,&ML);
ans=(fib(n,ML))%ML;
for(i=1;i<k;i++)
	ans=(fib(ans,ML))%ML;
printf("%lld\n",ans);
}
return 0;
}
