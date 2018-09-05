public class LinkedStack
{
   private LNode tOS;//topOfStack, an actual node in our LL
   
   private LinkedStack()
   {
      tOS = null;//sets the content and link of LNode to be blank
   }
   
   public void push(int v)
   {
      LNode temp = new LNode(v);//creates a new node
      temp.setLink(tOS);//sets link to the previous node (the previous top of stack)
         //SetLink: m_link = link;
         //m_link belongs to temp (the object calling the method)
         //link belongs to tOS (bc its being passed in)
         //temps link is set to whatever tOS's link is
      tOS = temp;//sets top of the stack to the new stack node
   }
   
   //purpose: To take remove the most recently pushed node(tOS aka the top Of our Stack)
   //and RETURN a value, can be used in combo for calcs num = pop() + pop()
   public int pop() 
   {
      if(isEmpty)
         throw StackUnderflowException("Pop attemtped on empty stack.");//REM: include an error message
      int tval = tOS.getInfo();//get whatever value was IN the node (we store it so it can be returned)
      tOS = tOS.getLink;//we get rid of the topmost element of the stack
      //How? By telling it to get the next link in the series, and assign it as the current link
      //Delete by omission //?
      return tval;//!
   }
}