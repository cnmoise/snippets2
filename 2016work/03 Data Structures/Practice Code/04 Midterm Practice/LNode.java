//Attempt to write LNode from scratch

public class LNode
{
   //REM: instance variables
   int m_val;
   LNode m_link;
   
   //cst
   public LNode(int val)
   {
      m_val = val;
      m_link = null;
   }
   
   public int getInfo()
   {
      return m_val;
   }
   
   public void setInfo(int val)
   {
      m_val = val;
   }
   
   public LNode getLink()//REM: getLink returns a link
   {
      return m_link;
   }
   
   public void setLink(LNode link)//REM: params need datatypes too
   {
      m_link = link;
   }

}