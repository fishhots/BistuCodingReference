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
		System.out.print("����"+a.getName()+"\n����"+a.getAge()+"\n����ָ��"+a.getBMI()+"\n����״��"+a.getStatus());
		sc.close();
	}

}
