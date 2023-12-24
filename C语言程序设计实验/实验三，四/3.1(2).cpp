#include<stdio.h>
void Bubble_sort(int arr[], int size)
{
	int j,i,tem;
	for (i = 0; i < size-1;i ++)
	{
		int count = 0;
		for (j = 0; j < size-1 - i; j++)	
		{
			if (arr[j] > arr[j+1])
			{
				tem = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = tem;
				count = 1;
				
			}
		}
		if (count == 0)			
				break;	
	}
 
}
int main()
{
	int arr[10];
	int i,n;
	printf("Please input n:");
	scanf("%d",&n);
	for (i = 0; i <n; i++)		
	{
		scanf("%d", &arr[i]);
	}
	for(int i=0;i<n;i++)
	{
		printf("%d ",arr[i]);
	}
	printf("\n");
	Bubble_sort(arr,n);
	for (i = 0; i <n; i++)
	{
		printf("%d ", arr[i]);
	}
 
	return 0;
}