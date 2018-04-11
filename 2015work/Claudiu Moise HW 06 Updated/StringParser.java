//Author: Claudiu Moise || Homework 6 || Problem 1
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//
//RESTRICTION: can only use one loop (for finding the divisors)
//and two conditional (if)

//Ver. 1.1

public class StringParser
{
	public static void findIntegerDivisors(String source, char a, char b)
   {
      int indexStore1 = source.indexOf(a); //finds the first instance of the char specified, returns its index
      int indexStore2 = source.indexOf(b, indexStore1+1); 
      //Need to use a different constructor for indexOf to accomodate s4
      //if they use the same symbol, it needs to know to go to the next one
      //once the first has been found
      
      String goalS = source;//
      goalS = goalS.substring(indexStore1+1, indexStore2);//extracts the number, first as a string
      //need to +1 the index because substring will include the 1st index in the substring but not the 2nd
      
      if (goalS.equals("") == false)//strings use the .equals method, .equals returns a boolean
      //done to accomodate s3, where our substring is empty
      //alt: if (goalS.length() > 0)
      //reduntant, could do (!goalS.equals(""))
         {
         int goalI = Integer.parseInt(goalS);//then we wrap it up as an Int so we can go through it
         
         for(int j = 1; j <= goalI; j++)///prints the divisors of the int found
            {
            if(goalI % j == 0)
               {
                  System.out.print(j + " ");
               }           
            }
         System.out.println();
         
         }
      else
         System.out.println("No integer found.");

   }
}