#include<stdio.h>
char n;
int panduan(char n);
int main()
{
	printf("Please input ");
	scanf("%c",&n);
	switch(panduan(n))
	{
		case 0:
			printf("Is num.");break;
		case 1:
			printf("Is lower letter.");break;
		case 2:
			printf("Is Capitalized word.");break;
		case 3:
			printf("Is others.");break;
		default:break;
	}
}
int panduan(char n)
{
	if(n<='9'&&n>='0')
	return 0;
	else if(n<='z'&&n>='a')
	return 1;
	else if(n<='Z'&&n>='A')
	return 2;
	else if(n=='#')
	return 999;
	else
	return 3;
}