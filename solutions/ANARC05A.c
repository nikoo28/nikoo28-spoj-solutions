#include<stdio.h>
#include<stdlib.h>

struct stacknode{
	char data;
	struct stacknode *next;
};

struct stacknode * push(struct stacknode *head,char item)
{
	struct stacknode *temp=(struct stacknode*)malloc(sizeof(struct stacknode));
	temp->data=item;
	if(head==NULL)
		temp->next=NULL;
	else
		temp->next=head;
	return temp;
}

int main(void)
{
	int i,j;
	int cases=1;
	while(1)
	{
		char in[2002];
		scanf("%s",in);
		if(in[0]=='-')
			break;
		i=0,j=0;
		struct stacknode *head=NULL;
		while(in[i]!='\0')
		{
			if(in[i]=='{')
				head=push(head,in[i++]);
			else if(in[i]=='}')
			{
				if(head==NULL)
					j++;
				else
					head=head->next;
				i++;
			}
		}
		i=0;
		while(head!=NULL)
		{
			head=head->next;
			i++;
		}
		if(i%2==0)
			i=i/2;
		else
			i=(i+1)/2;
		if(j%2==0)
			j=j/2;
		else
			j=(j+1)/2;
		printf("%d. %d\n",(cases++),(i+j));
	}
	return 0;
}
