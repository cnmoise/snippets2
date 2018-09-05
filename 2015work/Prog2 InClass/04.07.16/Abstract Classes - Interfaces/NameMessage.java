public class NameMessage extends Message implements Printable
{
   private String name;
   
   public NameMessage(String s1, String s2)
   {
      super(s2);//super must be first in constructor
      this.name = s1;
   }
   
   public String modifyMessage(String s)
   {
      String repS = s.replaceAll("[aeiouAEIOU]" , "");
      return repS;
   }
   
   public void print()
   {
      System.out.print(this.name);
      System.out.print("("+modifyMessage(this.name)+")");
      System.out.println(super.getMessage());
   }
}