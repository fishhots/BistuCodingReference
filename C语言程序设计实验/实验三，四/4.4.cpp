 #include<stdio.h>
int main()
{
	char a[7][13]={ };                          //制表
	for(int i=0;i<7;i=i+2)
	{
		for(int o=0;o<13;o++)       
		a[i][o]='-';
	}
	for(int i=1;i<6;i=i+2)
	{
		for(int o=0;o<13;o=o+4)
		{   
		a[i][o]='|';
	    }
	}
	int player=1,end=0,x,y;
	char b[7][13]={ };
	while(end==0)                           //循环开始
	{
	
	if(player==1)                          //A角色下棋
	{
		printf("Is A turn:");
		scanf("%d,%d",&x,&y);
		if(b[x*2+1][y*4+2]==' ')        //若为空位，则下X棋
		{
			a[x*2+1][y*4+2]='X';
			b[x*2+1][y*4+2]='x';
			player=-player;
		    for(int i=0;i<7;i++)        //棋盘
	        {
		        for(int o=0;o<13;o++)       
	     	    printf("%c",a[i][o]);
	      	    printf("\n");
	        }
		}
		else if(b[x][y]=='x'||b[x][y]=='o')  //若不为空，报错
		{
			printf("Sry u are wrong!\n");
			
			for(int i=0;i<7;i++)            //棋盘
        	{
	        	for(int o=0;o<13;o++)       
		        printf("%c",a[i][o]);
		        printf("\n");
        	}
		}
	}
	if(player==-1)                    //B角色下棋
	{
		printf("Is B turn:");
		scanf("%d %d",&x,&y);
		if(b[x][y]==' ')              //无占位，下O棋
		{
			a[x*2+1][y*4+2]='O';
			b[x*2+1][y*4+2]='o';
			player=-player;
			for(int i=0;i<7;i++)   //棋盘
	        {
        		for(int o=0;o<13;o++)       
        		printf("%c",a[i][o]);
	    	    printf("\n");
	        }
		}
		else 
		{
			printf("Sry u are wrong!\n");  //占位，报错
			
			for(int i=0;i<7;i++)   //棋盘
             	{
		             for(int o=0;o<13;o++)       
		             printf("%c",a[i][o]);
	        	     printf("\n");
	            }
		}
	}
	for(int i=1;i<=5;i=i+2)         //判断横行胜利
	{
		if(a[i][2]==a[i][6]&&a[i][2]==a[i][10]&&a[i][2]!=' ')
		{
			end=1;
			if(a[i][2]=='X')
			printf("A win!");
			else if(a[i][2]=='O')
			printf("B win!");
		}
    }
    for(int i=2;i<=10;i=i+4)      //判断竖行胜利
    {
    	if(a[1][i]==a[3][i]&&a[1][i]==a[5][i]&&a[5][i]!=' ')
    	{
    		end=1;
			if(a[i][2]=='X')
			printf("A win!");
			else if(a[i][2]=='O')
			printf("B win!");
		}
	}
	if(a[1][2]==a[3][6]&&a[1][2]==a[5][10]&&a[5][10]!=' ')   //判断斜着胜利
    {
    	    end=1;
			if(a[1][2]=='X')
			printf("A win!");
			else if(a[1][2]=='O')
			printf("B win!");
	}
	if(a[3][6]==a[1][10]&&a[3][6]==a[5][2]&&a[5][2]!=' ') //判断斜着胜利
	{
		    end=1;
			if(a[1][2]=='X')
			printf("A win!");
			else if(a[1][2]=='O')
			printf("B win!");
	}
	}
	
	
	
	
	
	
	
	
	
	for(int i=0;i<7;i++)       //棋盘
	{
		for(int o=0;o<13;o++)       
		printf("%c",a[i][o]);
		printf("\n");
	}
}