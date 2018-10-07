//Author: Claudiu Moise
public class Operations
{
	public static void main(String[] args)
	{
		int c = 3729, d = 22, e = 34, f = 67;
		System.out.println(e + " * " + f + " is " + multiply(e, f));
		System.out.println(c + " * " + d + " is " + divide(c, d));//logic error, its supposed to be /
      
   }
	
	public static int add(int a, int b)
	{
		return a + b;
	}
	
	public static int subtract(int a, int b)
	{
		return add(a, -1 * b);
	}
   
   public static int multiply(int a, int b)
	{
      int product = 0;
      int count = 1;
      
      while(count <= b)//how many times
         {
         count++;
         product += a;//34+34+34+34... 67 times
         }

      return product;
	}
   
   public static int divide(int a, int b)
   {
      int count = 0;
      
         while(a >= b)//6-2-2-2, we count the times that 2 enters into 6, which is 3
         //mainking the while statement a >= b ensures that we never enter into - numbers and overcount
         {
            count++;
            a = a - b;
         }
      
      return count;
   }
}