//A demonstration for using interfaces

public interface FourLeggedObject
{      
   public static final int LEGS = 4;//aka a constant
   //In an interface, all data fields start with: public static final
   
   public abstract boolean isLivingThing();
   public abstract void printMovement();
   //In an interface, all methods start with: public abstract

}