import java.util.Scanner;
public class testMyInteger {
public static void main(String[] args){
 Scanner input=new Scanner(System.in);
 int a=input.nextInt();
 MyInteger n1=new MyInteger();
 n1.MyInteger(a);
 System.out.println("n1��ż����"+"\t"+n1.isEven());
 System.out.println("n1��������"+"\t"+n1.isPrime());
 System.out.println("n1��������"+"\t"+MyInteger.isPrime(n1));
 MyInteger n2=new MyInteger();
 int b=input.nextInt();
 n2.MyInteger(b);
 System.out.println("n2��������"+"\t"+n2.isOdd());
 System.out.println("45��������"+"\t"+n1.isOdd(45));
 System.out.println("n1��n2�����"+"\t"+n1.equals(n2));
 System.out.println("n1�ǵ���5��"+"\t"+n1.equals(5));
 }
}