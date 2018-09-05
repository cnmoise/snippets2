public class Triangle extends Shape
{
   private double side1;
   private double side2;
   private double side3;
   
   public Triangle(String c, double s1, double s2, double s3)
   {
      super(c);
      this.side1 = s1;
      this.side2 = s2;
      this.side3 = s3;
   }
   
   public double getSide1()//check your return types!!!
   {
      return this.side1;
   }
   public double getSide2()
   {
      return this.side2;
   }
   public double getSide3()
   {
      return this.side3;
   }
   
   public double findPerimeter()
   {
    return getSide1()+getSide2()+getSide3();//parentheses for methods!!!
   }
}