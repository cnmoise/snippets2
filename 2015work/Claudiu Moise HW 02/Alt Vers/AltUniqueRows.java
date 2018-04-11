//Author: Claudiu Moise || Alt solution

//Determines which rows out of each matrix hold unique values

public class AltUniqueRows
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
		for (int i = 0; i < a.length; i++)
      {
         int count = 0;
         for (int j = 0; j < a[i].length; j++)
         {
            for (int k = 0; k < a[i].length; k++)
            {
               if (a[i][j] == a[i][k])//j checks against every value of k at all positions in the array
                  count++;//if j matches with k the count increases
            }//for k
         }//for j
         
         if (count == a[i].length)//only prints it out if there were no copies
            System.out.print(i + " ");
      }//for i
      System.out.println();
	   //very elegant, definetely an alien way of thinking about it
   }
}