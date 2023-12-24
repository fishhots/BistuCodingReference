
public class Rectangle {
	static int numberOfRectangle;
	double width=1,height=1;
	public Rectangle()
	{
		
	}
	public Rectangle(double width,double height)
	{
		this.width=width;
		this.height=height;
	}
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	double getArea()
	{
		return width*height;
	}
	double getPerimeter()
	{
		return 2*(width+height);
	}
	static int getNumberOfRectangle()
	{
		return numberOfRectangle;
	}
}
