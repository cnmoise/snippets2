//Author: Claudiu Moise || Homework 9 || Problem 1
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//
//This is an exercise in implementing interfaces and using abstract classes
//Everything here is fairly self-explanatory

public class Photograph extends Item implements Sellable
{
   private String description;
   private double price;

   public Photograph(int id, String name, double pr)
   {
      super(id, name);
      this.price = pr;
   }
   
   public void setDescription(String d)
   {
      this.description = d;
   }

   //Any abstract methods in Item and Sellable, must be implemented/overwritten here
   //Item
   public String getDescription()
   {
      return this.description;
   }
	
	public void printDetails()
   {
      System.out.println("ID: " + super.getId());//remember parentheses for methods
      System.out.println("Name: " + super.getName());
      System.out.println("Description: " + getDescription());
   }
   
   //Sellable
   public double getPrice()
	{
      return this.price;//note it is necessary for price to be initiated in order to write this method
      //we couldn't write a getter method for something appearing in a different class
   }
   	
	public double calculateSalePrice(double percent)
   {
      double result = percent/100 * getPrice();
      return result;
   }

}