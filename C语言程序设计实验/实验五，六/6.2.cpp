#include<stdio.h>
#include<string.h>
int main()
{
	printf("Please input the number of student and subject:");
	int m,n;
	scanf("%d %d",&m,&n);
	char a[m+1][n+1][20];
	for(int i=0;i<m+1;i++)
	{
		for(int x=0;x<n+1;x++)
		a[i][x][0]=' ';
	}
	printf("Please input the name and number:\n");
	for(int i=1;i<m+1;i++)
	scanf("%s",&a[i][0]);
	printf("Please input the name of subject:\n");
	for(int i=1;i<n+1;i++)
	scanf("%s",&a[0][i]);
	int flag=1;
	while(flag)
	{
		char s[20];
		printf("What do u want to do?\nluru\nshuchu\nchaxun\nshanchu\nxiugai\npaixu\njieshu\n");
		scanf("%s",&s);
		if(strcmp(s,"luru")==0)
			for(int i=1;i<m+1;i++)
				{
					for(int x=1;x<n+1;x++)
					scanf("%s",&a[i][x]);
				}
		if(strcmp(s,"shuchu")==0)
			{
				for(int i=0;i<m+1;i++)
				{
					for(int x=0;x<n+1;x++)
					printf("%s\t",a[i][x]);
					printf("\n");
				}
			}
		if(strcmp(s,"chaxun")==0)
			{
				printf("Whitch one do u want to search?\n");
				char xun[10];
				int l;
				scanf("%s",&xun);
				for(int i=1;i<n+1;i++)
				{
					if(strcmp(a[0][i],xun)==0)
					{
					l=i;
					break;
				    }
				}
				for(int i=1;i<n+1;i++)
				{
					printf("%s %s  ",a[i][0],a[i][l]);
				}
				printf("\n");
			}
		if(strcmp(s,"shanchu")==0)
			{
				printf("Which subject and name do u want to delete?\n");
				char s[10],l[10];
				int x,y;
				scanf("%s %s",&s,&l);
				for(int i=0;i<n+1;i++)
				if(strcmp(a[0][i],s)==0)
					{
						x=i;
						break;
					}
				for(int i=1;i<m+1;i++)
				if(strcmp(a[i][0],l)==0)
					{
						y=i;
						break;
					}
				a[y][x][0]=' ';
			}
		if(strcmp(s,"xiugai")==0)
			{
				printf("Which subject and name do u want to change?\n");
				char s[10],l[10];
				int x,y;
				scanf("%s %s",&s,&l);
				for(int i=0;i<n+1;i++)
				if(strcmp(a[0][i],s)==0)
					{
						x=i;
						break;
					}
				for(int i=1;i<m+1;i++)
				if(strcmp(a[i][0],l)==0)
					{
						y=i;
						break;
					}
				printf("U want change it to ");
				scanf("%s",&a[y][x]);
			}
		if(strcmp(s,"paixu")==0)
			{
				printf("Which subject do u want to sort?\n");
				char s[10];
				scanf("%s",&s);
				int x;
				for(int i=0;i<n+1;i++)
				if(strcmp(a[0][i],s)==0)
					{
						x=i;
						break;
					}
				int num[m+1];
				for(int i=0;i<m+1;i++)
				num[i]=i;
				int b;
				for(int i=1;i<n;i++)
   					{
    					for(int j=i+1;j<n+1;j++)
    						{				
    							if(strcmp(a[i][x],a[j][x])>0)
    							{
    								b=num[i];
    								num[i]=num[j];
    								num[j]=b;
								}
							}
					}
				for(int i=0;i<m+1;i++)
				{
					for(int x=0;x<n+1;x++)
					{
					int lin;
					lin=num[i];
					printf("%s\t",a[lin][x]);
				    }
					printf("\n");
				}
			}
		if(strcmp(s,"jieshu")==0)
		flag=0;	
	}
}
