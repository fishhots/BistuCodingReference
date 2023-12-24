#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int no=1,i,j,flag;
int note=0;
int an,num;
int random(int i,int j,int note);
int jisuan(int an,int i,int j,int note);
int main()
{
	char op;
	srand((unsigned)time(NULL));
	while(no!=11)
	{
	i=(int)(1+rand()%99);
	j=(int)(1+rand()%99);
    note=random(i,j,note);
    no++;
    }
    printf("The num your right answer is %d",note);
}


int random(int i,int j,int note)
{
	int flag;
	flag=(int)(rand()%4);
	
	switch(flag)
    {
    	case 0:
    		an=i+j;
    		printf("No.%d : %d+%d=",no,i,j);
    		note=jisuan(an,i,j,note);
    		break;
    	case 1:
    		an=i-j;
    		printf("No.%d : %d-%d=",no,i,j);
    		note=jisuan(an,i,j,note);
    		break;
    	case 2:
    		an=i/j;
    		printf("No.%d : %d/%d=",no,i,j);
    		note=jisuan(an,i,j,note);
    		break;
    	case 3:
    		an=i*j;
    		printf("No.%d : %d*%d=",no,i,j);
    		note=jisuan(an,i,j,note);
    		break;
	}
	return note;
}
int jisuan(int an,int i,int j,int note)
{
	float answer;
	scanf("%f",&answer);
	if(answer==an)
	{
		note++;
		printf("Right!\n");
	}
	else
	printf("Wrong!\n");
	return note;
}