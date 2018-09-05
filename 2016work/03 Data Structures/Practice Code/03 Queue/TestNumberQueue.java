//Tester for our Queue classes
//Claude

public class TestNumberQueue
{
   public static void main(String[] args)
   {
      try
      {
         NumberQueue myq1 = new ArrayNumberQueue(5);
         myq1.enque(100);
         myq1.enque(50);
         myq1.enque(75);
         myq1.enque(23);
         myq1.enque(19);
         
         System.out.println(myq1);
         System.out.println("Empty?" + myq1.isEmpty());
         System.out.println("Empty?" + myq1.isFull());
         System.out.println("Deque?" + myq1.dequeue());
         System.out.println("Size?" + myq1.size());
         
         myq1.denque();
         myq1.denque();
         myq1.enque(3);
         
         System.out.println(myq1);

         myq1.denque();
         myq1.denque();
         myq1.denque();
         //to break uncomment
         //myq1.denque();
         
         System.out.println(myq1);
         


      }
      catch(RuntimeException e)
      {
        System.out.println(e.getMessage());

      }
      
   }


}