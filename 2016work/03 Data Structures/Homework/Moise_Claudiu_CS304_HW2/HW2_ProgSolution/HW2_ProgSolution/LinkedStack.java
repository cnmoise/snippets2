// The LinkedStack class
// Your name here

public class LinkedStack
{
    // instance variable
    private LNode m_top;

    // check whether the stack is empty
    public boolean isEmpty()
    {       
        if (m_top == null)
            return true;
        else
            return false;
    }

    // return the element at the top of the stack
    public int top()
    { 
        if (isEmpty())
            throw new RuntimeException("Top attempted on an empty stack");
        else
            return m_top.getInfo();
    }

    // push a value onto the stack
    public void push(int v)
    {
        LNode newNode = new LNode(v);
        newNode.setLink(m_top);
        m_top = newNode;
    }

    // remove and return the value at the top of the stack
    public int pop()
    { 
        int value;

        if (isEmpty())
            throw new RuntimeException("Pop attempted on an empty stack");
        else
        {
            value = m_top.getInfo();
            m_top = m_top.getLink();
            return value;
        } 
    }

    // return the size of the stack
    public int size()
    {       
        int numElements = 0;
        LNode current = m_top;

        while (current != null)
        {
            numElements++;
            current = current.getLink();
        }

        return numElements;
    }

    // return a string representation of the stack
    public String toString()
    {
        String stackContent = "";
        LNode current = m_top;

        while (current != null)
        {
            stackContent += current.getInfo() + " ";
            current = current.getLink();
        }

        return stackContent;    
    }
}