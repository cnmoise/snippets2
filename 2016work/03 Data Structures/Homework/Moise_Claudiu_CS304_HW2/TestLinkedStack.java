// Test driver for the LinkedStack and PostFixCalculator classes
// Do not make any changes to this file!
// Xiwei Wang

import java.util.*;
import java.io.*;

public class TestLinkedStack
{
    public static void main(String[] args)
    {
        System.out.println("================ Problem 1 ================");
        TestP1();
        System.out.println("================ End of Problem 1 ================\n\n");
        
        System.out.print("Press any key to test Problem 2...");
        try
        {
            System.in.read();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        System.out.println("================ Problem 2 ================");
        TestP2();
        System.out.println("================ End of Problem 2 ================");
    }
    
    public static void TestP1()
    {
        LinkedStack myStack = new LinkedStack();      
        int numPassedTests = 0;
        int numTotalTests = 0;
        String testResult;
        
        // Test 1 //have we created a stack?
        numTotalTests++;//at the begining of each new test, we reset everything and say what test were on
        int iReturn = -1;
        testResult = "[Failed]";
        String eMsg = "N/A";
        try
        {
            iReturn = myStack.size();
            
            if (iReturn == 0)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": size() ==> " + testResult + "\n Expected: 0" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 2
        numTotalTests++;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            iReturn = myStack.pop();
        }
        catch (RuntimeException e)
        {
            if (!(e instanceof NullPointerException))
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
            
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": pop() ==> " + testResult + "\n Expected: a RuntimeException");
        System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 3 //Can we put an obj on the stack?
        numTotalTests++;
        boolean bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            myStack.push(10);        
            bReturn = myStack.isEmpty();

            if (bReturn == false)
            {
                numPassedTests++;
                testResult = "[Passed]";
            } 
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": push(10) and then isEmpty() ==> " + testResult + "\n Expected: false");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
       
        // Test 4 // Does the toString Method work?
        numTotalTests++;
        String sReturn = myStack.toString();

        if (sReturn.equals("10 "))
        {
            numPassedTests++;
            testResult = "[Passed]";
        }
        else
            testResult = "[Failed]";   
        
        System.out.println("Test " + numTotalTests + ": toString() ==> " + testResult + "\n Expected (from top to bottom): 10 ");
        System.out.println(" Yours (from top to bottom): " + sReturn + "\n");
        
        // Test 5 //is the topmost element 10? (the one we first pushed to the stack
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";  
        try
        {
            iReturn = myStack.top();

            if (iReturn == 10)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }  
        }        
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        } 
        
        System.out.println("Test " + numTotalTests + ": top() ==> " + testResult + "\n Expected: 10");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");      
        
        // Test 6 //we push a new node & then test to see if the string rep is the same
        numTotalTests++;
        sReturn = "";
        testResult = "[Failed]"; 
        eMsg = "N/A";
        try
        {
            myStack.push(20);        
            sReturn = myStack.toString();//passes out a string for us to compare

            if (sReturn.equals("20 10 "))
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": push(20) and then toString() ==> " + testResult + "\n Expected (from top to bottom): 20 10 ");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours (from top to bottom): " + sReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 7 //checks if the new top of our stack is 20
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            iReturn = myStack.top();

            if (iReturn == 20)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        } 
        
        System.out.println("Test " + numTotalTests + ": top() ==> " + testResult + "\n Expected: 20");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");   
        
        // Test 8
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {        
            iReturn = myStack.pop();//pop a value of the stack

            if (iReturn == 20)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        } 
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": pop() ==> " + testResult + "\n Expected: 20");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");     
        
        // Test 9 // checks if after we've popped the #, that the stack looks right
        numTotalTests++;
        sReturn = myStack.toString();

        if (sReturn.equals("10 "))
        {
            numPassedTests++;
            testResult = "[Passed]";
        }
        else
            testResult = "[Failed]";   
        
        System.out.println("Test " + numTotalTests + ": toString() ==> " + testResult + "\n Expected (from top to bottom): 10 ");
        System.out.println(" Yours (from top to bottom): " + sReturn + "\n"); 
        
        // Test 10 // we try and push several more vals & if the stack looks right
        numTotalTests++;
        sReturn = "";
        testResult = "[Failed]"; 
        eMsg = "N/A";        
        try
        {
            myStack.push(30); 
            myStack.push(40);
            myStack.push(50);
            sReturn = myStack.toString();

            if (sReturn.equals("50 40 30 10 "))
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": push(30), push(40), push(50), and then toString() ==> " + testResult + "\n Expected (from top to bottom): 50 40 30 10 ");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours (from top to bottom): " + sReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");

        // Test 11 //checks to see how many elements we have on the stack
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            iReturn = myStack.size();

            if (iReturn == 4)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": size() ==> " + testResult + "\n Expected: 4" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n"); 
        
        // Test 12 //pops and immediately checks what the new val at the top is
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            iReturn = myStack.pop();
            iReturn = myStack.top();

            if (iReturn == 40)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }   
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": pop() and then top() ==> " + testResult + "\n Expected: 40");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 13 // pops an element and checks the size of it
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            iReturn = myStack.pop();
            iReturn = myStack.size();

            if (iReturn == 2)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }   
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": pop() and then size() ==> " + testResult + "\n Expected: 2");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n"); 
        
        // Test 14 // pushes a new element & checks if the stack looks right
        numTotalTests++;
        sReturn = "";
        testResult = "[Failed]"; 
        eMsg = "N/A";
        try
        {
            myStack.push(20);        
            sReturn = myStack.toString();

            if (sReturn.equals("20 30 10 "))
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }   
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": push(20) and then toString() ==> " + testResult + "\n Expected (from top to bottom): 20 30 10 ");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours (from top to bottom): " + sReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");

        // Test 15
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            iReturn = myStack.size();

            if (iReturn == 3)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        } 
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": size() ==> " + testResult + "\n Expected: 3" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 16
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            iReturn = myStack.pop();
            iReturn = myStack.pop();
            iReturn = myStack.top(); // should be back to orig 1st elem

            if (iReturn == 10)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }   
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": pop() twice and then top() ==> " + testResult + "\n Expected: 10");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n"); 
        
        // Test 17
        numTotalTests++;
        sReturn = "";
        testResult = "[Failed]"; 
        eMsg = "N/A";
        try
        {
            sReturn = myStack.toString();

            if (sReturn.equals("10 "))
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }   
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": toString() ==> " + testResult + "\n Expected (from top to bottom): 10 ");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours (from top to bottom): " + sReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n"); 
        
        // Test 18
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            iReturn = myStack.pop();
            bReturn = myStack.isEmpty();

            if (bReturn == true)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }   
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": pop() and then isEmpty() ==> " + testResult + "\n Expected: true");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n"); 
        
        // Test 19
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            iReturn = myStack.size();

            if (iReturn == 0)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        } 
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": size() ==> " + testResult + "\n Expected: 0" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n"); 
        
        // Test 20
        numTotalTests++;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            iReturn = myStack.pop();
        }
        catch (RuntimeException e)
        {
            if (!(e instanceof NullPointerException))
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
            
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": pop() ==> " + testResult + "\n Expected: a RuntimeException");
        System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 21
        numTotalTests++;
        sReturn = "";
        testResult = "[Failed]"; 
        eMsg = "N/A";
        try
        {
            myStack.push(70);       
            sReturn = myStack.toString();

            if (sReturn.equals("70 "))
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": push(70) and then toString() ==> " + testResult + "\n Expected (from top to bottom): 70 ");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours (from top to bottom): " + sReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 22
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";  
        try
        {
            iReturn = myStack.top();

            if (iReturn == 70)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }  
        }        
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        } 
        
        System.out.println("Test " + numTotalTests + ": top() ==> " + testResult + "\n Expected: 70");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");   
        
        // Test 23
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            iReturn = myStack.pop();
            iReturn = myStack.size();

            if (iReturn == 0)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }   
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": pop() and then size() ==> " + testResult + "\n Expected: 0");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        System.out.println("Total test cases: " + numTotalTests + "\nCorrect: " + numPassedTests + "\nWrong: " + (numTotalTests - numPassedTests));
    }
    
    //The test for Problem 2
    public static void TestP2()
    {       
        try
        {
            //this jumble sets up the input for our method
            //results and exception are used by teach. to compare what we get to the actual answers
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("testExpressions.dat"));
            PostFixCalculator myCalculator = new PostFixCalculator();            
            ArrayList<Integer> results = new ArrayList<Integer>();
            ArrayList<String> expressions = new ArrayList<String>();
            ArrayList<String> exceptions = new ArrayList<String>();
            results = (ArrayList<Integer>)in.readObject();
            expressions = (ArrayList<String>)in.readObject(); 
            exceptions = (ArrayList<String>)in.readObject();            
            
            int r;
            String eMsg;            
            String postFixExp;
            int numPassedTests = 0;
            int numTotalTests = 0;            
            
            //we get passed in an array list
            for (int i = 0; i < expressions.size(); i++)
            {
                numTotalTests++;
                //somehow gets the things we will be operating on from the above jumble of things
                postFixExp = expressions.get(i);
                //sets postfix? what does that actually mean?
                myCalculator.setPostfix(postFixExp);

                r = -1;
                eMsg = "N/A";                    
                try
                {
                    r = myCalculator.calculate();                    
                }
                catch (RuntimeException e)
                {
                    eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
                }

                System.out.print("Test " + numTotalTests + ": (" + postFixExp + ") ==> ");
                
                if (exceptions.get(i).equals("N/A"))
                {
                    if (eMsg.equals("N/A") && r == results.get(i))
                    {
                       System.out.println("[Passed]");
                       numPassedTests++;
                    }
                    else
                       System.out.println("[Failed]"); 
                    
                    System.out.println(" Expected: " + results.get(i));
                    if (eMsg.equals("N/A"))
                        System.out.println(" Yours: " + r + "\n");
                    else
                        System.out.println(" Yours: " + eMsg + "\n");
                }
                else
                {
                    if (exceptions.get(i).equalsIgnoreCase(eMsg))
                    {
                       System.out.println("[Passed]");
                       numPassedTests++;
                    }
                    else
                    {
                        if (eMsg.equals("N/A"))
                            System.out.println("[Failed]");
                        else
                            System.out.println("[Mismatched exception message]");
                    } 
                    
                    System.out.println(" Expected: " + exceptions.get(i));
                    if (eMsg.equals("N/A"))
                        System.out.println(" Yours: " + r + "\n");
                    else
                        System.out.println(" Yours: " + eMsg + "\n");                    
                }
            }
            
            System.out.println("Total test cases: " + numTotalTests + "\nCorrect: " + numPassedTests + "\nWrong: " + (numTotalTests - numPassedTests));
        }
        catch (Exception e)
        {
           //
           System.out.println("Error occurred: " + e.getMessage());   
        }
    }
}