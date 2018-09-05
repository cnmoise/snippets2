public abstract class Shape
{
   private String color;
   
   public Shape(String c)
   {
      this.color = c;
   }
   
   public String getColor()
   {
      return this.color;
   }
   
   public abstract double findPerimeter();
}