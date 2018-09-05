//needs to be checked against teacher ver

public class SortedList implements Serializable
{
   //
   private SLNode m_first;
   
   public SortedList()
   {
      m_first = null;
   }
   
   //add a new node into list, keeping it sorted
   public void add(int v)
   {
      SLNode newNode = new SLNode(v);
      
      if (m_first == null)
      {
         m_first = newNode;
         return;
      }
   }
   
      SLNode current = m_first;
      SLNode previous = null;
      
      while(current != null)
      {
         if(current.getInfo() < v)
         {
            previous = current;
            current = current.getLink();//order is important
         }
         else
            break;
      }
      
      if (previous == null)
      {
         newNode.setLink(m_first);
         m_first = newNode;
      }
      else
      {
         newNode.setLink(current);
      }
      
    public boolean remove(int v)
    {
      //previous and current are temporary variables
      //we want to manip the nodes not the reference
      
      SLNode cur = m_first;
      SLNode prev = null;
      
      previous.setLink(current.getLinnk);
      
      //analyze, hows this work?
      while(cur != null)
      {
         //compare given val w val in node
         if(cur.getInfo() < v)
         {
            prev = cur;
            cur = cur.getLink();
         }
         else if (cur.getInfo() == v)
         {
            found = true;
            cur = cur.getLink();
            
            if(prev == null)
               m_first = cur;
            else
               previous.setLink(current);
         }
         else
            return found;   
         
      }
      return found;
    }
    
    public String toString()
    {
      String listContent = "";
      SLNode cur = m_first;
      
      while (current != null)
      {
         listContent += cur.getInfo()+ " ";
         cur = cur.getLink();
      }
      
      return listContent;
    }
}