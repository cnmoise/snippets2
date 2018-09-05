// The CharStack class that implements a stack of characters
// Xiwei Wang

public class CharStack
{
    // instance variables
    private char[] m_array;
    private int m_index = 0;
    
    // constructor
    public CharStack(int cap)
    {
        m_array = new char[cap];
    }

    // check whether the stack is empty
    public boolean isEmpty()
    {
        if (m_index == 0)
            return true;
        else
            return false;
    }

    // return the element at the top of the stack
    public char top()
    {
        if (isEmpty())
            throw new RuntimeException("Top attempted on an empty stack");
        else
            return m_array[m_index - 1];
    }
            
    // push a character onto the stack
    public void push(char c)
    {
        m_array[m_index] = c;
        m_index++;
    }
    
    // remove and return the element at the top of the stack
    //we didn't actually edit the array, we just changed the index
    public char pop()
    { 
        char c = m_array[m_index - 1];
        m_index--;
        
        return c;
    }

    // return the size of the stack
    public int size()
    {       
        return m_index;
    }
}
