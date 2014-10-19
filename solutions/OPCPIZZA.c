#include<stdio.h>
#include<stdlib.h>

void counting_sort_mm(long *array, long n, long min, long max)
{
  long i, j, z;
 
  long range = max - min + 1;
  long *count = malloc(range * sizeof(*array));
 
  for(i = 0; i < range; i++) count[i] = 0;
  for(i = 0; i < n; i++) count[ array[i] - min ]++;
 
  for(i = min, z = 0; i <= max; i++) {
    for(j = 0; j < count[i - min]; j++) {
      array[z++] = i;
    }
  } 
 
  free(count);
}

int main()
{
	int cases;
	scanf("%d",&cases);
	while(cases--)
	{
		int frnds,pzc;
		scanf("%d %d",&frnds,&pzc);
		long x;
		long counter=0;
		if(frnds==1)
		{
			scanf("%ld",&x);
			if(x==pzc)
				counter++;
			goto ab;
		}
		long money[200000];
		long i=0;
		for(i=0;i<frnds;i++)
			scanf("%ld",&money[i]);
		counting_sort_mm(money,frnds,-200000,200000);
		long left=0;
		long right=frnds-1;
		while(left<right)
		{
			if((money[left]+money[right])==pzc)
			{
				left++;
				right--;
				counter++;
			}
			else if((money[left]+money[right])<pzc)
				left++;
			else
				right--;
		}
ab:		printf("%ld\n",counter);
	}
	return 0;
}
