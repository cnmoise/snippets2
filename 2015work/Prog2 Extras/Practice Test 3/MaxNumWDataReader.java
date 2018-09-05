import java.util.*;
import java.io.*;

public class MaxNumWDataReader
{
   public static void main(String[] args)
   {
      File fi = new File("data.txt");
      try
      {
         Scanner in = new Scanner(fi);
         int c = 0;//for keeping track of the number of rows
         
         while(in.hasNext())
         {
            int[] mN = new int[3];//maxNumber
            for(int i = 0; i < 3; i++)
            {
               mN[i] = in.nextInt();
            }
            int lrg = mN[0];
            
            for(int v = 1; v < mN.length; v++)
            {
               if(mN[v] > lrg)
                  lrg = mN[v];               
               
            }
            System.out.println("Max: " + lrg);
            c++;
             
             
         }
         System.out.println("Total: " + c);
         in.close();
      }
      catch(FileNotFoundException e)
      {
         System.out.println("FileNotFoundException");
      }
   }
}