// The test driver that check for palindromes
// Xiwei Wang

import java.util.Scanner;

public class Palindrome
{
    public static void main(String[] args)
    {
        Scanner conIn = new Scanner(System.in);
        
        System.out.print("Please enter a string: ");
        String str = conIn.nextLine();
        
        CharQueue q = new CharQueue(str.length());
        CharStack s = new CharStack(str.length());
        
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            
            q.enqueue(c);
            s.push(c);
            //they just naturally start at opposite ends
        }
        
        boolean isPalindrome = true;
        
        //while the stack is not empty
        while (!s.isEmpty())
        {
            if (q.dequeue() != s.pop())//if the value taken off the stack & que are not the same
            {
                isPalindrome = false;
                break;
            }
        }
        
        if (isPalindrome)
            System.out.println("\"" + str + "\" is a palindrome." );
        else
            System.out.println("\"" + str + "\" is not a palindrome." );
    }
}
