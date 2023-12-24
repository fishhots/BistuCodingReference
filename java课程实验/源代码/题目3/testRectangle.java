import java.util.Scanner;
public class testRectangle {
	static public void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Rectangle.numberOfRectangle++;
		Rectangle r1=new Rectangle(sc.nextDouble(),sc.nextDouble());
		
		System.out.print("宽为"+r1.width+"\t高为 "+r1.height+"\t面积为 "+r1.getArea()+"\t周长为 "+r1.getPerimeter()+"\t矩形对象的个数为"+Rectangle.getNumberOfRectangle()+"\n");
		
		Rectangle.numberOfRectangle++;
		Rectangle r2=new Rectangle();
		r2.setWidth(sc.nextDouble());
		r2.setHeight(sc.nextDouble());
		System.out.print("宽为"+r2.width+"\t高为 "+r2.height+"\t面积为 "+r2.getArea()+"\t周长为 "+r2.getPerimeter()+"\t矩形对象的个数为"+Rectangle.getNumberOfRectangle());
		sc.close();
	}
}
