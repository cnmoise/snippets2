//Author: Claudiu Moise || Homework 8 || Problem 2
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//
//Takes a string of 0101011 and flips all the 0's to be 1's and vice versa
//Restrictions: No loops, only one if statement (no else/else if)

import java.util.*;
import java.io.*;//Rem

public class Complement

{
   public static String onesComplement(String origStr) throws InputMismatchException
   {
      String compStr = origStr;
      
      if (compStr == "" || !compStr.matches("[01]*"))//regex checks for any number of 0's and 1's, also checks if nothing was inputted
         throw new InputMismatchException("Not a valid binary number");
         //GT, we throw an exception if our failure conditions are met
               
      compStr = compStr.replaceAll("0", "z");//z is an intermediary
      compStr = compStr.replaceAll("1", "0");
      compStr = compStr.replaceAll("z", "1");
      //code to make the complement
      return compStr;  
   }
}


