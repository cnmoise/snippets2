//The NumStack interface
//

public interface numberStack

{
   boolean isEmpty(); //checks if DUH
   boolean isFull(); //checks if DUH
   int top(); //returns elem at the top of stack (getter)
   int pop(); //remove and return elem at the top of stack
   void push(int v); //pushes a value onto the stack
   int size();
   //overide
   String toString(); //returns a str representation of stack
}