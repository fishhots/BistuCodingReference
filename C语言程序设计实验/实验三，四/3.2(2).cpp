#include<stdio.h>
int main()
{
	int n,i;
	printf("Please input the number n=");
	scanf("%d",&n);
	int a[n],b[n];
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
    for(i=0;i<n;i++)
    	b[n-i-1]=a[i];
    for(i=0;i<n;i++)
        printf("%d ",b[i]);
}