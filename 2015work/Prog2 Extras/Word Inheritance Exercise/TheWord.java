

public class TheWord
{
	private String word;
   
   public TheWord(String w)
      {
      this.word = w;
      }
   
   public String getWord()
      {
      return this.word;
      }
   
   public boolean hasString(String s)
      {
      return this.word.matches(".*" + s + ".*");//GT
      }
}