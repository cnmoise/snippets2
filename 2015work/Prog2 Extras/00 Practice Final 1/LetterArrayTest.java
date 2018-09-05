public class LetterArrayTest
{
	public static void main(String[] args)
	{

      LetterArray sa1 = new LetterArray("aspire to inspire");
      System.out.println(sa1.getLine());
      sa1.createLetterArray();
      sa1.printLetterArray();
      System.out.println();
      
      LetterArray sa2 = new LetterArray("veni vidi vici");
      System.out.println(sa2.getLine());
      sa2.createLetterArray();
      sa2.printLetterArray();
      System.out.println();
      
      LetterArray sa3 = new LetterArray("verylongword");
      System.out.println(sa3.getLine());
      sa3.createLetterArray();
      sa3.printLetterArray();
   }
}