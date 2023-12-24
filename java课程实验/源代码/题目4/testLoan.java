import java.util.Scanner;
public class testLoan {
	public static void main(String[] args)
	{
	double a,c;
	int b;
	Scanner sc=new Scanner(System.in);
	a=sc.nextDouble();
	b=sc.nextInt();
	c=sc.nextDouble();
	sc.close();
	Loan loan=new Loan(a,b,c);
	System.out.print("贷款年利率是"+loan.getAnnuallnteresRate()+"\n贷款总额是"+loan.getLoanAmount()+"\n贷款年限是"+loan.getNumberOfYears()+"\n月还款额是"+loan.getMonthlyPayment(loan)+"\n还款总额是"+loan.getTotalPayment(loan));
	}
}
