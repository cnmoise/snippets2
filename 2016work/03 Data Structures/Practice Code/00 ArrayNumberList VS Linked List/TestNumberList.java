//the implementation step

public class TestNumberList
{
   public static void main(String[] args)
   {
      NumberList mylist1 = new ArrayNumberList(5);
      
      mylist1.insert(100);
      mylist1.insert(50);
      mylist1.insert(75);
      mylist1.insert(23);
      mylist1.insert(19);
      
      System.out.println(mylist1.toString());//we can technically eschew toString, its called automatically
      System.out.println(mylist1.contains(35));
      System.out.println(mylist1.contains(23));
      System.out.println(mylist1.isFull());
      
      NumberList mylist2 = new LinkedNumberList();
      
      mylist2.insert(100);
      mylist2.insert(50);
      mylist2.insert(75);
      mylist2.insert(23);
      mylist2.insert(19);
      
      System.out.println(mylist2.toString());//we can technically eschew toString, its called automatically
      System.out.println(mylist2.contains(35));
      System.out.println(mylist2.contains(23));
      System.out.println(mylist2.isFull());

   }

}