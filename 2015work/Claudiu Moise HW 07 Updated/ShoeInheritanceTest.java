public class ShoeInheritanceTest
{
	public static void main(String[] args)
	{
		System.out.println("Creating a regular shoe. ");
		Shoe s = new Shoe("Reebok", 10.0, "White");
		s.display();
		System.out.println();
		
		System.out.println("Creating a stiletto shoe.");
		Stiletto hh = new Stiletto("Stuart Weitzman", 6.0, "Black", 4.5);
		hh.display();
	}
}