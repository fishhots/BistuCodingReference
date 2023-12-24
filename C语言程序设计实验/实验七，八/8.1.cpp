#include<stdio.h>
#include<string.h>
struct{
	char name[20];
	char sex[5];
	char Class[10];
	char xuehao[10];
	char grade[5][10];
}stu[100];
void duqu(FILE *fp);
void luru(FILE *fp,int n);
void shuchu(FILE *fp,int n);
void shanchu(FILE *fp,int n);
void xiugai(FILE *fp,int n);
int main()
{
	FILE *fp;
	int n;
	duqu(fp);
	printf("How many students do u want to insert?\n");
	scanf("%d",&n);
	luru(fp,n);
	shuchu(fp,n);
	shanchu(fp,n);
	xiugai(fp,n);
	
}
void duqu(FILE *fp)
{
	fp=fopen("C:\\text\\new","w");
	fputs("xuehao\tname\tsex\tclass\tS1\tS2\tS3\tS4\tS5\t\n",fp);
	fclose(fp);
	fp=fopen("C:\\text\\new","r");
	fscanf(fp,"%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",&stu[0].xuehao,&stu[0].name,&stu[0].sex,&stu[0].Class,&stu[0].grade[0],&stu[0].grade[1],&stu[0].grade[2],&stu[0].grade[3],&stu[0].grade[4]);
	fclose(fp);
}
void luru(FILE *fp,int n)
{
	fp=fopen("C:\\text\\new","a+");
	
	for(int i=1;i<=n;i++)
	scanf("%s %s %s %s %s %s %s %s %s",&stu[i].xuehao,&stu[i].name,&stu[i].sex,&stu[i].Class,&stu[i].grade[0],&stu[i].grade[1],&stu[i].grade[2],&stu[i].grade[3],&stu[i].grade[4]);
	for(int i=1;i<=n;i++)
	fprintf(fp,"%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n",stu[i].xuehao,stu[i].name,stu[i].sex,stu[i].Class,stu[i].grade[0],stu[i].grade[1],stu[i].grade[2],stu[i].grade[3],stu[i].grade[4]);
	fclose(fp);
}
void shuchu(FILE *fp,int n)
{
	for(int i=0;i<=n;i++)
	{
		printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n",stu[i].xuehao,stu[i].name,stu[i].sex,stu[i].Class,stu[i].grade[0],stu[i].grade[1],stu[i].grade[2],stu[i].grade[3],stu[i].grade[4]);
	}
}
void shanchu(FILE *fp,int n)
{
	printf("Which xuehao do u want to delete?\n");
	char l[10];
	scanf("%s",l);
	int flag;
	for(int i=1;;i++)
	{
		if(strcmp(l,stu[i].xuehao)==0)
		{
			flag=i;
			break;
		}
	}
	fp=fopen("C:\\text\\new","w");
	for(int i=0;i<=n;i++)
	{
		if(i!=flag)
		fprintf(fp,"%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n",stu[i].xuehao,stu[i].name,stu[i].sex,stu[i].Class,stu[i].grade[0],stu[i].grade[1],stu[i].grade[2],stu[i].grade[3],stu[i].grade[4]);
	}
	fclose(fp);
}
void xiugai(FILE *fp,int n)
{
	printf("Which xuehao do u want to change?\n");
	char l[10];
	scanf("%s",l);
	int flag;
	for(int i=1;;i++)
	{
		if(strcmp(l,stu[i].xuehao)==0)
		{
			flag=i;
			break;
		}
	}
	for(int i=0;i<=n;i++)
	{
		if(i==flag)
		scanf("%s %s %s %s %s %s %s %s %s",&stu[i].xuehao,&stu[i].name,&stu[i].sex,&stu[i].Class,&stu[i].grade[0],&stu[i].grade[1],&stu[i].grade[2],&stu[i].grade[3],&stu[i].grade[4]);
	}
	fp=fopen("C:\\text\\new","w");
	for(int i=0;i<=n;i++)
	fprintf(fp,"%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n",stu[i].xuehao,stu[i].name,stu[i].sex,stu[i].Class,stu[i].grade[0],stu[i].grade[1],stu[i].grade[2],stu[i].grade[3],stu[i].grade[4]);
	fclose(fp);
}