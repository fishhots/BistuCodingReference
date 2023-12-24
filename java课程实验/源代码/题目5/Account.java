
public class Account {
	private int id=0;
	private double balance=0;
	public Account()
	{
		
	}
	public Account(int id,double balance)
	{
		this.id=id;
		this.balance=balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double b) {
		balance = b;
	}
	public void withdraw(double b)
	{
		if(b>this.balance)
		{
			System.out.print("余额不足");
		}
		else
			{
			balance=balance-b;
			System.out.print("取款后余额是"+getBalance());
			}
	}
	public void deposit(double b)
	{
		balance=balance+b;
		System.out.print("存款后余额是"+getBalance());
	}
}
