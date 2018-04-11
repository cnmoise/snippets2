public class StringParserTest
{
	public static void main(String[] args)
	{
		String s1 = "rugtsbckgus!32*";
		System.out.println("String is: " + s1);
		StringParser.findIntegerDivisors(s1, '!', '*');
	
		String s2 = "disdkfjs<873>sfjsldkfiwx";
		System.out.println("String is: " + s2);
		StringParser.findIntegerDivisors(s2, '<', '>');
		
		String s3 = "rujfbgl&%fkslga";
		System.out.println("String is: " + s3);
		StringParser.findIntegerDivisors(s3, '&', '%');
	}
}