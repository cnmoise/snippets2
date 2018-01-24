//Authors: Claudiu Moise, Faraz Shaik, Joana Velazquez

import java.util.Scanner;
 
public class Palindrome
{
   public static void main(String args[])
   {
      String original, reverse = "";
      Scanner in = new Scanner(System.in);
 
      System.out.print("Enter a three-digit number:");
      original = in.nextLine();
 
      int length = original.length();
 
      for ( int i = length - 1; i >= 0; i-- )
         reverse = reverse + original.charAt(i);
 
      if (original.equals(reverse))
         System.out.println(original+ " is a palindrome.");
      else
         System.out.println(original+ " is not a palindrome.");
 
   }
}	