// The IncDate class
// Do not make changes to anything other than the body of increment() method
// Claudiu Moise

// Note: I added quite a few comments of my own for notetaking
// Please ignore them in your assessment

public class IncDate extends Date
{
    //copy constructor
    public IncDate(Date o)
    {
        super(o.m_month, o.m_day, o.m_year);
    }
    
    //constructor
    public IncDate(int month, int day, int year)
    {
        super(month, day, year);
    }
    
    //only thing I can edit
    //supposed to add a day such that 1/31/16 becomes 2/1/16
    //has no return statement bc we alter the val's of the object itself
    public void increment()
    {
      int mDiv = 0;
      boolean isLeap = false;
      
      //Checks if the year we have is a leap year
      if(m_year % 4 == 0 && m_year % 100 != 0)
      {
         isLeap = true;
      }
      if(m_year % 400 == 0)
      {
         isLeap = true;
      }
      
      //Used to subtract the superfluos thing
      if (m_month == 1 || m_month == 3 || m_month == 5 || m_month == 7 || m_month == 8 || m_month == 10)
      {
         mDiv = 31;
      }
      else if (m_month == 2)
      {
         mDiv = 28;
         
         if(isLeap)
            mDiv = 29;
      }
      
      else if (m_month == 4 || m_month == 6 || m_month == 9 || m_month == 11)
      {
         mDiv = 30;
      }
      //Catches the 12th month            
      else
      {
         mDiv = 31;
      }
      
      //Comparison, checks if we've exceeded the allowed # of days in the particular month
      //use mDiv to add another month to the date
      
      m_day += 1;
      if (m_day - mDiv > 0)
      {
         m_day -= mDiv; 
         m_month++;
      }
      if (m_month - 13 >= 0)
      { 
         m_month = 1;
         m_year++;
      }
      //adds all the days up together
    }  
}
