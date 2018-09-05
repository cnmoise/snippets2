//Author: Claudiu Moise

//These are notes for Java Programming 1 and 2
//This program contains a variety of useful code 
//devices that can help in a variety of situations

//This program is not intended to execute
//REM = Study Reminder
import java.util.Scanner;
import java.lang.Math;

public class MasterJavaReviewDoc
{
   public static void main(String[] args)
   {
     
      
      for (int x = 0; x < iArr.length; x++)
			System.out.print(iArr[x] + " ");
		System.out.println();
      
      //Prints every element in an array
      //also example of a for loop structure
      
      
      //---------------------------------------------------------------------
      
      lrg = iArr[0];
      smlt = iArr[0];
      
      for (v = 0; v < iArr.length-1; v++)//-1 prevents out of bounds exception
      {
         if (iArr[v + 1] > lrg)
           lrg = iArr[v + 1];
           
         if (iArr[v + 1] < smlt)
            smlt = iArr[v + 1]; 
      }
      //creates an array to separate the int passed by the user
      //into single digits which we can test
      
       //---------------------------------------------------------------------
      while (p > 0)
      {
         p = p/10;
         i++;
      }
      int[] iArr = new int[i];
      //creates an array of i spaces, so our program 
      //has the exact space necessary to calc. everything

      for (i = 0; i < iArr.length; i++)    
      {
         r = p%10;
         p = p/10;
         iArr[i] = r;
      }
      //stores each digit into a space in the array
      //# after decimal point is lost bc were doing integer div


   }
   
}