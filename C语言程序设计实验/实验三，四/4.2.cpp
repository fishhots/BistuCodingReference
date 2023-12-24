#include<stdio.h>
int main()
{
	int m,n,p;
	printf("Please input m,n,p:\n");
	scanf("%d %d %d",&m,&n,&p);
	int a[m][n],b[n][p],num[m][p];
	for(int i=0;i<m;i++)
	{
		for(int x=0;x<n;x++)
		scanf("%d",&a[i][x]);
	}
	
	for(int i=0;i<n;i++)
	{
		for(int x=0;x<p;x++)
		scanf("%d",&b[i][x]);
	}
	for(int i=0;i<m;i++)
	{
		
		for(int x=0;x<p;x++)
		{
			int number=0;
			for(int y=0;y<n;y++)
			number+=a[i][y]*b[y][x];
			num[i][x]=number;
		}
	}
	for(int i=0;i<m;i++)
	{
		for(int x=0;x<p;x++)
		printf("%d ",num[i][x]);
		printf("\n");
	}
}