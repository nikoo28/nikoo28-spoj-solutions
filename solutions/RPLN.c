#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int mylog2 (long val) {
    unsigned int ret = -1;
    while (val != 0) {
        val >>= 1;
        ret++;
    }
    return ret;
}

long** preprocess(long *A, long size)
{
    long **M = (long**)malloc(sizeof(long*)*size);
    long lN = mylog2(size);

	long i,j;
    for(i=0;i<size;i++)
    	M[i]=(long*)malloc(sizeof(long)*lN);
   
    // Generating Table of M[n][log(n)]

    for(i=0;i<size;++i)
        M[i][0] = i;
   
    for(j=1;(1<<j)<=size;++j)
    {
        for(i=0;i+(1<<j)-1<size;++i)
        {
            if(A[M[i][j-1]] <= A[M[i+(1<<(j-1))][j-1]])
                M[i][j] = M[i][j-1];
            else
                M[i][j] = M[i+(1<<(j-1))][j-1];
        }
      }
    return M;
}

long RMQ(long *A, long size, long i, long j)
{
    long **M = preprocess(A,size);
    long k=0;
    while((1<<k++) < (j-i));
    --k;
    
    if(A[M[i][k]]<=A[M[j-(1<<k)+1][k]])
        return A[M[i][k]];
    else
        return A[M[j-(1<<k)+1][k]];
}

int main(void)
{
	int cases;
	int k;
	scanf("%d",&cases);
	for(k=1;k<=cases;k++)
	{
		long len;
		scanf("%ld",&len);
		long qurs;
		scanf("%ld",&qurs);
		long i,j;
		long *arr=(long*)malloc(sizeof(long)*len);
		for(i=0;i<len;i++)
			scanf("%ld",&arr[i]);
		printf("Scenario #%d:\n",k);
		while(qurs--)
		{
			scanf("%ld %ld",&i,&j);
			i--;
			j--;
			printf("%ld\n",RMQ(arr,len,i,j));
		}
	}
	return 0;
}
