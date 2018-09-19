//array based implementation for the NumberStack ADT


public class TrippleDipperStack
{
   //instance vars
   private int[][] mArray;
   private int mIndex0 = 0;
   private int mIndex1 = 0;
   private int mIndex2 = 0;
   
   //cst
   public TrippleDipperStack(int cap)
   {
      m_array = new int[2][cap];
   }
   //DUH
   public boolean isZeroEmpty()
   {
      if(mIndex0 == 0)
         return true;
      else
         return false;
   }
    //DUH
   public boolean isFull()
   {
      if (mIndex0 == mArray.length)
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
         return mArray[m_index - 1];
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