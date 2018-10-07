// The PostFixCalculator class that implements a postfix expression calculator
// Claudiu Moise
// Creates a stack

//Questions: do we ever need to check if a stack is full?

import java.util.Scanner;

public class PostFixCalculator 
{
    // instance variable
    String m_postfix;
    
    // constructor
    public PostFixCalculator()
    {
        m_postfix = "";
    }
    
    // mutator // postfix are all of the numbers we perform operations on
    public void setPostfix(String postfix)
    {
        m_postfix = postfix;
    }
    
    //Target // evaluate the postfix expression saved in m_postfix
    public int calculate()
    {
        Scanner tokenizer;
        //mass declaration
        int result = 0, operand1, operand2, value;
        String operator;
        //need a stack to implement method, use all you have already made
        LinkedStack myStack = new LinkedStack();
        
        //I think we need to use the tokenizer, 
        tokenizer = new Scanner(m_postfix);

        //What lets us use the .hasNext() method? the fact that its a Scanner object?
        while(tokenizer.hasNext())
         {
            //get an item, determines if its an operand or operator
            
            //REM: .hasNext (when working with a linked list)??
            if(tokenizer.hasNextInt())
              {
                  //for an operand (number), value is a provisionary variable
                  value = tokenizer.nextInt();
                  myStack.push(value);
              }
            else
              {
                  operator = tokenizer.next();
                                
                  //gets a second operand, first by looking at the top of the stack, then popping it off
                  if (myStack.isEmpty())
                     throw new RuntimeException("Not enough operands");//stack underflow
                  
                  operand2 = myStack.top();//not needed if our pop naturally returns the value
                  myStack.pop();
                  
                  if (myStack.isEmpty())
                     throw new RuntimeException("Not enough operands");//stack underflow
                  
                  //gets a first operand
                  operand1 =  myStack.top();
                  myStack.pop();
                  
                  //why is the order reverse? LIFO //Critical to correct arithmatic
                  
                  //we do whatever operation we find
                  if (operator.equals("/"))
                     result = operand1 / operand2;
                  else if(operator.equals("*"))
                     result = operand1 * operand2;
                  else if(operator.equals("+"))
                     result = operand1 + operand2;
                  else if(operator.equals("-"))
                     result = operand1 - operand2;
                  else
                     throw new RuntimeException("Unrecognized operator: " + operator);
                     
                  myStack.push(result);                     
              } 
         }
         
         if (myStack.isEmpty())
            throw new RuntimeException("Not enough operands");
         result = myStack.top() ;
         myStack.pop();
         
         if (!myStack.isEmpty())
            throw new RuntimeException("Too many operands");//operands left over
        
        
        return result;
    }    
}
