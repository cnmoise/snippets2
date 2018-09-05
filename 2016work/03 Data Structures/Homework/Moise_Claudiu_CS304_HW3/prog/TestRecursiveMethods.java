// Test driver for the RecursiveMethods class
// Do not make any changes to this file!
// Xiwei Wang

import java.util.Arrays;

public class TestRecursiveMethods
{
    public static void main(String[] args)
    {
        RecursiveMethods myMethods = new RecursiveMethods();
        
        int numPassedTests = 0;
        int numTotalTests = 0;
        String testResult;
        
        // Test 1
        numTotalTests++;
        int iReturn = -1;
        testResult = "[Failed]";
        String eMsg = "N/A";
        try
        {
            int[] myArray = {10};
            iReturn = myMethods.sum(myArray);
            
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
        
        System.out.println("Test " + numTotalTests + ": sum(10) ==> " + testResult + "\n Expected: 10" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 2
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            int[] myArray = {10, 20, 30, 40, 50, 60};
            iReturn = myMethods.sum(myArray);
            
            if (iReturn == 210)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": sum(10, 20, 30, 40, 50, 60) ==> " + testResult + "\n Expected: 210" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");

        // Test 3
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            int[] myArray = {10};
            iReturn = myMethods.largest(myArray);
            
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
        
        System.out.println("Test " + numTotalTests + ": largest(10) ==> " + testResult + "\n Expected: 10" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 4
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            int[] myArray = {10, 20, 30, 40, 50, 60};
            iReturn = myMethods.largest(myArray);
            
            if (iReturn == 60)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": largest(10, 20, 30, 40, 50, 60) ==> " + testResult + "\n Expected: 60" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 5
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            int[] myArray = {70, 20, 30, 40, 50, 10};
            iReturn = myMethods.largest(myArray);
            
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
        
        System.out.println("Test " + numTotalTests + ": largest(70, 20, 30, 40, 50, 10) ==> " + testResult + "\n Expected: 70" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");   
        
        // Test 6
        numTotalTests++;
        iReturn = -1;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            int[] myArray = {70, 20, 100, 40, 50, 10};
            iReturn = myMethods.largest(myArray);
            
            if (iReturn == 100)
            {
                numPassedTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalTests + ": largest(70, 20, 100, 40, 50, 10) ==> " + testResult + "\n Expected: 100" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + iReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 7
        numTotalTests++;
        int start = 0, end = 0;
        int[] myArray = null;
        boolean bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            start = 0;
            end = 6;
            int[] testArray = {1, 2, 3, 4, 5, 6, 7};
            myArray = testArray;
            bReturn = myMethods.isSorted(myArray, start, end);
            
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

        System.out.println("Test " + numTotalTests + ": isSorted(" + Arrays.toString(myArray) + ", " + start + ", " + end +") - " + testResult + "\n Expected: true");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 8
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            start = 0;
            end = 6;
            int[] testArray = {1, 2, 3, 4, 4, 6, 7};            
            myArray = testArray;            
            bReturn = myMethods.isSorted(myArray, start, end);
            
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

        System.out.println("Test " + numTotalTests + ": isSorted(" + Arrays.toString(myArray) + ", " + start + ", " + end +") - " + testResult + "\n Expected: true");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        // Test 9
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            start = 0;
            end = 2;
            int[] testArray = {3, 2, 1, 4, 5, 6, 7};
            myArray = testArray;            
            bReturn = myMethods.isSorted(myArray, start, end);
            
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

        System.out.println("Test " + numTotalTests + ": isSorted(" + Arrays.toString(myArray) + ", " + start + ", " + end +") - " + testResult + "\n Expected: false");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");
        
        
        // Test 10
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            start = 1;
            end = 4;
            int[] testArray = {3, 2, 1, 4, 5, 6, 7};
            myArray = testArray;            
            bReturn = myMethods.isSorted(myArray, start, end);
            
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

        System.out.println("Test " + numTotalTests + ": isSorted(" + Arrays.toString(myArray) + ", " + start + ", " + end +") - " + testResult + "\n Expected: false");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");

        
        // Test 11
        numTotalTests++;
        bReturn = false;
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            start = 2;
            end = 6;
            int[] testArray = {3, 2, 1, 4, 5, 6, 7};
            myArray = testArray;            
            bReturn = myMethods.isSorted(myArray, start, end);
            
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

        System.out.println("Test " + numTotalTests + ": isSorted(" + Arrays.toString(myArray) + ", " + start + ", " + end +") - " + testResult + "\n Expected: true");
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + bReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");        
        
        System.out.println("Total test cases: " + numTotalTests + "\nCorrect: " + numPassedTests + "\nWrong: " + (numTotalTests - numPassedTests) + "\n");
        System.out.println("================ Bonus Question ================");

        int numPassedBonusTests = 0;
        int numTotalBonusTests = 0;
        
        // Test 12
        numTotalBonusTests++;
        String sReturn = "";
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            LNode myNode = null;
            sReturn = traverseList(myMethods.reverseListRec(myNode));
            
            if (sReturn.equals("head->null"))
            {
                numPassedBonusTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalBonusTests + ": reverseListRec(null) ==> " + testResult + "\n Expected: head->null" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + sReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n"); 
        
        // Test 13
        numTotalBonusTests++;
        sReturn = "";
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            LNode myNode = new LNode(20);
            sReturn = traverseList(myMethods.reverseListRec(myNode));
            
            if (sReturn.equals("head->20->null"))
            {
                numPassedBonusTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalBonusTests + ": reverseListRec(20) ==> " + testResult + "\n Expected: head->20->null" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + sReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");  
        
        // Test 14
        numTotalBonusTests++;
        sReturn = "";
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            LNode myNode = new LNode(20);
            LNode myNode1 = new LNode(30);
            LNode myNode2 = new LNode(40);            
            myNode.setLink(myNode1);
            myNode1.setLink(myNode2);
            sReturn = traverseList(myMethods.reverseListRec(myNode));
            
            if (sReturn.equals("head->40->30->20->null"))
            {
                numPassedBonusTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalBonusTests + ": reverseListRec(20->30->40) ==> " + testResult + "\n Expected: head->40->30->20->null" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + sReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n"); 
        
        // Test 15
        numTotalBonusTests++;
        sReturn = "";
        testResult = "[Failed]";
        eMsg = "N/A";
        try
        {
            LNode myNode = new LNode(90);
            LNode myNode1 = new LNode(80);
            LNode myNode2 = new LNode(70);
            LNode myNode3 = new LNode(60); 
            LNode myNode4 = new LNode(50); 
            LNode myNode5 = new LNode(40); 
            myNode.setLink(myNode1);
            myNode1.setLink(myNode2);
            myNode2.setLink(myNode3);
            myNode3.setLink(myNode4);
            myNode4.setLink(myNode5);
            sReturn = traverseList(myMethods.reverseListRec(myNode));
            
            if (sReturn.equals("head->40->50->60->70->80->90->null"))
            {
                numPassedBonusTests++;
                testResult = "[Passed]";
            }
        }
        catch (RuntimeException e)
        {
            eMsg = "RuntimeException - \"" + e.getMessage()  + "\"";
        }
        
        System.out.println("Test " + numTotalBonusTests + ": reverseListRec(90->80->70->60->50->40) ==> " + testResult + "\n Expected: head->40->50->60->70->80->90->null" );
        if (eMsg.equals("N/A"))
            System.out.println(" Yours: " + sReturn + "\n");
        else
            System.out.println(" Yours: " + eMsg + "\n");  

        System.out.println("Total bonus test cases: " + numTotalBonusTests + "\nCorrect: " + numPassedBonusTests + "\nWrong: " + (numTotalBonusTests - numPassedBonusTests));		
    }
    
    public static String traverseList(LNode head)
    {
        String listContent = "head->";
        LNode current = head;
        
        while (current != null)
        {
            listContent += current.getInfo() + "->";
            current = current.getLink();
        }
        
        listContent += "null";
        
        return listContent;
    }
    
}
