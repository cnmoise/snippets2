//Author: Claudiu Moise, Exam Problem , 4/27/16
//takes the inputed integer, and converts it into an array of integers
//each row starts at 0, and ends at the digit

public class arrayOfDigits
{
	public static void main(String[] args)
	{
      int n = 247;
      String f = String.valueOf(n);
      int Nr = f.length();//used to initalize num of rows
      int[][] goal = new int[Nr][];
      
      //we look at the ith place in our string, take the character at that position
      //convert the character into an integer
      //we use that as the basis of creating the new array
      for(int i = 0; i < Nr; i++)
      {
         String q = String.valueOf(f.charAt(i));
         int c = Integer.parseInt(q);//can only parse from a string
         goal[i] = new int[c+1];// new datatype[#];
      }
      
      for(int r = 0; r < goal.length; r++)
      {
         for(int c = 0; c < goal[r].length; c++)
         {
            goal[r][c] = c;         
         }
      }
      
      for(int r = 0; r < goal.length; r++)
      {
         for(int c = 0; c < goal[r].length; c++)
         {
            System.out.print(goal[r][c]);         
         }
         System.out.println();
      }
   }  
}