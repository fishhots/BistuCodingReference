#include<stdio.h>
int main()
{
	int b,a[100],n;
	printf("Please input n=");
	scanf("%d",&n);
	printf("Please input %d numbers\n",n);
	for(int i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
	}
	for(int i=0;i<n;i++)
	printf("%d ",a[i]);
	printf("\n");
    for(int i=0;i<n-1;i++)
    {
    	for(int j=i+1;j<n;j++)
    	{
    		if(a[i]>a[j])
    		{
    			b=a[i];
    			a[i]=a[j];
    			a[j]=b;
			}
		}
	}
	for(int i=0;i<n;i++)
	{
		printf("%d ",a[i]);
	}
}