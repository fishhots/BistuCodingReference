public class BMI {
	private String name;
	private int age;
	private double weight;
	private double height;
	double x;
	public BMI()
	{
		
	}
	public BMI(String name,int age,double weight,double height)
	{
		this.name=name;
		this.age=age;
		this.weight=weight;
		this.height=height;
	}
	public BMI(double weight,double height)
	{
		this.weight=weight;
		this.height=height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height=height;
	}
	public double getBMI()
	{
		return (double)(weight/(double)(height*height));
	}
	public String getStatus()
	{
		if(getBMI()>=30.0)
			return "肥胖";
		else if(getBMI()>=25.0)
			return "超重";
		else if(getBMI()>=18.5)
			return "正常";
		else
			return "低重";
	}	
}