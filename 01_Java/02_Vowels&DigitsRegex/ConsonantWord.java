//Author: Claudiu Moise || Homework 7 || Problem 3
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//
//

public class ConsonantWord extends Word
{
	private String cWord = "";
   
   public ConsonantWord(String s)//we still need to pass something in
   {
      super(s);//same as doing this.word = s;
      this.cWord = s.replaceAll("[aeiouAEIOU]", "");//Rem: Propper format
      //replaceAll, only replace method that can use regex
   }
   
   public String getCword()
   {
      return this.cWord;
   }
      
   public boolean isSubstring()//determines if cWord is a substring of the superclass instance variable
   {
      String tWord = super.getWord();//gets our complete word, such as apple
      String tester = getCword();//gets our consonant word, such as ppl
      
      return tWord.matches(".*" + tester + ".*");//checks if the consonant word, is a continguous part of the complete word 
      //GT 
      //good way to avoid the contains method
      
   }
}