public abstract class Message
{
   private String message;
   
   protected Message(String m)//protect your contructors in abstract classes
   {
      this.message = m;
   }
   
   public String getMessage()
   {
      return this.message;
   }
   
   public abstract String modifyMessage(String s);
   
}