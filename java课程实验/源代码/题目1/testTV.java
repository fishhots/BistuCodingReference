import java.util.Scanner;
public class testTV extends TV{
	static public void main(String[] args)
	{
	TV tv1=new TV();
	tv1.turnOn();
	Scanner sc=new Scanner(System.in);
	tv1.setVolumn(sc.nextInt());
	tv1.setChannel(sc.nextInt());
	sc.close();
	System.out.println("tv��������Ƶ��Ϊ"+tv1.getVolumn()+"��"+tv1.getChannel());
	tv1.channelUP();
	tv1.volumeDown();
	System.out.println("��Ƶ�����������������Ƶ��Ϊ"+tv1.getVolumn()+"��"+tv1.getChannel());
	tv1.turnOff();
	}	
}
