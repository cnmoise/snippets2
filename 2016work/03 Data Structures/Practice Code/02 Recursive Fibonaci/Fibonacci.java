import java.math.*;
//Using Recursion methods



public class Fibonacci
{
	public static void main(String[] args)
	{
      for (int i = 0; i <= 10; i++)
         System.out.println(fibRec(i));
         
      System.out.println();
      
      for (int i = 0; i <= 10; i++)
         System.out.println(fibIter(i));
         
      System.out.println();
      
      //test last thing
	}
	
	public static int fibRec(int n)//recursive call //slower of the two
	{
        if(n == 0 || n == 1)//base case
            return 1;
        else
            return fibRec(n-1) + fibRec(n-2);//calls itself multiple times
   }
   
   public static int fibIter(int n) //itterative approach
   {
        if(n == 0 || n == 1)//base case
            return 1;
        
        int[] fibNumbers = new int[n+1];
        fibNumbers[0] = fibNumbers[1] = 1;//dies assugbnebts right to left
        
        for(int i = 2; i <= n; i++)
           {
           fibNumbers[i] = fibNumbers[i-1] +fibNumber[i-2];
           }
           
        return fibNumbers[n];
   }
   
   public static String recReverseString(String s)
   {
   //REM: define base case 1st always
      if(s.length() == 0 || s.length() == 1)
         return s;
      else
      {
         //will take the last letter in the strings
         char lastChar = s.charAt(s.length() - 1);
         String shorter = s.substring(0, s.length-1);
         
         return lastChar + recReverseString(shorter);
      }
   }
}