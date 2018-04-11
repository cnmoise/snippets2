public class Larry extends Harry
{
   public static int c = 0;
   
   public Larry()
   {
   super(5);
   System.out.println("Larry");
   c += super.getH();
   }
   
   public void m1()
   {
   System.out.println("Larry1");
   super.m1();
   c++;
   }
   
   public boolean equals(Object o)
   {
      Harry h1 = (Harry) o;
      System.out.println("Larry Equality");
      boolean e = false;
      if (this.getH() != h1.getH())
         e = true;
      return e;
   }
}