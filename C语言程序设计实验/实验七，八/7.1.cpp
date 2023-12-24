#include<stdio.h>
void yesterday(int *year,int *month,int *day);
void tomorrow(int *y,int *m,int *d);
int main()
{
	int y,m,d;
	printf("Please input the data:\n");
	scanf("%d %d %d",&y,&m,&d);
	yesterday(&y,&m,&d);
	tomorrow(&y,&m,&d);
}
void yesterday(int *year,int *month,int *day)
{
	int y=*year,m=*month,d=*day;
	if(d>=2&&d<=31)
	{
		d=d-1;
	}
	else
	{
		switch(m)
		{
			case 3:
				if(y%4==0)
					d=29;
				else
					d=28;
				m=m-1;
				break;
			case 5:
			case 7:
			case 10:
			case 12:
				d=30;
				m=m-1;
				break;
			case 1:
				m=12;
				d=31;
				y=y-1;
				break;
			default:d=31;m=m-1;break;
		}
		
	}
	printf("yesterday is %d-%d-%d\n",y,m,d);
}
void tomorrow(int *y,int *m,int *d)
{
	if(*d>=1&&*d<=27)
	*d=*d+1;
	else
	{
		if(*d==28)
		{
			if(*m==2)
			{	
			if(*y%4==0)
			*d=*d+1;
			else
			{
				*m=*m+1;
				*d=1;
			}
			}
			else 
			*d=*d+1;
		}
		else if(*d==29)
		{
			if(*m==2)
				{
				*m=*m+1;
				*d=1;
				}
			else
			{
				*d=*d+1;
			}
		}
		else if(*d==30)
		{
			switch(*m)
			{
				case 4:
				case 6:
				case 9:
				case 11:
					*m=*m+1;
					*d=1;
					break;
				default:*d=*d+1;break;
			}
		}
		else if(*d=31)
		{
			if(*m=12)
			{
				*y=*y+1;
				*m=1;
				*d=1;
			}
			else
			{
				*d=1;
				*m=*m+1;
			}
		}
	}
	printf("tomorrow is %d-%d-%d",*y,*m,*d);
}