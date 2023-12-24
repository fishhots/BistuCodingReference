#include<stdio.h>
int main()
{
	int pingjun(int m,int n,int a[][10]);
	int kejun(int m,int n,int a[][10]);
	int m,n;
	printf("The student and subject m and n=");
	scanf("%d %d",&m,&n);
	int num[m][n];
	for(int i=0;i<m;i++)
	{
		for(int x=0;x<n;x++)
		{
			scanf("%d",&num[i][x]);
		}
	}
}
int pingjun(int m,int n,int a[][10])
{
	float jun[m];
	float fen;
	for(int i=0;i<m;i++)
	{
		fen=0;
		for(int x=0;x<n;x++)
		{
			fen+=a[i][x];
		}
		jun[i]=fen/n;
	}
	return fen[];
}
int kejun(int m,int n,int a[][10])
{
	float fen,jun[n];
	for(int i=0;i<n;i+=)
	{
		fen=0;
		for(int x=0;x<m;x++)
		{
			fen+=a[x][i];
		}
		jun[i]=fen/n;
	}
	return jun[];
}

