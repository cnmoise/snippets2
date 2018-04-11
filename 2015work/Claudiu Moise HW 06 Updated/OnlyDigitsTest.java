public class OnlyDigitsTest
{
	public static void main(String[] args)
	{
		String s1 = "194t";
		System.out.print(s1 + " is a valid integer? ");
		System.out.println(OnlyDigits.hasOnlyDigits(s1));
		
		String s2 = "ab33103c";
		System.out.print(s2 + " is a valid integer? ");
		System.out.println(OnlyDigits.hasOnlyDigits(s2));
				
		String s3 = "3348yue239";
		System.out.print(s3 + " is a valid integer? ");
		System.out.println(OnlyDigits.hasOnlyDigits(s3));
		
		String s4 = "-46231111";
		System.out.print(s4 + " is a valid integer? ");
		System.out.println(OnlyDigits.hasOnlyDigits(s4));
		
		String s5 = "631";
		System.out.print(s5 + " is a valid integer? ");
		System.out.println(OnlyDigits.hasOnlyDigits(s5));
	}
}