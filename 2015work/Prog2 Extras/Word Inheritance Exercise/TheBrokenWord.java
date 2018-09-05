

public class TheBrokenWord extends TheWord
{
	private char[] brokenWord;
   
   public TheBrokenWord(String s, char[] chA)
      {
         super(s);
         this.brokenWord = chA;
      }
   
   public String getBrokenWordAsString()
      {
       return String.valueOf(this.brokenWord);//returns string representation of the char Array
       //String valueOf(x)
       //get it? its a play on words 
       //--
       //were calling a method of the String class
       //and have to use the .
      }
   
   public boolean wordContainsBrokenWord()
      {
      //String wo = super.getWord();
      String bwo = getBrokenWordAsString();
      return super.hasString(bwo);//no need to specify wo
      }
}