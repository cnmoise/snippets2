

public class Letters
{
   
   public static String everyNLetters(String s, int n)//don't forget what methods are
   {
      if(s.length() < n || n < 0)//throws an exception conditions are met
         throw new IllegalArgumentException("n is invalid"); 
      
      char[] bruh = s.toCharArray();
      
      
      for(int i = n-1; i < bruh.length; i += n)//-1 bc 0 based
      {
         /*if(i+1 % n == 0)//+1 because arr is 0 based
         {
            bruh[i] = '*';
         }*/
         //could have worked but we can only use 1 if
         
         bruh[i] = '*';         
      }
      
      String pr = String.valueOf(bruh);
      return pr;
   }

}