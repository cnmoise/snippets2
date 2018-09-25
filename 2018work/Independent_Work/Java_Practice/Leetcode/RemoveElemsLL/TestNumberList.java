//the implementation step

public class TestNumberList
{
   public static void main(String[] args)
   {

      LeetCodeLinkedList mylist2 = new LeetCodeLinkedList();
      
      mylist2.insert(1);
      mylist2.insert(2);
      mylist2.insert(6);
      mylist2.insert(3);
      mylist2.insert(4);
      mylist2.insert(5);
      mylist2.insert(6);

      
      //overrode toString
      System.out.println(mylist2.toString(mylist2.getHead()));
      
      LNode newhead = mylist2.removeElements(mylist2.getHead(), 6);
      
      System.out.println(mylist2.toString(newhead));
      // System.out.println(mylist2.contains(35));
//       System.out.println(mylist2.contains(23));
//       System.out.println(mylist2.isFull());



   }

}