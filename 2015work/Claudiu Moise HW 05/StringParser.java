//Author: Claudiu Moise || Homework 5 || Problem 2
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//Takes a String and two chars, then finds any integer between a & b
//returns the integer and all of its divisors
//GT = Great tool, note for review

//Ver. 1.0

public class StringParser
{
   //static methods are used when you want to use a method WITHOUT making an object
   public static void findIntegerDivisors(String source, char a, char b)
   {
      int indexStore1 = 0;
      int indexStore2 = 0;
      String goal = "";
      int tg = 0;
      
      indexStore1 = source.indexOf(a); //finds the char specified, returns its index
      indexStore2 = source.indexOf(b); //GT! //other ways to do this?
      //Alt:
     
      /*for(int i = 0; i< s.length(); i++)
      if (s.charAt(i) == a)
            indexStore1 = i
      else if (s.charAt(i) == a)
            indexStore2 = i
            
            */
      
      for(int i = indexStore1+1; i < indexStore2; i++)
      {
         goal += source.charAt(i);//takes our chars and stores them into a String
         //charAt looks at the index and gives back the char 
         //GT
      }
      if (goal != "")//checks to see if NO integers were found between the two chars
         {
         tg = Integer.parseInt(goal);//converts the String to an int
         //Alt. Integer.valueOf(goal)

         for(int j = 1; j <= tg; j++)///prints the divisors of the int found
            {
               if(tg % j == 0)//REM: no ; after an if
               {
                  System.out.print(j + " ");
               }
            }
            System.out.println();
            //GT
         }
      else
         System.out.println("No integer found.");
      
      
   }
}