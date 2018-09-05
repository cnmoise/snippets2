public class StringParserTest
{
	public static void main(String[] args)
	{
		String s1 = "rugtsbckgus!32*";
		System.out.println("String is: " + s1);
		StringParser.findIntegerDivisors(s1, '!', '*');
		System.out.println();
	
		String s2 = "disdkfjs<873>sfjsldkfiwx";
		System.out.println("String is: " + s2);
		StringParser.findIntegerDivisors(s2, '<', '>');
		System.out.println();
		
		String s3 = "rujfbgl&%fkslga";
		System.out.println("String is: " + s3);
		StringParser.findIntegerDivisors(s3, '&', '%');
		System.out.println();
		
		String s4 = "rusbdi#1038#jjdksu";
		System.out.println("String is: " + s4);
		StringParser.findIntegerDivisors(s4, '#', '#');
		System.out.println();
		
		String s5 = "rusbdi^10.38^jjdksu";//This is a double
		System.out.println("String is: " + s5);
		StringParser.findIntegerDivisors(s5, '^', '^');
		System.out.println();
	}
}