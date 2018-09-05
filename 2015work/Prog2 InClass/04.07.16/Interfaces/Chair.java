//definind all our abstracts methods

public class Chair implements FourLeggedObject//this is a concrete class
{
   
   public boolean isLivingThing()
   {
      return false;
   }
   public void printMovement()
   {
      System.out.println("I do not move unless someone pushes me.");
   }
}