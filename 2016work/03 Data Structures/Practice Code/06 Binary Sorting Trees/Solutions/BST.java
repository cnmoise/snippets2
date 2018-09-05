// The BST class that represents binary search trees
// Xiwei Wang

import java.util.*;

public class BST
{
    // instance variables
    private BSTNode m_root;
    private int m_size;
    
    // constructor
    public BST()
    {
        m_root = null;
        m_size = 0;
    }
    
    // empty the tree
    public void clear()
    {
        m_root = null;
    }
    
    // add a value into the tree
    public void add(int v)
    {
        m_root = addRec(v, m_root);
    }
    
    // recursive helper method for add
    public BSTNode addRec(int v, BSTNode node)
    {
        if (node == null)
        {
            node = new BSTNode(v);
            m_size++;
        }
        else if (v < node.getInfo())    // if the value is less than the current node,
                                        // then go to the left subtree
            node.setLeft(addRec(v, node.getLeft()));
        else if (v > node.getInfo())    // if the value is greater than the current node,
                                        // then go to the right subtree
            node.setRight(addRec(v, node.getRight()));
        else    // if the value is equal to the current node, then it means that
                // the value aready exists in the tree
            System.out.println("Value " + v + " already exists in the tree.");
        
        return node;        
    }
    
    // get the size of the tree
    public int size()
    {
        //return sizeRec(m_root);
        return sizeIter(m_root);
    }
    
    // recursive helper method for size
    public int sizeRec(BSTNode node)
    {
        if (node == null)
            return 0;
        else
            return sizeRec(node.getLeft()) + sizeRec(node.getRight()) + 1;
    }
    
    // iterative helper method for size
    public int sizeIter(BSTNode node)
    {
        int numNodes = 0;
        
        if (node != null)
        {
            Stack<BSTNode> myStack = new Stack<BSTNode>();
            myStack.push(node);
            
            while (!myStack.isEmpty())
            {
                BSTNode current = myStack.peek(); // set current to the top of the stack
                myStack.pop();
                numNodes++;
                
                if (current.getLeft() != null)
                    myStack.push(current.getLeft());
                
                if (current.getRight() != null)
                    myStack.push(current.getRight());            
            }
        }
        
        return numNodes;
    }
    
    // print the tree content using in-order traversal
    public void inOrder()
    {
        inOrderRec(m_root);
        System.out.println();
    }
    
    // recursive helper method for inOrder
    public void inOrderRec(BSTNode node)
    {
        if (node != null)
        {
            inOrderRec(node.getLeft());
            System.out.print(node.getInfo() + " ");
            inOrderRec(node.getRight());
        }
    }
    
    // check whether a given number exists in the tree
    public boolean contains(int v)
    {
        return containsRec(v, m_root);
    }
    
    // recursive helper method for contains
    public boolean containsRec(int v, BSTNode node)
    {
        if (node == null)   // the tree is empty
            return false;
        
        if (v < node.getInfo())
            return containsRec(v, node.getLeft());
        else if (v > node.getInfo())
            return containsRec(v, node.getRight());
        else
            return true;
    }
}
