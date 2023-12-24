#include<stdio.h>
float avgStuScore(float scores[][10],int m,int n);
float avgCourseScore(float scores[][10],int m,int n);
void findHighestScore(float scores[][10],int m,int n);
float stdd(float scores[][10],int m,int n);
int main()
{
	int m,n;
	printf("The student and subject m and n=");
	scanf("%d %d",&m,&n);
	float scores[m][10];
	for(int i=0;i<m;i++)
	{
		for(int x=0;x<n;x++)
		{
			scanf("%f",&scores[i][x]);
		}
	}
    float st[m];
	for(int i=0;i<m;i++)
	{
		st[i]=avgStuScore(scores,i,n);
		printf("No.%d Student is %.2f\n",i+1,st[i]);
    }
	float sub[n];
	for(int i=0;i<n;i++)
	{
		sub[i]=avgCourseScore(scores,m,i);
		printf("NO.%d Subject is %.2f\n",i+1,sub[i]);
	}
	findHighestScore(scores,m,n);
	float fangcha;
	fangcha=stdd(scores,m,n);
	printf("The std is %.2f",fangcha);
	
}
float avgStuScore(float scores[][10],int m,int n)
{
	
		float fen=0.0;
        for(int i=0;i<n;i++)
        {
        	fen+=scores[m][i];
		}
	
		fen=fen/(float)n;
		return fen;
}
float avgCourseScore(float scores[][10],int m,int n)
{
	float fen=0.0;
	for(int x=0;x<m;x++)
		fen+=scores[x][n];
	fen=fen/(float)m;
	return fen;
}
void findHighestScore(float scores[][10],int m,int n)
{
	int fen=0;
	for(int i=0;i<m;i++)
	{
		for(int x=0;x<n;x++)
		if(fen<=scores[i][x])
		fen=scores[i][x];
	}
	printf("The highest score is %d\n",fen);
}
float stdd(float scores[][10],int m,int n)
{
	float fen[n];
	for(int i=0;i<n;i++)
	fen[i]=avgCourseScore(scores,m,i);
	float pingjun=0.0;
	for(int i=0;i<n;i++)
	pingjun+=fen[i];
	pingjun=pingjun/n;
	float fenshu=0.0;
	for(int i=0;i<n;i++)
	{
		fenshu+=(fen[i]-pingjun)*(fen[i]-pingjun);
	}
	fenshu=fenshu/n;
	return fenshu;
}