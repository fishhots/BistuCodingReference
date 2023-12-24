#include<stdio.h>
void findHighestScore(float score[][5],int *hang,int *lie);
int main()
{
	float score[10][5];
	printf("Please input the grade:\n");
	for(int i=0;i<10;i++)
		{
			for(int x=0;x<5;x++)
			scanf("%f",&score[i][x]);
		}
	int hang=0,lie=0;
	findHighestScore(&score[0],&hang,&lie);
	printf("The highest score is in the %d hang %d lie",hang,lie);
}
void findHighestScore(float score[][5],int *hang,int *lie)
{
	float temp=0.0;
	for(int i=0;i<10;i++)
		{
			for(int x=0;x<5;x++)
			{
				if(temp<=score[i][x])
				{
					*hang=i+1;
					*lie=x+1;
					temp=score[i][x];
				}
			}
		}
}