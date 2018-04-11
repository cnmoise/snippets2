public class HarryMaryLarryTest
{
   public static void main(String[] args)
      {
         Mary m = new Mary();
         m.m3();
         Larry la = new Larry();
         
         System.out.println(Mary.c);
         System.out.println(Larry.c);
         
         Harry[] hs = new Harry[4];
         hs[0] = new Harry(2);
         hs[1] = m;
         hs[2] = new Harry(5);
         hs[3] = la;
         
         for (int i = 0; i < hs.length; i++)
         {
            Harry h = hs[i];
            h.m1();
            h.m2();
            System.out.println(Larry.c);
         }
         
         for (int i = 1; i < hs.length; i++)
         {
            boolean b = hs[i-1].equals(hs[i]);
            System.out.println(b);
         }
   }
}