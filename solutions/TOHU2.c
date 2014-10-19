#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	int c,i,x;
	scanf("%d",&c);
	while(c--)
	{
		char ch[100];
		char ab;
		for(i=0;i<99;i++)
		{
			scanf("%d %c",&x,&ab);
			ch[x]=ab;
		}
		if(ch[9]==ch[18] && ch[9]==ch[27] && ch[9]==ch[36] && ch[9]==ch[45] && ch[9]==ch[54] && ch[9]==ch[63] && ch[9]==ch[72] && ch[9]==ch[81])
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}
