import java.util.Scanner;
public class testBMI {
	static public void main(String[] args)
	{
		BMI a=new BMI();
		Scanner sc=new Scanner(System.in);
		a.setName(sc.next());
		a.setAge(sc.nextInt());
		a.setWeight(sc.nextDouble());
		a.setHeight(sc.nextDouble());
		System.out.print("姓名"+a.getName()+"\n年龄"+a.getAge()+"\n体重指数"+a.getBMI()+"\n体重状况"+a.getStatus());
		sc.close();
	}

}
