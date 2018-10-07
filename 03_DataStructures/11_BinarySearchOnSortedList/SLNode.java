public class SLNode
{
   private int m_value;
   private SLNode m_link;
   
   public SLNode(int value) implements Serializable//adds extra functions
   {
      m_value = value;
      m_link = null;
   }

   public void setLink(SLNode link)
   {
      m_link = link;
   }
   
   public SLNode getLink()
   {
      return m_link;
   }
   
   public getInfo()
   {
      return m_value;
   }
}