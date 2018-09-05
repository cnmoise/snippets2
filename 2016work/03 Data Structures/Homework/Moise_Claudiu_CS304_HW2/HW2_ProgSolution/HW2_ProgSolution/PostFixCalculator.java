// The PostFixCalculator class that implements a postfix expression calculator
// Your name here

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
    
    // mutator
    public void setPostfix(String postfix)
    {
        m_postfix = postfix;
    }
    
    // evaluate the postfix expression saved in m_postfix
    public int calculate()
    {
        Scanner tokenizer; 
        int result, operand1, operand2, value;
        String operator;
        LinkedStack myStack = new LinkedStack();

        tokenizer = new Scanner(m_postfix);

        while (tokenizer.hasNext())
        {
            if (tokenizer.hasNextInt())
            {
                value = tokenizer.nextInt();
                myStack.push(value);
            }      
            else // an operator is read in
            {
                operator = tokenizer.next();

                if (myStack.isEmpty())
                    throw new RuntimeException("Not enough operands");
                operand2 = myStack.pop();

                if (myStack.isEmpty())
                    throw new RuntimeException("Not enough operands");
                operand1 = myStack.pop();

                if (operator.equals("+"))
                    result = operand1 + operand2;
                else if (operator.equals("-"))
                    result = operand1 - operand2;
                else if (operator.equals("*"))
                    result = operand1 * operand2;
                else if (operator.equals("/"))
                    result = operand1 / operand2;
                else
                    throw new RuntimeException("Unrecognized operator: " + operator);

                myStack.push(result);
            }
        }

        if (myStack.isEmpty())
            throw new RuntimeException("Empty postfix expression");

        result = myStack.pop();

        if (!myStack.isEmpty())
            throw new RuntimeException("Too many operands");

        return result;        
    }    
}
