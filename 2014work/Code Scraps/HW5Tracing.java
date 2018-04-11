public class HW5Tracing
{
public static void main(String[] args)
   {
      int width = 7;
      
      for (int row = 1; row <= width; row++)
         {
         int maxChar = width - row;
         int maxNum = row;
      
         for (int column = 1; column <= maxChar; column++)
            {
            if (column % 2 == 1)
               System.out.print("_");
            else
               System.out.print("o");
            }
         for (int column = 1; column <= maxNum; column++)
            {
               System.out.print(row);
            }
         System.out.println();
         }
   }
}