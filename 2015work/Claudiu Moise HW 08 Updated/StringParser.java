//Author: Claudiu Moise || Homework 8 || Problem 1
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//Takes a String and two chars, then finds any integer between a & b
//returns the integer and all of its divisors

//Ver. 1.2
//Uses exception handling instead of an if statement

public class StringParser

{

   public static void findIntegerDivisors(String source, char a, char b)
   {
      int indexStore1 = source.indexOf(a); //finds the first instance of the char specified, returns its index
      int indexStore2 = source.indexOf(b, indexStore1+1); //Negates the symbols being the same
      
      String goalS = source;
      goalS = goalS.substring(indexStore1+1, indexStore2);
      //extracts the number, first as a string
      //need to +1 the index because substring will include the 1st index in the substring but not the 2nd
      
         try//like a for loop, all of the variables are local to this try block and can only be seen inside here
         {
            int goalI = Integer.parseInt(goalS);//Risky Code
            //then we wrap it up as an Int so we can go through it
            
            for(int j = 1; j <= goalI; j++)///prints the divisors of the int found
               {
               if(goalI % j == 0)
                  {
                     System.out.print(j + " ");
                  }           
               }
            System.out.println();
            
         }
         catch (NumberFormatException e)
         {
           System.out.println("Invalid Characters");
           System.out.println(e.toString());   
         }    
   }
}

