//This class represents a node in a Linked List
//09.06.16
   
public class KthNode
{
    public static void main(String args[]){
         LinkedNumberList mylist2 = new LinkedNumberList();

         mylist2.insert(10);
         mylist2.insert(30);
         mylist2.insert(20);
         mylist2.insert(25);
         mylist2.insert(77);
         mylist2.insert(66);
         
         System.out.println("List Size " + mylist2.size());
         System.out.println("Kth elem " + mylist2.findKthElemFromLastNode(1));
         
         System.out.println(mylist2.toString());

    }
    
    
}