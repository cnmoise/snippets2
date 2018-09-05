public class Car extends Vehicle
{
   private String color;
   
   public Car(int i, String o, String c)
   {
      super(i,o);
      this.color = c;
   }
   
   public String toString()
   {
      String s = super.toString();
      s += this.color;
      return s;
   }
   
   public void transferOwner(String o)
   {
      super.setOwner(o);
   }
   
   public void printInfo()
   {
   System.out.println(this.toString());
   }
}