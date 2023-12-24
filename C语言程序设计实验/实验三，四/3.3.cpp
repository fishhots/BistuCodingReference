#include<stdio.h>
int main()
{
	int fen,i,n;
	printf("Please input the number n=");
	scanf("%d",&n);
	int a[n];
	for(i=0;i<n;i++)
	scanf("%d",&a[i]);
	printf("Please input a certain grade=");
	scanf("%d",&fen);
	int x=0;
	for(i=0;i<n;i++)
	{
		if(a[i]==fen)
		x++;
	}
	printf("%d",x);
	
}