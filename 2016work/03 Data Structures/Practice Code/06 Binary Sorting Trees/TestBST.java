//
import java.util.Scanner;

public class TestBST
{
   public static void main(String[] args)
   {
      BST mytree = new BST();
      Scanner conIn = new Scanner(System.in);
      int value;
      
      
      System.out.println("Enter the num to insert, -1 to stop");
   
      while (true)
      {
         value = conIn.nextInt();
         
         if (value != -1)
            mytree.add(value);
         else
            break;
      }
      
      System.out.println(mytree.size());
     
   }
}