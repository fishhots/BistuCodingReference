#include<stdio.h>
int a[100][100];
int main()
{
  int i,j,k,l,x,y,ad,m,n,p=0;
  printf("please input m and n:");
  scanf("%d %d",&m,&n);
  printf("Please input:\n");
  for(i=0;i<m;i++)
  {
     for(j=0;j<n;j++)
     {
        scanf("%d",&a[i][j]);
     }
  }
  printf("gai juzhen is:\n");
  for(i=0;i<m;i++)
  {
     for(j=0;j<n;j++)
     {
        printf("%d ",a[i][j]);
     }
     printf("\n");
  }
  for(i=0;i<m;i++)
  {
    for(j=0,ad=0;j<n;j++)
    {
       if(ad<=a[i][j])
       {
          ad=a[i][j];
          x=i;
          y=j;
       }
    }
    for(k=0,l=0;k<m;k++)
    {
      if(ad>a[k][y])
      {
        l++;
      }
    }
    if(l==0)
      {
        printf("[%d,%d,%d]is andian \n",ad,x+1,y+1);
        p=1;
      }
  }
  if(p==0)
    printf("NO\n");
  return 0;
}