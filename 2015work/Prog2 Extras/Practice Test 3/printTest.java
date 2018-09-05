import java.util.*;
import java.io.*;

public class printTest
{
   public static void main(String[] args)
   {
      printDividedString("avenue", 2);
      printDividedString("back to square one", 6);
      printDividedString("brontosaurus", 12);
   }

   public static void printDividedString(String s, int n)//don't forget what methods are
   {
      try{
      if(s.length()% n !=0)//if our word doesn't divide evenly, throw except 
         throw new IllegalArgumentException("String can't be div");
      int k = n;//we don't want to change the val of n, but we still need to increment our substring
      System.out.println("Start of div: "+ s + " " + n);
      for(int i = 0; i < s.length(); i += n)//we add n so that we can get neat little subsections
      {
         String pr = s.substring(i,k);
         k += n;
         System.out.println(pr);
      }
      
      
      }
      catch(IllegalArgumentException e)
      {
         System.out.println(e.getMessage());
      }
   }
}