//Teacher provided

public class TestProblem1
{
	public static void main(String[] args)
	{
		Photograph p1 = new Photograph(124573, "Winter.jpg", 0.10);
		p1.setDescription("Photos of cold cold Chicago");
		Photograph p2 = new Photograph(124574, "Summer.jpg", 0.10);
		Photograph p3 = new Photograph(124575, "SpringFall.jpg", 0.25);
		p3.setDescription("Photos of Spring and Fall");
		
		Photograph[] p = { p1, p2, p3 };
		Album a1 = new Album(392840, "Leather", 2.75, p);
		
		a1.printDetails();
		double shipping = a1.calculateShippingCost(1);
		System.out.println("Shipping: " + shipping);
		
		double shipping2 = a1.calculateShippingCost(3);
		System.out.println("Shipping: " + shipping2);
	}
}