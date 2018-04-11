//Author: Claudiu Moise || Homework 7 || Problem 2
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//
//

public class Stiletto extends Shoe
{
	private double height;
   
   public Stiletto(String b1, double s1, String c1, double h)//still need to pass in values for the super constuctor
   {
      super(b1, s1, c1);//used Shoe's constructor to set these vars, ensure same order
      this.height = h;   
   }
   
   public double getHeight()
   {
      return this.height;
   }
   
   @Override//not technically needed
   public void display()
   {
      super.display();//executes code from superclass, whole point of inheritance.
      //helps us avoid writing the code again
      System.out.println("Height: " + getHeight());
      //Rem: No, there is no such thing as super.this.brand
      //you have to create getter methods if you want to use the datafields in your child classes
   }
   //Overrides shoe's display class
}

