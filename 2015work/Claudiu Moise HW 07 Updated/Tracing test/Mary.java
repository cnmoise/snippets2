public class Mary extends Larry
{
   public Mary()
      {
      System.out.println("Mary");
      c += 2;
      }
   
   public void m2()
      {
      System.out.println("Mary2");
      c += super.getH();
      }
   
   public void m3()
      {
      super.m1();
      System.out.println("Mary3");
      }
}