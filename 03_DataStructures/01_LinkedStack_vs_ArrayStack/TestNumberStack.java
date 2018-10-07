public class TestNumberStack
{

   public static void main(String[] args)
   {
      try//your try & catch are supposed to be caught in the main
      {
      numberStack mystack = new ArrayNumberStack(5);
      mystack.push(100);
      mystack.push(50);
      mystack.push(70);
      mystack.push(23);
      mystack.push(19);
      
      System.out.println(mystack);
      System.out.println("Is the stack empty " + mystack.isEmpty());
      System.out.println("Is the stack full " + mystack.isFull());
      System.out.println("top " + mystack.top());
      System.out.println("size " + mystack.size());
      
      
      mystack.pop();
      mystack.pop();
      mystack.push(3);
      
      System.out.println(mystack);//toString implicit
      mystack.pop();
      mystack.pop();
      mystack.pop();
      mystack.pop();
      mystack.pop();

      System.out.println(mystack);
      }
      catch(RuntimeException e)
      {

      }
   }
}