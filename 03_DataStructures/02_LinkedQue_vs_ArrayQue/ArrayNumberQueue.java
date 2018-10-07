public class ArrayNumberQueue implements NumberQueue
{
   //inst vars
   private int[] m_array;
   private int m_front = 0;
   private int m_rear = -1;//? why
   private int m_numElements = 0;
   
   //cst
   public ArrayNumberQueue(int cap)
   {
      m_array = new int[cap];//we create the array we are going to fuck with
   }
   
   //
   public boolean isEmpty()
   {
      if (m_numElements == 0)
         return true;
      else
         return false;
      
   }
    
   public boolean isFull()
   {
      if (m_numElements == m_array.length)
         return true;
      else
         return false;
      
   }
   
   public void enque(int v)
   {
      if (isFull())
         throw new RuntimeExpetion("Enque attempted on a full queue");
      else
      {
         m_rear = (m_rear+1) % m_array.length; //why so complex?//because we're doing a circular queue
         m_array[m_rear] = v;
         m_numElements++;
      }
   }
   
   public int dequeue() //if someone called me a young blood I'd be fucking pissed
   {
      if (isEmpty())
         throw new RuntimeException("Shit's empty like your bank account nigga");
      else
      {
        
        int v = m_array[m_front];
        m_array = (m_front+1) % m_array.length; //how does the arithmetic work to do this 
        m_numElements--;
        return v;
      }
        
   }
   
   public int size()
   {
      return m_numElements;
   }
   
   public String toString()
   {
      String queueContent = "The content of the queue is: ";
      if (!isEmpty())
      {
      //need to do diff things if what? if rear is in front of front
         if (m_front <= m_rear)//if your front is smaller than your rear <- see pic
         {
            for (int i = m_front; i <= m_rear; i++)
               queueContent += m_array[i] + " ";
         }
         else
         {
            for (int i = m_front; i <= m_array.length; i++)
               queueContent += m_array[i] + " ";
            for (int i = 0; i <= m_rear; i++)
               queueContent += m_array[i] + " ";

         }
      }
      
      return queueContent;
   }


}