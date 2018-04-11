//Author: Claudiu Moise || Homework 5 || Problem 1
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TESTPOINT.java program

public class Item//Item is aggregated by Grocery List
{
	private String name;
   private double price;
   
   public Item(String a, double b)
   {
      this.name = a;
      this.price = b;
   }
   
   public void display()
   {
      System.out.println(this.name + " " + this.price);
   }
}