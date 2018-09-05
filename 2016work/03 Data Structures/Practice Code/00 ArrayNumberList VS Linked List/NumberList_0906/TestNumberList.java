// The test deriver for the NumberList ADT implementations
// Xiwei Wang

public class TestNumberList 
{
    public static void main(String[] args)
    {
        NumberList mylist1 = new ArrayNumberList(5);
        mylist1.insert(100);
        mylist1.insert(50);
        mylist1.insert(70);
        mylist1.insert(23);
        mylist1.insert(19);
        
        System.out.println(mylist1);
        System.out.println("Does 35 exist in the list? " + 
                            mylist1.contains(35));
        System.out.println("Does 23 exist in the list? " + 
                            mylist1.contains(23));
        System.out.println("Is the list full? " + mylist1.isFull());

        NumberList mylist2 = new LinkedNumberList();
        mylist2.insert(100);
        mylist2.insert(50);
        mylist2.insert(70);
        mylist2.insert(23);
        mylist2.insert(19);
        
        System.out.println(mylist2);
        System.out.println("Does 35 exist in the list? " + 
                            mylist2.contains(35));
        System.out.println("Does 23 exist in the list? " + 
                            mylist2.contains(23));
        System.out.println("Is the list full? " + mylist2.isFull());        
    }
}
