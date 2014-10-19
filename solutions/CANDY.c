#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	int boxes,i;
	scanf("%d",&boxes);
	long total=0;
	long share=0;
	long moves=0;
	while(boxes!=-1)
	{
		total=0,share=0,moves=-1;
		int *box=(int*)malloc(sizeof(int)*boxes);
		for(i=0;i<boxes;i++)
		{
			scanf("%d",&box[i]);
			total+=box[i];
		}
		if(total%boxes==0)
		{
			moves=0;
			share=total/boxes;
			for(i=0;i<boxes;i++)
				if(box[i]<share)
					moves+=(share-box[i]);
		}
		free(box);
		printf("%ld",moves);
		printf("\n");
		scanf("%d",&boxes);			
	}
	return 0;
}
