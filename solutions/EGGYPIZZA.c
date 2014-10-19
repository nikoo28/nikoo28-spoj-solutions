#include<stdio.h>
#include<stdlib.h>

int main()
{
	int frnds;
	scanf("%d",&frnds);
	int obyfour=0,obytwo=0,tbyfour=0,i;
	char abc[4];
	for(i=0;i<frnds;i++)
	{
		scanf("%s",abc);
		if(abc[2]=='2')
			obytwo++;
		else if(abc[0]=='1' && abc[2]=='4')
			obyfour++;
		else if(abc[0]=='3' && abc[2]=='4')
			tbyfour++;
	}
	int pizzas=tbyfour;
	if(obyfour>=tbyfour)
		obyfour=obyfour-tbyfour;
	else
		obyfour=0;
	pizzas+=(obyfour/4);
	obyfour=obyfour%4;
	pizzas+=(obytwo/2);
	obytwo=obytwo%2;
	if(obytwo==0)
	{
		if(obyfour!=0)
			pizzas++;	
	}
	else
	{
		if(obyfour==3)
			pizzas+=2;
		else
			pizzas+=1;
	}
	printf("%d",(pizzas+1));
	return 0;
}
