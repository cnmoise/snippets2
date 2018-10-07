//Author: Claudiu Moise || Homework 6 || Problem 3
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//
//RESTRICTION: only one non-nested loop, no conditionals
//no String method can be used more than twice


public class Vowels
{
	public static int numberOfVowels(String sample)
   {
      String onlyVow = sample.replaceAll("[^AEIOUaeiou]", "");
      //deletes everything that is not what we want
      //replaces it with nothing, effectively deleting it
     
      return onlyVow.length();
   }
}