#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	int cases;
	scanf("%d",&cases);
	while(cases--)
	{
		long long tckt;
		scanf("%lld",&tckt);
		if(tckt==1)
		{
			printf("poor conductor\n");
			continue;
		}
		else
			tckt=tckt-1;
		long long row=0;
		if(tckt%5==0)
			row=tckt/5;
		else
			row=(tckt/5)+1;
			
		if(row%2==0)
			tckt=tckt-((row-2)*5);
		else
			tckt=tckt-((row-1)*5);
		switch(tckt)
		{
			case 1:
			printf("%lld W L\n",row);
			break;
			
			case 2:
			printf("%lld A L\n",row);
			break;
			
			case 3:
			printf("%lld A R\n",row);
			break;
			
			case 4:
			printf("%lld M R\n",row);
			break;
			
			case 5:
			printf("%lld W R\n",row);
			break;
			
			case 6:
			printf("%lld W R\n",row);
			break;
			
			case 7:
			printf("%lld M R\n",row);
			break;
			
			case 8:
			printf("%lld A R\n",row);
			break;
			
			case 9:
			printf("%lld A L\n",row);
			break;
			
			case 10:
			printf("%lld W L\n",row);
			break;
		}
	}
	return 0;
}
