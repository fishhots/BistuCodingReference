#include<stdio.h>
void dayComputer(int *y,int *m,int *d,int *n);
int day(int *m,int *y);
int main()
{
	int y,m,d,n;
	printf("Please input the data:\n");
	scanf("%d %d %d",&y,&m,&d);
	printf("Please input n:\n");
	scanf("%d",&n);
	dayComputer(&y,&m,&d,&n);
}
void dayComputer(int *y,int *m,int *d,int *n)
{
	int da=0;
	*d=*d+*n;
	if(*n>=28)
	{
		*m=*m-1;
	while(*d-da>0)
	{
		*d=*d-da;
		da=day(m,y);
	}
    }
	printf("It is %d-%d-%d",*y,*m,*d);
}
int day(int *m,int *y)
{
int dy=0;
switch(*m)
{
	case 2:
		if(*y%4==0)
		{
			dy=29;
			*m=3;
		}
		else
		{
			dy=28;
			*m=3;
		}
		break;
	case 4:
	case 6:
	case 9:
	case 11:
		dy=30;
		*m=*m+1;
		break;
	case 12:
		dy=31;
		*m=1;
		*y=*y+1;
		break;
	default:dy=31;*m=*m+1;break;
}
return dy;
}