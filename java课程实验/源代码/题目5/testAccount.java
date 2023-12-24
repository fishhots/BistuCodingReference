import java.util.Scanner;
public class testAccount {
	static public void main(String[] args)
	{
		java.util.Scanner sc=new Scanner(System.in);
		Account a=new Account();
		System.out.print("请输入账户ID\n");
		a.setId(sc.nextInt());
		System.out.print("请输入账户余额\n");
		a.deposit(sc.nextDouble());
		System.out.print("需要取出的金额\n");
		a.withdraw(sc.nextDouble());
		System.out.print("请输入存入账户金额\n");
		a.deposit(sc.nextDouble());
		sc.close();
	}
}
