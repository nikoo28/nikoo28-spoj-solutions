#include<stdio.h>
#include<stdlib.h>

char max(double e,double f,double s,double m)
{
	char maxi;
	if(e>=f && e>=s && e>=m)
		return 'e';
	if(f>=e && f>=s && f>=m)
		return 'f';
	if(s>=e && s>=f && s>=m)
		return 's';
	if(m>=e && m>=f && m>=s)
		return 'm';
}

int main(void)
{
	int E,F,S,M;
	int En,Fn,Sn,Mn;
	int Ep,Fp,Sp,Mp;
	char maxi;
	int cakes;
	while(1)
	{
		scanf("%d %d %d %d %d %d %d %d",&E,&F,&S,&M,&En,&Fn,&Sn,&Mn);
		if(E==-1 && F==-1 && S==-1 && M==-1 && En==-1 && Fn==-1 && Sn==-1 && Mn==-1)
			break;
		maxi=max(((double)E/(double)En),((double)F/(double)Fn),((double)S/(double)Sn),((double)M/(double)Mn));
		switch(maxi)
		{
			case 's':
			if(S%Sn==0)
				cakes=S/Sn;
			else
				cakes=(S/Sn+1);
			break;
			
			case 'e':
			if(E%En==0)
				cakes=E/En;
			else
				cakes=(E/En+1);
			break;
			
			case 'f':
			if(F%Fn==0)
				cakes=F/Fn;
			else
				cakes=(F/Fn+1);
			break;
			
			case 'm':
			if(M%Mn==0)
				cakes=M/Mn;
			else
				cakes=(M/Mn+1);
			break;
		}
		Ep=En*cakes;
		printf("%d ",(Ep-E));
		Fp=Fn*cakes;
		printf("%d ",(Fp-F));
		Sp=Sn*cakes;
		printf("%d ",(Sp-S));
		Mp=Mn*cakes;
		printf("%d ",(Mp-M));
		printf("\n");
	}
	return 0;
}
