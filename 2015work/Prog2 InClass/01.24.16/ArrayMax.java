//This program tries to find the maximum value in the matrix and
//then the min value

import java.util.Scanner;

public class ArrayMax
{
   public static void main(String[] args)
   {
      int[][] a = {{3, 9, 10},
                   {-1, 15}};
                   
      printMax(a);//invoking the array
   }
   
   public static void printMax(int[][] a)
   //a stands for array, be sure to use the name that you declared it as
   {
      int max = a[0][0];
      for (int row = 0; row < a.length; row++)
      {
         for (int col = 0; col < a[row].length; col++)
         {
            if (a[row][col] > max)
               max = a[row][col];
         }
      }
      
      System.out.println(max);
   }
}