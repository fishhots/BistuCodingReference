#include<stdio.h>
int n;
int jiecheng(int n);
int main()
{
	printf("Please input a number n:");
	scanf("%d",&n);
	printf("The result is %d",jiecheng(n));
}
int jiecheng(int n)
{
	int num=1;
	if(n<=0)
	return 0;
	else
	for(int i=1;i<=n;i++)
	num=num*i;
	return num;
}