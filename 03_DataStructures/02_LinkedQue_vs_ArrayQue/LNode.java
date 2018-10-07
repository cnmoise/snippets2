//This class represents a node in a Linked List
//09.06.16
   
   public class LNode
   {
      private int m_value;
      private LNode m_link;
      
      //constructor, typically when we make a node, we want to initialize it w a value
      public LNode(int value)
      {
         m_value = value;
         m_link = null;//created without link to another node
      }
      
      public void setLink(LNode link)
      {
         m_link = link;
      }
      
      //getters
      public LNode getLink()
      {
         return m_link;
      }
      
      public int getInfo()
      {
         return m_value;
      }
   }