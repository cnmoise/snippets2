//Claudiu Moise
//

   public class ArrayNumberList implements NumberList
   {
      //instance variables
      private int[] m_array;
      private int m_index = 0;
      
      //methods
      
      //constructor      
      public ArrayNumberList(int cap)
      {
         m_array = new int[cap];
      }
      
      //inserts num into list
      public void insert(int v)
      {
         m_array[m_index] = v;
         m_index++;
      }
      
      //check if list is full
      public boolean isFull()
      {
         if (m_index == m_array.length)
            return true;
         else
            return false;
      }
      
      //checks if a given number exists in the list
      public boolean contains(int v)
      {
         for(int i = 0; i < m_index; i++)//the fact its m_index is important
            {
               if(m_array[i] == v)
                  return true;
            }
         return false;//needs to placed outside of the loop
      }
      
      //return array in string form
      @Override
      public String toString()
      {
         String listContent =  "The content of the list is: ";

         //goes through each element in the array and concatenates it
         for(int i = 0; i < m_index; i++)
         {
            listContent += m_array[i] + " ";
         }
         
         return listContent;
  
      }
   }