//Author: Claudiu Moise || Homework 1 || Problem 2
//Takes a string and an int from the user
//if positive puts part of the begining at the end
//if negative, puts part of the end at the begining
//REM = Study Reminder
import java.util.Scanner;
import java.lang.Math;

public class RotateString
{
   public static void main(String[] args)
   {
      Scanner inp = new Scanner(System.in);
      //creating a Scanner class of object, same syntax
      //REM: in.nextTYPE, name you initialize the scanner as is used later in prog.
      
      String tStr = "";
      String xStr = "";
      
      System.out.println("Enter a string: ");
      String rStr = inp.nextLine();
      //REM: next LINE no such thing as nextString
      
      System.out.println("Enter an integer: ");
      int rInt = inp.nextInt(); 
      
      if ( rInt > 0 && Math.abs(rInt) < rStr.length())//checks if positive, and if case 3 
      //REM: propper spelling of length
      {
         tStr = rStr.substring(0, rInt);
         xStr = rStr.substring(rInt, rStr.length());//shouldnt (rInt) be enough?
         rStr = xStr + tStr;
         System.out.println("Rotated string:" + rStr);
         //grabs the substring from the start of the string (0) until hitting rInt
         //stores the substring grom the end of rInt
         //and then appends the two

      }
      else if ( rInt < 0 && Math.abs(rInt) < rStr.length())
      //checks if negative, and if case 3 
      //abs used to negate a bug inherent to neg. numbers in this interpretation
      {
         int endOfString = rStr.length() - Math.abs(rInt);
         //for clarity
         
         tStr = rStr.substring(endOfString, rStr.length());
         xStr = rStr.substring(0, endOfString);
         rStr = tStr + xStr;
         System.out.println("Rotated string:" + rStr);
         
      }
      else //case 3, where the number given by the user is larger than the number of chars in the string in question
      {
         System.out.println("Can't rotate the string.");
      }
      //program has a blindspot for 0
 
   }
   
/*   
      Propper implementation would require methods, but not needed for result
*/

}