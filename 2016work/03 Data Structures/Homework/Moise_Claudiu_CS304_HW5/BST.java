// The BST class that represents binary search trees
// Claudiu Moise

import java.util.*;
//We can either create a custom stack or use the generic java Stack
import java.util.Stack;

public class BST 
{
    // instance variables
    private BSTNode m_root;
    private int m_size;
    
    // constructor, creates a binary search tree
    public BST()
    {
        m_root = null;
        m_size = 0;
    }
    
    //Target // add a value into the tree //REQ: implement this method using a non-recursive solution

    public void add(int v)
    {
        //We start by assigning the first node we make to root
        if(m_root == null)
        {
            m_root = new BSTNode(v);
            m_size++;//no automatic way of est. size, so this is the best we got. 
        }
        
        BSTNode curr = m_root;//creates a copy for traversal
        //code should only run a loop if needed
        //Theory: to do w/o breaks we have a boolean var, which we can at any time set to be false 
        while(true)
        {
           //we sort v into its respective branch of the tree
           if(v < curr.getInfo())
           {
               //if the node we are currently looking at has a left child, 
               //we go to the left child
               if(curr.getLeft() != null)
               {
                  curr = curr.getLeft(); 
               }
               //means there is no child; becomes the case where we insert a node
               else
               {
                  BSTNode node = new BSTNode(v);
                  curr.setLeft(node);
                  m_size++;
                  break;
               }
           }//we repeat the process for the right tree
           else if(v > curr.getInfo())
           {
               if(curr.getRight() != null)
               {
                  curr = curr.getRight();
                  
               }
               else
               {
                  BSTNode node = new BSTNode(v);
                  curr.setRight(node);
                  m_size++;
                  break;
               }
           }
           //if it doesn't go to a null left or right node, it probably already exists
           //so we go back up to the top of the list for new traversals
           else 
           {
               curr = m_root;
               break;
           }
        }
    }
    
    //Target // print the tree content using in-order traveral //REQ: implement this method using a non-recursive solution
    public void inOrder()
    {   
        BSTNode inCurr = m_root;//copy for traversal
        BSTNode inRoot = m_root;
        
        //If the tree is empty
        if(inCurr == null)
            return;
            //Why does this work? 
        
        Stack<BSTNode> stack = new Stack<BSTNode>();

        while(true)
        {
            //if the node we are currently looking at is not empty, we need to keep traversing
            //
            if(inCurr != null)
            {
               stack.push(inCurr);
               inCurr = inCurr.getLeft();            
            }
            else
            {
              if(stack.size() <= 0)
                  break;
                  //really its the same as if we set the while loop up top
                  //to say while(stack.size() > 0)
              inCurr = stack.pop();//set the current node to the top of the stack
              //Is the value assigned going to be the popped off value? I think so
              System.out.print(inCurr.getInfo()+ " ");
              
              inCurr = inCurr.getRight();
              //Just like an in-Order Traversal
              //Not sure how this works using the stack.
              //PRAC: trace this in combo with a stack
              
            }
          }
     }
    
    
    // get the size of the tree
    public int size()
    {
        return m_size;
    }
    
    // empty the tree
    public void clear()
    {
        m_root = null;
        m_size = 0;
    }
}
