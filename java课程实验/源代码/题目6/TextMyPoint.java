package TestMyPoint;
import point.MyPoint;
import java.util.Scanner;
public class TextMyPoint {
public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	double a=input.nextDouble();
	double b=input.nextDouble();
	double q=input.nextDouble();
	double w=input.nextDouble();
	MyPoint p=new MyPoint();
	MyPoint p1=new MyPoint();
	MyPoint p2=new MyPoint();
	p1.setX(a);
	p1.setY(b);
	p2.setX(q);
	p2.setY(w);
	p.setX(12.3);
	p.setY(32.1);
	System.out.println("p1和p2的距离为"+MyPoint.distance(p1,p2));
	System.out.println("p1和p的距离为"+p1.distance(p));
	System.out.println("p和(12.3,32.1)的距离为"+p.distance(32.1,12.3));
}
}