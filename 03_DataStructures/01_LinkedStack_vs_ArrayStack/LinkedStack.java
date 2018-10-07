// The LinkedStack class
// Claudiu Moise
//

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

    //Target //puts a block onto the stack
    public void push(int v)
    {
        LNode newNode = new LNode(v);
        newNode.setLink(m_top);
        m_top = newNode;
    }

    //Target // remove and return the value at the top of the stack
    //AKA what # is in our node
    public int pop()
    { 
        if (isEmpty())//throws an exception if duh
            throw new RuntimeException("Pop attempted on an empty stack");
        else
            {
            int z = m_top.getInfo(); //we save the value in the topmost element
            m_top = m_top.getLink(); //then delete it by omision
            return z;//will ret val at top of stack
            }
        
    }

    //Target // return the size of the stack
    public int size()
    {       		
        int stackcount = 0;
        LNode current = m_top;//sets current to top of the stack, allowing us to traverse

        //will take off each elem off the stack, and count how many times it did it
        while (current != null)
        {
            stackcount++;
            current = current.getLink();//like a pop method
        }
        
        return stackcount;
    }

    // return a string representation of the stack
    public String toString()
    {
        String stackContent = "";
        LNode current = m_top;//sets current to top of the stack, allowing us to traverse

        while (current != null)//checks if the current element of the stack (the topmost) exists
        //quits the loop if it has popped off all the values
        {
            stackContent += current.getInfo() + " ";
            current = current.getLink();//like a pop method
        }

        return stackContent;
    }
}