//array based implementation for the NumberStack ADT


public class ArrayNumberStack implements numberStack
{
   //instance vars
   private int[] m_array;
   private int m_index = 0;
   
   //cst
   public ArrayNumberStack(int cap)
   {
      m_array = new int[cap];
   }
   //DUH
   public boolean isEmpty()
   {
      if(m_index == 0)
         return true;
      else
         return false;
   }
    //DUH
   public boolean isFull()
   {
      if (m_index == m_array.length)
         return true;
      else
         return false;   
   }
   
   public int top()
   {
      //need to handle underflow exception
      
      if (isEmpty())
         throw new RuntimeException("Top attempted on an empty stack");
      else
         return m_array[m_index - 1];
   }
   
   //puts a new elem on the Stack
   public void push(int v)
   {
      if(isFull())
         throw new RuntimeException("Push attempted on a full stack");
      else
      {
         m_array[m_index] = v;
         m_index++;
         
      }
   }
   
   //remove and return elem at top of stack
   public int pop()
   {
      int c;
      
      if(isEmpty())
         throw new RuntimeException("Pop attempted on an empty stack");
      else
      {
         c = m_array[m_index - 1]; //REM: We start counting
         m_index--;
         return c;
      }
   }
   
   //ret size of stack
   
   public int size()
   {
      return m_index;//too easy
   }
   
   //print out the stack
   public String toString()
   {
      String stackContent = "The content of the stack is (from top to bot): ";
      
      for(int i = m_index - 1; i >= 0;i--)
      {
         stackContent += m_array[i] + "\n";
      
      }
      
      return stackContent;
   }

}