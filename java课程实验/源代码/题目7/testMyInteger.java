import java.util.Scanner;
public class testMyInteger {
public static void main(String[] args){
 Scanner input=new Scanner(System.in);
 int a=input.nextInt();
 MyInteger n1=new MyInteger();
 n1.MyInteger(a);
 System.out.println("n1是偶数吗？"+"\t"+n1.isEven());
 System.out.println("n1是素数吗？"+"\t"+n1.isPrime());
 System.out.println("n1是素数吗？"+"\t"+MyInteger.isPrime(n1));
 MyInteger n2=new MyInteger();
 int b=input.nextInt();
 n2.MyInteger(b);
 System.out.println("n2是奇数吗？"+"\t"+n2.isOdd());
 System.out.println("45是奇数吗？"+"\t"+n1.isOdd(45));
 System.out.println("n1与n2相等吗？"+"\t"+n1.equals(n2));
 System.out.println("n1是等于5吗？"+"\t"+n1.equals(5));
 }
}