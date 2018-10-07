// The test driver for the BST class
// Xiwei Wang

import java.util.Scanner;

public class TestBST
{
    public static void main(String[] args)
    {
        BST mytree = new BST();
        Scanner conIn = new Scanner(System.in);
        int value;
        
//        System.out.println("Please enter the number you want to insert (enter -1 to stop)");
//        
//        while (true)
//        {
//            value = conIn.nextInt();
//            
//            if (value != -1)
//                mytree.add(value);
//            else
//                break;
//        }
        mytree.add(10);
        mytree.add(5);
        mytree.add(15);
        mytree.add(3);
        mytree.add(7);
        mytree.add(12);
        mytree.add(16);
        
        System.out.println("The tree has " + mytree.size() + " nodes.");
        System.out.println("The in-order traversal of the tree is ");
        mytree.inOrder();
        System.out.println("mytree.contains(17) returns " + mytree.contains(17));
    }
}
