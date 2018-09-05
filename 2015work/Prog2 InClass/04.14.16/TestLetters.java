public class TestLetters
{
   public static void main(String[] args)
   {
      handleEverNLetters("avenue", 2);
      handleEverNLetters("back to square one", 6);
      handleEverNLetters("brontosaurus", 12);
   }
   
   public static void handleEverNLetters(String s, int n)
   {
      try
      {
         
         System.out.println(Letters.everyNLetters(s,n));
      }
      catch(IllegalArgumentException e)
      {
         e.printStackTrace();
      }
   }
}
