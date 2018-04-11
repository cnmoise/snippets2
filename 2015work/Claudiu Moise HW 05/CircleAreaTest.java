public class CircleAreaTest
{
	public static void main(String[] args)
	{
		double r1 = 4.5;
		System.out.println("Area of a circle with radius " + r1 + " is: ");
		System.out.println(CircleArea.findArea(r1));
		
		double r2 = 37043833838848488383838383838383838383839320202048484848439384849494884593948483838484847384748494948848470212309323490123498736234920139457483901938475849309834734987234238409.38388393847923489723498723401;
		System.out.println("Area of a circle with radius " + r2 + " is: ");
		System.out.println(CircleArea.findArea(r2));
	}
}