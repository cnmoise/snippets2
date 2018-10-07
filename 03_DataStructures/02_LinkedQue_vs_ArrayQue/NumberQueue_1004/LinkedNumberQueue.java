// The linked list based implementation for the NumberQueue ADT
// Xiwei Wang

public class LinkedNumberQueue implements NumberQueue
{
    // instance variables
    private LNode m_front;
    private LNode m_rear;
    private int m_numElements = 0;
    
    // constructor
    public LinkedNumberQueue()
    {
        m_front = m_rear = null;
    }
    
    // check whether the queue is empty
    public boolean isEmpty()
    {
        if (m_front == null)
            return true;
        else
            return false;
    }
    
    // check whether the queue is full
    public boolean isFull()
    {
        return false;
    }
    
    // add an element to the rear of the queue
    public void enqueue(int v)
    {
        // create a new node with the given value
        LNode newNode = new LNode(v);
        
        // handle the empty list case
        if (m_front == null)
            m_front = m_rear = newNode;
        else
        {
            m_rear.setLink(newNode);
            m_rear = newNode;
        }
        
        m_numElements++;
    }
    
    // remove and return the element at the front of the queue
    public int dequeue()
    {
        if (isEmpty())
            throw new RuntimeException("Dequeue attempted on an empty queue");
        else
        {
            int v = m_front.getInfo();
            m_front = m_front.getLink();
            
            if (m_front == null)
                m_rear = null;
            
            m_numElements--;
            return v;
        }        
    }
    
    // return the size of the queue
    public int size()
    {
        return m_numElements;
    }
    
    // return a string representation of the queue
    @Override
    public String toString()
    {
        String queueContent = "The content of the queue is: ";
        
        LNode current = m_front;
        
        while (current != null)
        {
            queueContent += current.getInfo() + " ";
            current = current.getLink();
        }
        
        return queueContent;
    }
}
