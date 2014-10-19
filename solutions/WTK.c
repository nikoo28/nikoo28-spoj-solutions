#include<stdio.h>
#include<stdlib.h>

struct listnode{
	long data;
	struct listnode *next;
};

void printer(struct listnode *start)
{
	struct listnode *temp=start;
	printf("%ld ",temp->data);
	temp=temp->next;
	while(temp!=start)
	{
		printf("%ld ",temp->data);
		temp=temp->next;
	}
	printf("\n");
}

struct listnode * delfirstnode(struct listnode *start)
{
	struct listnode *temp=start->next;
	while(temp->next!=start)
		temp=temp->next;
	free(temp->next);
	temp->next=start->next;
	start=start->next;
	return start;
}

struct listnode * circle(struct listnode *start,long n)
{
	struct listnode *temp=NULL;
	long i=0;
	for(i=n;i>0;i--)
	{
		if(start==NULL)
		{
			start=(struct listnode*)malloc(sizeof(struct listnode));
			start->data=n;
			start->next=NULL;
		}
		else
		{
			temp=(struct listnode*)malloc(sizeof(struct listnode));
			temp->data=i;
			temp->next=start;
			start=temp;
		}
	}
	temp=start;
	while(temp->next!=NULL)
		temp=temp->next;
	temp->next=start;
	return start;
}

int main(void)
{
	int cases;
	scanf("%d",&cases);
	long girls;
	long i,j;
	struct listnode *sto=NULL;
	while(cases--)
	{
		scanf("%ld",&girls);
		struct listnode *start=NULL;
		start=circle(start,girls);
		struct listnode *temp=start;
		for(i=1;i<girls;i++)
		{
			if(i==1)
			{
				start=delfirstnode(start);
				temp=start;
				continue;
			}
			for(j=1;j<(i-1);j++)
				temp=temp->next;
			sto=temp->next;
			temp->next=sto->next;
			temp=sto->next;
			start=temp;
			if(temp->next==start)
				break;
		}
		printer(start);
		free(temp);
	}
	return 0;
}
