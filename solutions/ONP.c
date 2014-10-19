#include<stdio.h>
#include<stdlib.h>

struct listnode{
	char data;
	struct listnode *next;
};

struct listnode * push(struct listnode *start,char a)
{
	struct listnode *temp=NULL;
	if(start==NULL)
	{
		temp=(struct listnode*)malloc(sizeof(struct listnode));
		temp->data=a;
		temp->next=NULL;
		return temp;
	}
	else
	{
		temp=(struct listnode*)malloc(sizeof(struct listnode));
		temp->data=a;
		temp->next=start;
		start=temp;
		return start;
	}
}

char pop(struct listnode *start)
{
	return start->data;
}

void printer(struct listnode *start)
{
	while(start!=NULL)
	{
//		if(start->data!='(')
			printf("%c",start->data);
		start=start->next;
	}
}

int main(void)
{
	int cases;
	scanf("%d",&cases);
	int i,index;
	struct listnode *stack;
	for(i=0;i<cases;i++)
	{
		stack=NULL;
		char *exp=(char*)malloc(sizeof(char)*400);
		scanf("%s",exp);
		index=0;
		while(exp[index]!='\0')
		{
			switch(exp[index])
			{
				case '(':
				stack=push(stack,exp[index]);
				break;
				
				case '+':
				case '-':
				if(stack!=NULL)
					while(stack->data=='+' || stack->data=='-' || stack->data=='*' || stack->data=='/' || stack->data=='^')
					{
						printf("%c",pop(stack));
						stack=stack->next;
						if(stack==NULL)
							break;
					}
				stack=push(stack,exp[index]);
				break;
				
				case '*':
				case '/':
				if(stack!=NULL)
					while(stack->data=='*' || stack->data=='/' || stack->data=='^')
					{
						printf("%c",pop(stack));
						stack=stack->next;
						if(stack==NULL)
							break;
					}
				stack=push(stack,exp[index]);
				break;
				
				case '^':
				if(stack!=NULL)
					while(stack->data=='^')
					{
						printf("%c",pop(stack));
						stack=stack->next;
						if(stack==NULL)
							break;
					}
				stack=push(stack,exp[index]);
				break;
				
				case ')':
				while(1)
				{
					if(stack->data=='(')
						break;
					else
					{
						printf("%c",stack->data);
						stack=stack->next;
					}
				}
				stack=stack->next;
				break;
				
				default:
				printf("%c",exp[index]);
				break;
			}
			index++;
		}
		printer(stack);
		free(exp);
		printf("\n");
	}
	return 0;
}
