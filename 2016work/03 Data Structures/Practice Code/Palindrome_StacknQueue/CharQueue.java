// The CharQueue class that implements a queue of characters
// Xiwei Wang

public class CharQueue
{
    // instance variables
    private char[] m_array;
    private int m_front = 0;
    private int m_rear = -1;
    private int m_numElements = 0;
    
    // constructor
    public CharQueue(int cap)
    {
        m_array = new char[cap];
    }

    // check whether the queue is empty
    public boolean isEmpty()
    {
        if (m_numElements == 0)
            return true;
        else
            return false;
    }
    
    // add an element to the rear of the queue
    public void enqueue(char c)
    {
        m_rear = (m_rear + 1) % m_array.length;
        m_array[m_rear] = c;
        m_numElements++;
    }
    
    // remove and return the element at the front of the queue
    public char dequeue()
    {
        char c = m_array[m_front];
        m_front = (m_front + 1) % m_array.length;
        m_numElements--;

        return c;
    }
}
