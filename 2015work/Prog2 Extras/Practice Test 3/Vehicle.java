public abstract class Vehicle
{
   private int id;
   private String owner;
   
   protected Vehicle(int id, String o)
   {
      this.id = id;
      this.owner = o;
   
   }
   
   public void setOwner(String o)
   {
      this.owner = o;
   }
   
   public String toString()
   {
      String s = this.id + "\n";
      s += this.owner + "\n";
      return s;
   }
   
   public abstract void transferOwner(String o);
   public abstract void printInfo();
}