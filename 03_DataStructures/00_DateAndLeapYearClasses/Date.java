// The Date class that represents dates
// Do not make any changes to this file!
// Xiwei Wang

import java.io.*;

public class Date implements Serializable
{
    // instance variables
    protected int m_year;
    protected int m_month;
    protected int m_day;
    
    // copy constructor
    public Date(Date o)
    {
        m_year = o.m_year;
        m_month = o.m_month;
        m_day = o.m_day;
    }
    
    // constructor
    public Date(int month, int day, int year)
    {
        m_year = year;
        m_month = month;
        m_day = day;
    }
    
    // observers
    public int getYear()
    {
        return m_year;
    }
    
    public int getMonth()
    {
        return m_month;
    }
    
    public int getDay()
    {
        return m_day;
    }
    
    // return the Lilian day number of this date
    public int lilian()
    {
        final int subDays = 578100; // number of calculated days from 1/1/0 to 10/14/1582
        int numDays = 0;
        
        // add days in years
        numDays = m_year * 365;
        
        // add days in the months
        if (m_month <= 2)
            numDays += (m_month - 1) * 31;
        else
            numDays += ((m_month - 1) * 31) - ((4 * (m_month - 1) + 27) / 10);
        
        // add days in the days
        numDays += m_day;
        
        // take care of leap years
        numDays = numDays + (m_year / 4) - (m_year / 100) + (m_year / 400);
        
        // handle special case of leap year but not yet leap day
        if (m_month < 3)
        {
            if ((m_year % 4) == 0) numDays--;
            if ((m_year % 100) == 0) numDays++;
            if ((m_year % 400) == 0) numDays--;
        }
        
        // subtract extra days up to 10/14/1582
        numDays -= subDays;
        
        return numDays;
    }
    
    // return this date as a String
    // REM: Invoked implicitly when using System.out.println() on object
    public String toString()
    {
        return (m_month + "/" + m_day + "/" + m_year);
    }
}
