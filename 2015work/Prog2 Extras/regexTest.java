public class regexTest
{
	public static void main(String[] args)
	{
		String s = "yr6a39skf378kdetbe7";
      String[] sA = s.split("[aeiou]");
      
      for(int i = 0; i < sA.length; i++)
         System.out.print(sA[i] + " " );
	}
}