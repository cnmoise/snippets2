//Author: Claudiu Moise || Homework 7 || Problem 2
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//
//

public class Shoe
{
	private String brand;
   private double size;
   private String color;

   public Shoe(String b, double s, String c)
   {
      this.brand = b;
      this.size = s;
      this.color = c;
   }
   
   public void display()
   {
      System.out.println("Brand: " + this.brand);
      System.out.println("Size: " + this.size);
      System.out.println("Color: " + this.color);
   }

}