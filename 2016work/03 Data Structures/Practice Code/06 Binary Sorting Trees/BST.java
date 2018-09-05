//Binary Search Tree

public class BST{

   private BSTNode m_root;
   private int m_size;
   
   public BST()
   {
      m_root = null;
      m_size = 0;
   }
   
   public void clear()
   {
      m_root = null;
   }
   
   //add a val to the tree
   
   public void add(int v)
   {
      m_root = addRec(v, m_root);   
   
   
   }
   //method call stack approach to vis process?
   
   //recursive helper method
   public BSTNode addRec(int v, BSTNode node)
   {
      if(node == null)
      {
         node = new BSTNode(v);
         m_size++;
      } 
      else if (v < node.getInfo()) //go to the left subtree bc smaller than base  //we have to search
         node.setLeft(addRec(v, node.getLeft()));
      else if (v > node.getInfo()) //go to the right subtree bc larger than base
         node.setRight(addRec(v, node.getRight()));
      else //the value already exists in the tree
         System.out.println("Value " + v + " already exists in tree");
         
      return node;
      
   }
   
   //null means a leaf node
   
   //only one who has access to s_root
   public int size()
   {
      return sizeIter(s_root);//retype to change usage
      
   }
   //recursive helper method
   public int sizeRec(BSTNode node){
      if(node == null)
         return 0;
      else
         return sizeRec(node.getLeft())+ sizeRec(node.getRight()) +1;//makes sense
         
   }
   public int sizeIter(BSTNode node)
   {
      int numNodes = 0;
      
      if (node != null)
      {
         Stack<BSTNode> = myStack new Stack<BSTNode>();//<> denotes type of stack
         myStack.push(node);
         
         while(!myStack.isEmpty())
         {
            BSTNode current = myStack.peek();//same as top method
            myStack.pop();
            numNodes++;
            
            if(current.getLeft() != null)
               myStack.push(node.getLeft());
               
            if(current.getRight() != null)
               myStack.push(node.getRight());
         }
      }
      return numNodes;
   }
   //in-order trav
   public void inOrder()
   {
      
         inOrderRec(m_root)
         System.out.println();
      
   }
   
   public void inOrderRec(BSTNode node){
      if (node != null)
      {
         inOrder rec
      }
   }

   public boolean contains()
   
   //need to find if it exist before deletion
   //have to make sure that a bst is still sorted after we remove something
   //Big three: quiz q
   //for leaf nodes: set parents ref to null
   //for a node w one child, set that child as the new reference.
   //for a node w two children, either move the biggest num in the left tree, or the smallest num in the right tree
   
}