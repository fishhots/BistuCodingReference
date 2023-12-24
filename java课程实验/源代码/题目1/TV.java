
public class TV {
	public int channel;
	public int volumeLevel;
	public boolean on;
	public TV()
	{
		
	}
	public void turnOn()
	{
		this.on=true;
	}
	public void turnOff()
	{
		this.on=false;
	}
	public void setChannel(int newChannel)
	{
		if(on)
		channel=newChannel;
	}
	public int getChannel()
	{
		
		return channel;
	}
	public void setVolumn(int newVolumn)
	{
		if(on)
		volumeLevel=newVolumn;
	}
	public int getVolumn()
	{
		
		return volumeLevel;
	}
	public void channelDown()
	{
		if(on)
			if(channel>1)
				channel=channel-1;
	}
	public void channelUP()
	{
		if(on)
			if(channel<120)
				channel=channel+1;
	}
	public void volumeUp()
	{
		if(on)
			if(volumeLevel<7)
				volumeLevel++;
	}
	public void volumeDown()
	{
		if(on)
			if(volumeLevel>1)
				volumeLevel--;
	}
}
