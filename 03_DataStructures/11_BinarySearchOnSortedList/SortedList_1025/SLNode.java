// The SLNode class that represents nodes
// Xiwei Wang

import java.io.*;   // Serializable interface

public class SLNode implements Serializable
{
    // instance variables
    private int m_value;
    private SLNode m_link;
    
    // constructor
    public SLNode(int value)
    {
        m_value = value;
        m_link = null;
    }
    
    // getters and setters
    public void setLink(SLNode link)
    {
        m_link = link;
    }
    
    public SLNode getLink()
    {
        return m_link;
    }
    
    public int getInfo()
    {
        return m_value;
    }
}
