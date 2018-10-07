// The SortedList IN CLASS PRACTICE
// Xiwei Wang

import java.io.*;   // Serializable interface

public class SortedList implements Serializable
{
    // instance variable
    private SLNode m_first;
    
    // constructor
    public SortedList()
    {
        m_first = null;
    }
    
    // add a new node into the list, keeping it sorted
    public void add(int v)
    {
        // create a new node with the given value
        SLNode newNode = new SLNode(v);
        
        // handle the empty list case
        if (m_first == null)
        {
            m_first = newNode;
            //return;
        }
        
        SLNode current = m_first;   // set up a temp reference to iterate over the list
        SLNode previous = null;     // set up a reference that allows the access to the previous node
        
        while (current != null)
        {
            // compare the new value with the value of each node
            if (current.getInfo() < v)
            {
                previous = current;
                current = current.getLink();
            }
            else
                break;
        }
        
        if (previous == null)
        {
            newNode.setLink(m_first);
            m_first= newNode;
        }
        else
        {
            newNode.setLink(current);
            previous.setLink(newNode);
        }
    }
    
    // remove a node from the list, keeping it sorted
    public boolean remove(int v)
    {
        SLNode current = m_first;
        SLNode previous = null;
        boolean found = false;
        
        while (current != null)
        {
            // compare the given value with the value of each node
            if (current.getInfo() < v)
            {
                previous = current;
                current = current.getLink();
            }
            else if (current.getInfo() == v)
            {
                found = true;
                current = current.getLink();
                
                if (previous == null)
                    m_first = current;
                else
                    previous.setLink(current);
            }
            else
                return found;
        }
        
        return found;
    }
    
    // return a string representation of the list
    @Override
    public String toString()
    {
        String listContent = "The content of the list is ";
        SLNode current = m_first;
        
        while (current != null)
        {
            listContent += current.getInfo() + " ";
            current = current.getLink();
        }
        
        return listContent;
    }
}
