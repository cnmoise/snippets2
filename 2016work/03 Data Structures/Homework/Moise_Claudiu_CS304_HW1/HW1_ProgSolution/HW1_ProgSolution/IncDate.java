// The IncDate class
// Do not make changes to anything other than the body of increment() method
// Your name here

public class IncDate extends Date
{
    // copy constructor
    public IncDate(Date o)
    {
        super(o.m_month, o.m_day, o.m_year);
    }
    
    // constructor
    public IncDate(int month, int day, int year)
    {
        super(month, day, year);
    }
    
    public void increment()
    {
        // TODO: implement this method

        m_day++;

        if (m_month == 2) // February
        {
            if ((m_year % 4 == 0 && m_year % 100 != 0) || (m_year % 400 == 0)) // leap year
            {
                if (m_day == 30)
                {
                    m_month = 3;
                    m_day = 1;
                }
            }
            else if (m_day == 29) // non-leap year
            {
                m_month = 3;
                m_day = 1;
            }
        }
        else if (m_month == 4 || m_month == 6 || m_month == 9 || m_month == 11) // 30-day months
        {
            if (m_day == 31)
            {
                m_day = 1;
                m_month++;
            }
        }
        else if (m_day == 32) // 31-day months
        {
            m_day = 1;
            m_month++;
        }

        if (m_month == 13) // the first day of the next year
        {
            m_year++;
            m_month = 1;
        }
    }  
}
