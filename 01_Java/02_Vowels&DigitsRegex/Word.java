//Author: Claudiu Moise || Homework 7 || Problem 3
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//
//

public class Word
{
	private String word;
   
   public Word(String w)
   {
      this.word = w;
   }
   
   public String getWord()
   {
      return this.word;
   }
   
   @Override
   public boolean equals(Object o)//remember the header and datatype must be the same for overriding
   {
      Word o1 = (Word) o;//most important part, we cast the object as something we want to compare to
      System.out.println("Word Equality");//also lets us use .getWord()
      boolean e = false;
      if (this.getWord().equals((o1.getWord())))//No, not the same as the == operator, 
      {//.equals checks the char sequence to see if it is the same
      //typically we want to become more elaborate than this
         e = true;
      }
      
      return e;
   }   
   
}