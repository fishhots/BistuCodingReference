import java.util.Scanner;
public class testRectangle {
	static public void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Rectangle.numberOfRectangle++;
		Rectangle r1=new Rectangle(sc.nextDouble(),sc.nextDouble());
		
		System.out.print("��Ϊ"+r1.width+"\t��Ϊ "+r1.height+"\t���Ϊ "+r1.getArea()+"\t�ܳ�Ϊ "+r1.getPerimeter()+"\t���ζ���ĸ���Ϊ"+Rectangle.getNumberOfRectangle()+"\n");
		
		Rectangle.numberOfRectangle++;
		Rectangle r2=new Rectangle();
		r2.setWidth(sc.nextDouble());
		r2.setHeight(sc.nextDouble());
		System.out.print("��Ϊ"+r2.width+"\t��Ϊ "+r2.height+"\t���Ϊ "+r2.getArea()+"\t�ܳ�Ϊ "+r2.getPerimeter()+"\t���ζ���ĸ���Ϊ"+Rectangle.getNumberOfRectangle());
		sc.close();
	}
}
