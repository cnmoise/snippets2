// The array based implementation for the NumberList ADT

public class ArrayNumberList implements NumberList
{
    // instance variables
    private int[] m_array;
    private int m_index = 0;
    
    // constructor
    public ArrayNumberList(int cap)
    {
        m_array = new int[cap];
    }
    
    // insert a number into the list
    public void insert(int v)
    {
        m_array[m_index] = v;
        m_index++;
    }
    
    // check whether the list is full
    public boolean isFull()
    {
        if (m_index == m_array.length)
            return true;
        else
            return false;
    }
    
    // check whether a given number exists in the list
    public boolean contains(int v)
    {
        for (int i = 0; i < m_index; i++)
            if (m_array[i] == v)
                return true;
        
        return false;
    }
    
    // return a string representation of the list
    @Override
    public String toString()
    {
        String listContent = "The content of the list is: ";
        
        for (int i = 0; i < m_index; i++)
            listContent += m_array[i] + " ";
        
        return listContent;
    }
}
