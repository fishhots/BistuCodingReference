import java.util.Scanner;
public class testAccount {
	static public void main(String[] args)
	{
		java.util.Scanner sc=new Scanner(System.in);
		Account a=new Account();
		System.out.print("�������˻�ID\n");
		a.setId(sc.nextInt());
		System.out.print("�������˻����\n");
		a.deposit(sc.nextDouble());
		System.out.print("��Ҫȡ���Ľ��\n");
		a.withdraw(sc.nextDouble());
		System.out.print("����������˻����\n");
		a.deposit(sc.nextDouble());
		sc.close();
	}
}
