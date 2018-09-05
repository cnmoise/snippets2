// The PersonNode class that represents person nodes
// Do not make any changes to this file!

public class PersonNode
{
    // instance variables
    private int m_ID;
    private String m_name;
    private PersonNode m_link;

    // constructor
    public PersonNode(int ID, String name)
    {
        m_ID = ID;
        m_name = name;
        m_link = null; 
    }

    // getters and setters
    // 2 sets of getters for the 2 data fields
    public void setID(int ID)
    {
        m_ID = ID;
    }

    public int getID()
    {
        return m_ID;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public void setLink(PersonNode link)
    {
        m_link = link;
    }

    public PersonNode getLink()
    { 
        return m_link;  
    }
}
 
 