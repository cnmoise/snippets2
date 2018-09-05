//Based on NumberList ADT (abstract data type)that we made for the
//number array practice

   public class LinkedNumberList implements NumberList
   {
      //REM: implementation
      //inst vars
      private LNode m_first;//head
      
      public LinkedNumberList()
      {
         m_first = null;
      }
      public void insert(int v)//basically a push method
      {
         //insert at front
         //creates a new node with the value given by int v
         
         /*
         LNode newNode = new LNode(v);
         newNode.setLink(m_first);
         m_first = newNode;
         */
         
         //if we wanted to add nodes at the end
         if (m_first == null)
            m_first = m_last = newNode;//goes from right to left, doing it in pairs //m_last = newNode and then m_first = m_last
         else
            {
               m_last.setLink(newNode);
               m_last = newNode;
            }
      }
      
      //check if full, note that a Linked List can NEVER be full
      public boolean isFull()
      {
         return false;
      }
      
      public boolean contains(int v)
      {
         //WALK THE LIST
         while(current != null)
         {
            if(current.getInfo() == v)
               return true;
            else
               current = current.getLink();
         }
         return false;
      }
      
      //override of the normal method
      public String toString()
      {
         String listContent =  "The content of the list is: ";

         while(current != null)
         {
            listContent += current.getInfo() + " ";
            current = current.getLink();
         }
         
         return listContent;

      }
   }