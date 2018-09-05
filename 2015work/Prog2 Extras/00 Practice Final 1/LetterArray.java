//Author: Claudiu Moise, Exam Problem , 4/27/16
//takes the inputed integer, and converts it into an array of integers
//each row starts at 0, and ends at the digit

public class LetterArray
{
   private String line;
   private char[][] letters;
   
   public LetterArray(String l)
   {
      this.line = l;   
   }
   public String getLine()
   {
      return this.line;
   }
   
   public void createLetterArray()
   {
      String d = getLine();//propper practice, we avoid having to write getLine everywhere
      String[] c = d.split(" ");//splits the phrase into units we can manip
      char[][] t = new char[c.length][];
      
      for(int i = 0; i < t.length; i++)
      {
        t[i] = new char[c[i].length()];//sets the number of columns, c[i].length gives us the number of letters in the word at position i in array c
        for(int k = 0; k < t[i].length; k++)
         {
            t[i][k] = c[i].charAt(k);  
         } 
      }
      
      this.letters = t;   
   }
   
   public void printLetterArray(){
      for(int r = 0; r < this.letters.length; r++)
      {
         for(int c = 0; c < this.letters[r].length; c++)
         {
            System.out.print(this.letters[r][c]+ " ");  
         } 
         System.out.println();
      }
   }
}