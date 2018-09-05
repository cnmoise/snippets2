

public class TestTheWordInheritance
{ 
   public static void main(String[] args)
   {
      char[] c = {'c','o','p','y'};
      TheBrokenWord tbw = new TheBrokenWord("uncopyrightable", c);
      System.out.println(tbw.getBrokenWordAsString());
      System.out.println(tbw.wordContainsBrokenWord());
      
      TheBrokenWord tbw2 = new TheBrokenWord("Copyrightable", c);
      System.out.println(tbw2.wordContainsBrokenWord());
   }

}