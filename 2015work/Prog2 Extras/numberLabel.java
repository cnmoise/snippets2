
public class numberLabel
{

   public static void main(String[] args)
   {
      int n = 18;
      //int j = 0;
      int i = 1;
      int numSum = 0;
      //int[] divisors = new int[20];
      
      while(i <= n)
         {
         if(n % i == 0)
            {
            //divisors[j] = i;//assigns the value of the divisor at a position
            //j++;
            numSum += i;
            }
         i++;
         }
      
      if(numSum < n*2)
      {
         System.out.println(n + " is deficient");
      }
      else if(numSum > n*2)
      {
         System.out.println(n + " is abundant");
      }
      else
         System.out.println(n + " is neither");
      
   }
   //if it has anything to do with divisors, consider using the remainder operator, it might be usefull
}