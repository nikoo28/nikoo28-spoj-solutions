#include <stdlib.h>
#include <stdio.h>

int main(void)
{
	int i,j,cols,x;
	scanf("%d",&cols);
	char str[15][25];
	while(cols!=0 && (cols>=2 && cols<=20))
	{
		for(i=0;i<15;i++)
			for(j=0;j<25;j++)
				str[i][j]='\0';
		char *abc=(char*)malloc(sizeof(char)*300);
		scanf("%s",abc);
/*		for(i=0;i<50;i++)
			printf("%c",abc[i]);
		printf("\n");*/
		x=0;j=0;
		while(abc[x]!='\0')
		{
			for(i=0;i<cols;i++)
				str[j][i]=abc[x++];
			j++;
			if(abc[x]!='\0')
				for(i=(cols-1);i>=0;i--)
					str[j][i]=abc[x++];
			j++;
		}
		for(i=0;i<25;i++)
			for(j=0;j<15;j++)
				if(str[j][i]!='\0')
					printf("%c",str[j][i]);
		printf("\n");
		free(abc);
		scanf("%d",&cols);
	}
	return 0;
}
