public class TestTime
{
	public static void main(String[] args)
	{
		System.out.println("This object uses the default Time constructor: ");
		Time t1 = new Time();
		System.out.println("The total number of seconds is: " + t1.getTotalSeconds());
		System.out.println("The total number of minutes is: " + t1.getTotalMinutes());
		System.out.println();
		
		System.out.println("This object uses the other Time constructor: ");
		Time t2 = new Time(3, 27, 55);
		System.out.println("The total number of seconds is: " + t2.getTotalSeconds());
		System.out.println("The total number of minutes is: " + t2.getTotalMinutes());
		
	}
}