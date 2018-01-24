//Author: Claudiu Moise

import java.util.Scanner;

public class Palindromes

{
   public static void main(String[] args)
      {
      Scanner kb = new Scanner(System.in);
      
      String userStr;
            
      System.out.print("Enter a sentence: ");
      userStr = kb.nextLine();
      
      
      if(isPalindrome(userStr) == false)
         System.out.println(userStr + " is not a palindrome");
      else
         System.out.println(userStr + " is a palindrome");

      }

   public static String reverse(String word)
      {
      String loopW = "", reverse = "";
      char letter = ' ';
      int curPos = 0;
      
      do 
      {
         letter = word.charAt(curPos);
         loopW += letter;
         
         curPos++;
                
         if (curPos == word.length())
         {
            for ( int i = word.length() - 1; i >= 0; i-- )
            {
                reverse = reverse + loopW.charAt(i);
               
            }
         }

      }
      while (curPos <= word.length()-1);
      
      return reverse;
      
      }
   
   public static boolean isPalindrome(String word)
      {
      if(word.equals(reverse(word)))//use .equals() when trying to compare String values
         {
         return true;
         } 
      else
         {
         return false;
         }
      }
  
}