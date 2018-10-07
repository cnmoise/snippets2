//Author: Claudiu Moise || Homework 5 || Problem 1
//Good Tracing Exercise for Review

public class GroceryTest
{
	public static void main(String[] args)
	{
   
      Item i1 = new Item("Bananas" , .99 );
      GroceryList c1 = new GroceryList(i1);
      
      Item i2 = new Item("Saltines" , 1.23 );
      Item i3 = new Item("Chocolate" , 4.57 );
      c1.addItem(i2);
      c1.addItem(i3);

      Item[] arrG = new Item[3];
      arrG = c1.getGroceries();//making a duplicate of c1
      
      for(int i = 0; i < arrG.length; i++)//Don't put ; before a loops even begun
      {
         arrG[i].display();
      }
   
      c1.removeItem(1);//why doesn't arrG work here in place of c1?
      
      Item[] arrG2 = new Item[3];
      arrG2 = c1.getGroceries();//why doesn't arrG work here in place of c1?
      
      for(int i = 0; i < arrG2.length; i++)
      {
         arrG2[i].display();
      }
	}
}