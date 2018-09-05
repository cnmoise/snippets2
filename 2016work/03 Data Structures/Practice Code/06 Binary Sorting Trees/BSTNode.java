public class BSTNode
{
   private int m_value;
   private BSTNode m_left;
   private BSTNode m_right;
   
   public BSTNode(int val)
   {
      m_value = val;
      m_left = null;
      m_right = null;

   }
   
   public int getInfo()
   {
      return m_value;
   }
   
   public BSTNode getLeft()
   {
      return m_left;
   }
   public BSTNode getRight()
   {
      return m_right;
   }
   
   public void setLeft(BSTNode left)
   {
      m_left = left;
   }
   
   public void setRight(BSTNode right)
   {
      m_right = right;
   }
}