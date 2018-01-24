//Author: Claudiu Moise
import java.util.Scanner;

public class Shifted
{
      public static void main(String[] args)
      { 
      
      Scanner kb = new Scanner(System.in);
      
      System.out.print("Total numbers to input? ");
      int arrLen = kb.nextInt();
      
      int arr[] = new int[arrLen];
      
      System.out.print("Enter numbers: ");
      for(int i = 0; i < arr.length; i++)//this will take all of the users input
      {
         arr[i] = kb.nextInt();
      }
      
      System.out.print("After the shift: ");
      
      arr = shiftLeft(arr);
      //we have to store the value of the method
      //this we have to do because we created a different array for our shiftLeft method
      //therefore the original array has stayed the same
      
      for(int i = 0; i < arr.length; i++)
         {
            System.out.print(arr[i] + " ");
         }
      }
      
      public static int[] shiftLeft(int[] nums)
      {
         int repNum = nums[0];
         int repArr[] = new int[nums.length];

         
         for(int i = 0; i < nums.length; i++)//for loop will 
            if(i != nums.length-1)
               repArr[i] = nums[i+1];
            else
               repArr[nums.length-1] = repNum;
         
         return repArr;
      }
}

