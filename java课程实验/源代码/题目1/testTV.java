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
	System.out.println("tv的音量和频道为"+tv1.getVolumn()+"和"+tv1.getChannel());
	tv1.channelUP();
	tv1.volumeDown();
	System.out.println("跳频道和音量后的音量和频道为"+tv1.getVolumn()+"和"+tv1.getChannel());
	tv1.turnOff();
	}	
}
