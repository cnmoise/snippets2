//Author: Claudiu Moise || Homework 2 || Problem 1
//Determines which rows out of each matrix hold unique values

public class UniqueRows
{
	public static void main(String[] args)
	{
		char[][] b = { { 'i', 'o', 'o', 'p' },
					   { 'u', 'a', 'i', 'z' },
					   { 'm', 'n', 'm', 'l' },
					   { 'u', 'b', 'a', 't' } };
		// This should print out: 1 3
		printUniqueRows(b);  
		
		char[][] c = { { '8', 'l', 'n', 'q', 'h' },
					   { 'S', 's', 's', 's', 'S' },
					   { 'j', 'a', 'j', 'a', '4' },
					   { 'B', 'A', 'b', 'a', 'Z' }, 
					   { '5', '4', 'i', 'g', 'G' } };
		// This should print out 0 3 4
		printUniqueRows(c);
							
	}
	
	public static void printUniqueRows(char[][] a)
	{
		boolean isUnique = true;
      int[] uniqueRows = new int[a.length];//creates an array big enough to fit all the arrays if needed
      int uRi = 0;
      char ch;
      
      for (int i = 0; i < a.length; i++)//executes opp until no more rows left
      {
         for (int j = 0; j < a[i].length; j++)
         {
            ch = a[i][j];//keeps tabs on the current char being tested
            
            for (int k = j+1; k < a[i].length; k++)//tests each char in the row, starting next to the 1st one chosen
               {
               if (ch == a[i][k])//if it finds a char that matches it breaks the loop, setting isUnique to false
                  {
                  isUnique = false;
                  break;
                  }
               }
         }//for j 
            if (isUnique == false)
            {
               isUnique = true;//resets isUnique for subsequent runs
            }
            else
               {
               uniqueRows[uRi] = i;//notes down which the unique row is
               uRi++;//and how many we've had so we can both store it above and print the correct number of them below
               }
      }//for i
      
      if(isUnique)
         {
         for (int i = 0; i < uRi ; i++)
            System.out.print(uniqueRows[i] + " ");
         System.out.println(" ");
         }
      else
         System.out.println("Nothing is working.");

	}
}