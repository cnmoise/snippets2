//Author: Claudiu Moise || 3/08/16
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//
//Bayesian Classifier
//if the data fits into our general thing
//good for spam filtering
//% likelyhood of something being spam
//P(F|E), probability of F given E

public class Notes
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
   public boolean equals(Object o)
   {
      System.out.println("Word Equality");
      Word o1 = (Word) o;
      
      boolean e = false;
      if (this.getWord() != o1.getWord())
      {
         e = true;
      }
      
      return e;
   }   
   
}