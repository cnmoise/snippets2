//Author: Claudiu Moise || Homework 8 || Problem 2
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//
//Takes a string of 0101011 and flips all the 0's to be 1's and vice versa

import java.util.*;

public class ComplementTest
{
    public static void main(String[] args)
    {
    	handleComplementCall("101010");
      handleComplementCall("000");
    	handleComplementCall("11111111");
    	handleComplementCall("047&3921t");
    }
	
	public static void handleComplementCall(String s)
	{
      try
      {
         String retStr = Complement.onesComplement(s);//the exception is thrown in our subclass    
         System.out.println(retStr);//skipped by our throw          
      }
      catch(InputMismatchException e)//executes if exception is thrown, 
      {
         System.out.println(e.getMessage());
         e.printStackTrace(); 
      }    
    
	}
}