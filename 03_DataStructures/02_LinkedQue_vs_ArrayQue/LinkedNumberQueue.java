//the linked list based implementation of num queue
//Claude

public class LinkedNumberQueue implements NumberQueue
{
   private LNode m_front;
   private LNode m_rear;
   private int m_numElements = 0;
   
   public LinkedNumberQueue()
   {
      m_front = m_rear = null;
   }
   
   public boolean isEmpty()
   {
      if (m_front == null)
         return true;
      else
         return false;
   }
   
   public boolean isFull()
   {
      return false;
   }
   
   public void enqueue(int v)
   {
      //make a new node w given val
      LNode newNode = new LNode(v);
      
      //empty list case handling
      if (m_front == null)
         m_front = m_rear = newNode;
      else
      {
         m_rear.setLink(newNode);
         m_rear = newNode;
      }
      
      m_numElements++;
   }
   
   public int dequeue()//m_front = getLink will set node to the previous node in the series
   {
      if (isEmpty())
         throw new RuntimeException("Fuck its empty")
      else
      {
         int v = m_front 
      }
   }
   
   //size
   public int size()
   {
      return m_numElements;
   }
   
   //overidden
   public String toString()
   {
      String queueContent = "The content of the queue is: ";
      
      LNode current = m_front;
      
      while (current != null)//most important part
      {
         queueContent += current.getInfo() + " ";
         current = current.getLink();
      
      }
      
      return queueContent;
   }
}