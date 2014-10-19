#include<stdio.h>
#include<stdlib.h>

struct listnode{
	long data;
	struct listnode *next;
};

struct listnode * push(struct listnode *top,long n)
{
	struct listnode *temp;
	temp=(struct listnode *)malloc(sizeof(struct listnode));
	temp->data=n;
	if(top==NULL)
		temp->next=NULL;
	else
		temp->next=top;
	return temp;
}

int main(void)
{
	long trucks,i=0,counter=1,passed;
	while(1)
	{
		scanf("%ld",&trucks);
		if(trucks==0)
			goto ab;
		counter=1;
		passed=0;
		struct listnode *stack=NULL;
		stack=push(stack,-1);
		long *a=(long*)malloc(sizeof(long)*trucks);
		for(i=trucks-1;i>-1;i--)
			scanf("%ld",&a[i]);
		for(i=trucks-1;i>-1;i--)
		{
			if(a[i]==counter)
			{
				passed++;
				counter++;
			}
			else
				if(stack==NULL)
					stack=push(stack,a[i]);
				else
					if(stack->data==counter)
					{
						stack=stack->next;
						passed++;
						counter++;
					}
					else
					stack=push(stack,a[i]);
			while(stack->data==counter)
			{
				passed++;
				counter++;
				stack=stack->next;
				if(stack==NULL)
					break;
			}	
		}
		if(passed==trucks)
			printf("yes\n");
		else
			printf("no\n");
		free(a);
	}
ab:	return 0;
}
