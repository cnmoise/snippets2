//Author: Claudiu Moise || Homework 4 || Problem 2
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TESTPOINT.java program

public class MyPoint
{
	private int x;//instance variables
	private int y;

	public MyPoint() //no-arg cst //REM: constructors don't have ; at the end
	{
   	this.x = 0;
   	this.y = 0;
	}
	
   public MyPoint(int x, int y) //REM: constructors don't have ; at the end
	{
   	this.x = x;
   	this.y = y;
	}

   public int getX()//getter method, with int return type
   {
      return this.x;
   }
   
   public int getY()
   {
      return this.y;
   }
   
   public void setXY(int x, int y)
   {
      this.x = x;
   	this.y = y;
   }
   
   public String toString()
   {
       return String.format("(" + this.x + "," + this.y + ")");
   }//why did i need to use .format
   
   public double distance(int x, int y)
   {
      return Math.sqrt(Math.pow(this.x - x, 2) + (Math.pow(this.y - y, 2)));//REM insides of .pow dont have ()
      //could be broken down into multiple steps
   }
   
   public double distance(MyPoint pt)//Rem: spell your objects correctly
   {
       return Math.sqrt(Math.pow(pt.getX() - this.x, 2) + (Math.pow(pt.getY() - this.y, 2)));//Rem .methods() go after the object, and have () at the end of them
       //switch getX and x, use the this keywords
   }
   
}