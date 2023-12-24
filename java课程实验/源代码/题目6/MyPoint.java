package point;
public class MyPoint {
	private double x;
	private double y;
	public MyPoint(){
	x=0;
	y=0;
	}
	public MyPoint(double a,double b)
{
	this.x=a;
	this.y=b;
}
	public double getX() {
	return x;
}
	public void setX(double x) {
	this.x = x;
}
	public double getY() {
	return y;
}
	public void setY(double y) {
	this.y = y;
}
	public static double distance(MyPoint p1, MyPoint p2){
	double a=p1.getX();
	double b=p1.getY();
	double q=p2.getX();
	double w=p2.getY();
	return Math.sqrt((a-q)*(a-q)+(b-w)*(b-w));
}
	public double distance(MyPoint p){
	double a=this.x;
	double b=this.y;
	double q=p.getX();
	double w=p.getY();
	return Math.sqrt((a-q)*(a-q)+(b-w)*(b-w));
}
	public double distance(double x,double y){
	double a=this.x;
	double b=this.y;
	double q=x;
	double w=y;
	return Math.sqrt((a-q)*(a-q)+(b-w)*(b-w));
}
	
}
