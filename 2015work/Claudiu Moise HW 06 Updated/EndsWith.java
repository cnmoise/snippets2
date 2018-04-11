//Author: Claudiu Moise || Homework 6 || Problem 4
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//
//RESTRICTION: only one loop, 2 conditionals
//no using contains, toUpperCase, toLowerCase 


public class EndsWith
{
	public static void endsWithIng(String sample)
   {
     String[] wordArr = sample.split(" ");//GT, finds every space and creates an array where each index place is a word
     boolean phraseContainsIng = false;    
     String wordTracker = "";//GT
     
     for(int i = 0; i < wordArr.length; i++)//goes through every word in the phrase
     {
         if(wordArr[i].matches(".*[Ii][nN][gG].*"))//matches returns a boolean, on false it skips this code
         //matches all lowercase/uppercase variants of ing
            {
            wordTracker += wordArr[i] + " ";
            phraseContainsIng = true;
            }      
     }
         System.out.println();
         
     if(phraseContainsIng == true)
     {
        System.out.println("Words with ing:");
        System.out.println(wordTracker);
        phraseContainsIng = false;//resets the phrases truth value
     }
     else
     {
       System.out.println("There are no words with ing.");
     }
   }
}