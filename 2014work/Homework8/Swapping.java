//Author: Claudiu Moise
import java.util.Scanner;

public class Swapping
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
      
      System.out.print("After the swap: ");
      
      swapEnds(arr);
      //The reason this works is because ARRAYS CHANGE IF YOU CHANGE THEM IN THE METHOD
      //we could have assigned the returned array to some other array
      
      for(int i = 0; i < arr.length; i++)
      {
         System.out.print(arr[i] + " ");
      }
      }
      
      public static int[] swapEnds(int[] nums)
      {
      int repNum = nums[0];
      nums[0] = nums [nums.length - 1];
      nums[nums.length - 1] = repNum;
      
      return nums;
      }
}

