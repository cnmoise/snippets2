//TEACHER COPY
// The linked list based implementation for the NumberList ADT
// Xiwei Wang

public class LinkedNumberList implements NumberList
{
    // instance variables
    private LNode m_first;
    
    // constructor
    public LinkedNumberList()
    {
        m_first = null;
    }
    
    // insert a number into the list
    public void insert(int v)
    {
        // create a new node with the given value
        LNode newNode = new LNode(v);
        
        // insertion at the front
        newNode.setLink(m_first);
        m_first = newNode;
    }
    
    // check whether the list is full
    public boolean isFull()
    {
        return false;
    }
    
    // check whether a given number exists in the list
    public boolean contains(int v)
    {
        LNode current = m_first;
        
        while (current != null)
        {
            if (current.getInfo() == v)
                return true;
            else
                current = current.getLink();
        }
        
        return false;
    }
    
    // return a string representation of the list
    @Override
    public String toString()
    {
        String listContent = "The content of the list is: ";
        LNode current = m_first;
        
        while (current != null)
        {
            listContent += current.getInfo() + " ";
            current = current.getLink();
        }        
        
        return listContent;
    }
}
