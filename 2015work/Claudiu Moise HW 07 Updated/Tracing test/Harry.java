public class Harry
{
   private int h;
      public Harry(int h)
      {
         System.out.println("Harry");
         this.h = h;
      }
      
      public int getH()
         {
         return this.h;
         }
      
      public void m1()
         {
         System.out.println("Harry1");
         }
         
      public void m2()
         {
         m1();
         System.out.println("Harry2");
         }
      
      public boolean equals(Object o)
         {
         Harry h1 = (Harry) o;
         System.out.println("Harry Equality");
         boolean e = false;
         if (this.h == h1.getH())
            e = true;
         return e;
         }
}