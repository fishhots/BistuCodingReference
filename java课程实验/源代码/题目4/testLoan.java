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
	System.out.print("������������"+loan.getAnnuallnteresRate()+"\n�����ܶ���"+loan.getLoanAmount()+"\n����������"+loan.getNumberOfYears()+"\n�»������"+loan.getMonthlyPayment(loan)+"\n�����ܶ���"+loan.getTotalPayment(loan));
	}
}
