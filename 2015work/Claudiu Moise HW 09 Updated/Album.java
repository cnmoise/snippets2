//Author: Claudiu Moise || Homework 9 || Problem 1
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//
//This is an exercise in implementing interfaces and using abstract classes

public class Album extends Item implements Sellable, Transportable
//When implementing multiple interface, the above is propper syntax
{
   private Photograph[] photos;//initialized object array
   private double weight;
   
   public Album(int id, String name, double weight, Photograph[] p)
   {
      super(id, name);//superconstructor, goes to item class
      this.weight = weight;
      this.photos = p;
   }
   
   public double getWeight()
   {
     return this.weight;
   }
   //The rubric neither banned the use of this nor did it ask us to make this
   //So I just put it in bc its good practice
   
   //Any abstract methods in Item and Sellable, must be implemented/overwritten here
   //Item
   public String getDescription()
   {
      String ret = getWeight() + " lbs \n";
      for (int i = 0; i < this.photos.length; i++){
         ret += photos[i].getName() + " " + photos[i].getDescription() + "\n";
          //no need to use super.method() 
          //bc were performing the method calls on Photograph objects
          //they get the methods from the class all on their own
         }//prints out each photos name and description
      return ret;
   }
	
	public void printDetails()
   {
      System.out.println("ID: " + super.getId());//remember parentheses for methods
      System.out.println("Name: " + super.getName());
      System.out.println("Price: " + getPrice());
      System.out.println("Description: \n" + getDescription());
   }
   
   //Sellable
   public double getPrice()
	{
      double retP = 0.0;
      for (int i = 0; i < this.photos.length; i++){
         retP += photos[i].getPrice();//no need to use super, again, the method knows where to reffer to
         }
      
      if(getWeight() > 10)
         retP += 5;
      else
         retP += 2.5;//blindspot for a package with a weight that is exactly 10
      
      return retP;
   }
   	
	public double calculateSalePrice(double percent)
   {
      double result = percent/100 * getPrice();
      return result;
   }
    
   //Transportable
   public boolean isFragile()
	{
      return true;
   }
   
	public boolean isHazardous()
	{
      return false;
   }
   	
	public double calculateShippingCost(int units)//the int multiplies the order
   {
      double ship = 5.00;
      
      if(this.isFragile() == true)//we still use .this even for these simple booleans
         ship += 5.00;
      if(this.isHazardous() == true)
         ship += 5.00;
         
      ship *= units;
      
      return ship;
   }


}