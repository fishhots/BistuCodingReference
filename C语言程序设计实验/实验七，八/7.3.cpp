#include<stdio.h>
void sort3(int *n1,int *n2,int *n3);
int main()
{
	int n1,n2,n3;
	printf("Please input 3 numbers to sort:\n");
	scanf("%d %d %d",&n1,&n2,&n3);
	sort3(&n1,&n2,&n3);
}
void sort3(int *n1,int *n2,int *n3)
{
	int temp;
	if(*n1>=*n2)
	{
		temp=*n1;
		*n1=*n2;
		*n2=temp;
	}
	if(*n2>=*n3)
	{
		temp=*n2;
		*n2=*n3;
		*n3=temp;
	}
	if(*n1>=*n2)
	{
		temp=*n1;
		*n1=*n2;
		*n2=temp;
	}
	printf("The sort is\n%d %d %d",*n1,*n2,*n3);
}