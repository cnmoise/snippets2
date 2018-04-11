public class VowelsTest
{
	public static void main(String[] args)
	{
		String s1 = "banana";
		System.out.println(s1 + " has " + Vowels.numberOfVowels(s1) + " vowels");
      
		String s2 = "Veritas. Virtus. Libertas.";
		System.out.println(s2 + " has " + Vowels.numberOfVowels(s2) + " vowels");
		
		String s3 = "Veni, vidi, vici";
		System.out.println(s3 + " has " + Vowels.numberOfVowels(s3) + " vowels");
	}
}