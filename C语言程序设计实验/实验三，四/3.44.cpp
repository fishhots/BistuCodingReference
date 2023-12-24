#include<stdio.h>
int main()
{
	int b[100],flag=1,s=0,num,x=0,a,o,i;
	for(int i=0;i<100;i++)
	b[i]=999;
	char n;
	while(flag)
	{
	printf("What do you want to do?:\n1:input(i)\n2:delete(d)\n3:change(u)\n4:sort(s)\n5:reinput(r)\n6:output(c)\n7:exit(e)\n");
    scanf("%c",&n);
	switch (n)
	{
	  case 'r':
		while(1){
            scanf("%d",&num);
            char c=getchar();
            b[s++]=num;
            if(c=='\n')
			{
                break;
            }
            }
	        for(int i=0;;i++)
	        {
		        if(b[i]==999)
				break;
			    else				
	    		x++;
	    	}
	    	for(int i=0;i<x;i++)
		{
		  	printf("%d ",b[i]);
		}
		printf("\n");
			break;
		break;
	  case 'c':
		for(int i=0;i<x;i++)
		{
		  	printf("%d ",b[i]);
		}
		printf("\n");
		break;
	  case 'e':flag=0;break;
	  case 's':
			for(int i=0;i<x-1;i++)
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
	            for(int i=0;i<x;i++)
		            printf("%d ",b[i]);
		        printf("\n");
	            break;
	    case 'u':
			printf("Which one do u want to change?\n");
			scanf("%d",&a);
			printf("u want change it to ");
			scanf("%d",&b[a]);
			for(int i=0;i<x;i++)
		{
		  	printf("%d ",b[i]);
		}
		printf("\n");
			break;
		case 'd':
			printf("Which one do u want to delete?\n");
			scanf("%d",&a);
			for(int i=a;i<x;i++)
			{
				b[i]=b[i+1];
			}
			x--;
			for(int i=0;i<x;i++)
		{
		  	printf("%d ",b[i]);
		}
		printf("\n");
			break;
	    case 'i':
	    	printf("Which place do u want to insert?\n");
	    	scanf("%d",&o);
	    	a=b[o];
	    	for(int i=o;i<x;i++)
	    	{
	    		i=b[i+1];
	    		b[i+1]=a;
	    		a=i;
			}
			printf("u want insert ?\n");
			scanf("%d",&a);
			printf("\n");
			b[o]=a;
			for(int i=0;i<x;i++)
		{
		  	printf("%d ",b[i]);
		}
		printf("\n");
	        break;
	}
	
	}
}
