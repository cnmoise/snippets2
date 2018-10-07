//Author: Claudiu Moise || Homework 6 || Problem 2
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//
//RESTRICTION: no loops or conditionals


public class OnlyDigits
{
	public static boolean hasOnlyDigits(String sample)
   {
      return sample.matches("-?[0-9]*");
      //GT: ? is a metacharacter, not really needed
      //Matches the preceding expression 0 or 1 times, could have used .*
      //[0-9]* matches any number of digits
      
      //matches is more powerful than .equals, bc of regex's
      //alt: boolean pos = sample.matches("[0-9]*"); 
      //b neg = sample.matches("-[0-9]*");
      //b isNum = pos || neg
      //return isNum
   }
}


