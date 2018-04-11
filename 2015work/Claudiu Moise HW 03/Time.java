//Author: Claudiu Moise || Homework 3 || Problem 2
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TESTTIME.java program


public class Time
{
		private int hour, min, sec;
		//REM: private, public, protected are called ACCESS MODIFIERS
      //Above is an example of
      //Instance Var: var is declared outside methods, but is still declared
      //within the class Time //Instance variables belong to objects
      
      
      public Time()//this is a no-arg constructor
      {
         hour = 0;//use .this? for accuracy
         min = 0;
         sec = 0;
         //explicitly defaults all vars to 0
         //only triggers if user creates by writing Time t1 = new Time();
      }
      //REM: Constructor should be the same as the class name
      
      public Time(int hour, int min, int sec)//REM: These are local, NOT instance vars //should have used h,m,s
         {
            this.hour = hour;//this reffers to the current instance of the object
            this.min = min;
            this.sec = sec;
            //only triggers if user creates by writing Time t2 = new Time(3, 27, 55);
         }
      //REM: You can have multiple constructors for multiple situations //OVERLOADED constructors
      //REM: SPECIFIC ORDER
         // this.hour = hour; assigns values correctly
         // hour = this.hour; does not
      
      //Question: Why does the order of the above opperation matter?
      
         public int getTotalSeconds()//this is a class method, with no parameters
         {
            int total;
            total = ((hour * 60)* 60) + (min * 60) + sec;
            return total;
         }
         
         public int getTotalMinutes()
         {
            int total;
            total = (hour * 60) + min + (sec/60);
            //last part is there in case user decides to input something ridiculous like
            //255 seconds, the program will divide it
            return total;
         }

}