

public class LinkedNumberList
{
    // instance variables
    private LNode m_first;
    private int mco;
    
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
        mco++;
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
    
    public int size()
    {
        return mco;
    }
    
    public int findKthElemFromLastNode(int KthIndexFromLast){
      int goal = mco - KthIndexFromLast;
      
      int i = 0;
      LNode current = m_first;
      while(i < goal){
         current = current.getLink();
         i++;
      }
      
            
      return current.getInfo();
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
