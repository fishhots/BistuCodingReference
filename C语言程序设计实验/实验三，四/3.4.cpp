#include<stdio.h>
#include<string.h>
int main()
{
	int x,p;
	int a;
	int b[100];
	int s=0,num;
	for(int i=0;i<100;i++)
	b[i]=999;
	char n;
    num=1;
	printf("What do you want to do?:\n1:input(i)\n2:delete(d)\n3:change(s)\n4:sort(s)\n5:reinput(r)\n6:output(c)\n7:exit(e)\n");

	while(num)
	{
	scanf("%c",&n);
	switch (n)
	{
	//	case 'i':
			{
				
			}
		case 'd':
			int x;
			printf("Which one do u want to delete?\n");
			scanf("%d",&x);
			for(int i=x;i<n;i++)
			{
				b[x]=b[x+1];
			}
			break;
		case 'u':
			printf("Which one do u want to change?\n");
			scanf("%d",&x);
			printf("u want change it to ");
			scanf("%d",&b[x]);
			break;
		case 's':
			int i;
		   
			for(i=0;i<x-1;i++)
                {
    	              for(int j=i+1;j<x;j++)
    	             {
    		          if(b[i]>b[j])
    		              {
    			           a=b[i];
    			           b[i]=b[j];
    			           b[j]=a;
			              }
		             }
		             
		             
	            }
	            for(int i=0;i<p;i++)
		             printf("%d ",b[i]);
		             printf("\n");
	            break;
	    case 'r':
			
				
				while(1){
                          scanf("%d",&num);
                          char c=getchar();
                          a[s++]=num;
                          if(c=='\n')
						  {
                              break;
                          };
                          	int x=0;
	                      	for(int i=0;;i++)
	                       	{
		              		if(a[i]==999)
							break;
							else
							{				
	    							x++;
							}
				
			               break;
		case 'c':
		    
		    for(int i=0;i<p;i++)
		    {
		    	printf("%d ",b[i]);
			}
			break;
		case 'e':num=0;break;
	}
}
}