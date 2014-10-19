#include<stdio.h>
int reverse(int num)
{
	int sum=0;
	while(num!=0)
	{
		sum=(sum*10)+(num%10);
		num=num/10;
	}
	return sum;
}
int main(void)
{
	int cases;
	scanf("%d",&cases);
	int i=0;
	int num1,num2;
	for(i=0;i<cases;i++)
	{
		scanf("%d",&num1);
		scanf("%d",&num2);
		printf("%d\n",reverse((reverse(num1)+reverse(num2))));
	}
	return 0;
}
