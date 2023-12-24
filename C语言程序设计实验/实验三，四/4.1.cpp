#include <stdio.h>
#include <string.h>
main()
{   
    char a[10][80],x[80];
    int i,j;
    for(i=0;i<10;i++)
    gets(a[i]);
    for(i=0;i<9;i++)
    {
 for(j=i+1;j<10;j++)
 {
 
    if(strcmp(a[i],a[j])>0)
    {
     strcpy(x,a[j]);
  strcpy(a[j],a[i]);
  strcpy(a[i],x);
 }
    }
    } 
    for(i=0;i<10;i++)
 printf("%s ",a[i]);
}