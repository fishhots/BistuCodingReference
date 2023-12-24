import java.lang.Math;
import java.util.*;
import java.util.Scanner;
public class Loan {
	private double annuallnteresRate;
	private int numberOfYears;
	private double loanAmount;
	Date loanDate;
	public Loan()
	{
		Date date=new Date();
		loanDate=date;
	}
	public Loan(double a,int b,double c)
	{
		Date date=new Date();
		loanDate=date;
		this.annuallnteresRate=a;
		this.numberOfYears=b;
		this.loanAmount=c;
	}
	public double getAnnuallnteresRate() {
		return annuallnteresRate;
	}
	public void setAnnuallnteresRate(double annuallnteresRate) {
		this.annuallnteresRate = annuallnteresRate;
	}
	public int getNumberOfYears() {
		return numberOfYears;
	}
	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
    public double getMonthlyPayment(Loan a)
	{
	    double i;
	    i=(a.annuallnteresRate/1200)*a.loanAmount;
	    double x=Math.pow(1+a.annuallnteresRate/1200,a.numberOfYears*12);
	    double y=(double)(1/x);
	    double p=1.0-y;
	    double l=i/p;
		return	l;
	}
	public double getTotalPayment(Loan a)
	{
	    return a.getMonthlyPayment(a)*a.numberOfYears*12;
	}
	public Date getLoanDate()
	{
		return loanDate;
	}
}
