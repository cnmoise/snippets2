//Author: Claudiu Moise || Homework 5 || Problem 1
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TESTPOINT.java program

public class GroceryList
{
   private Item[] groceries;//an array of object type Item
   
   public GroceryList(Item Ri)
   {
      this.groceries = new Item[]{Ri};//REM: to use new Class[]{whatever elements}
      //Alt: this.groceries = new Item[1];//item array of size 1
      //Item[1] = Ri;
   }
   
   public Item[] getGroceries()
   {
      return this.groceries;
   }
   //---
   public void addItem(Item Ri2)
   {
      Item[] tempG = new Item[this.groceries.length+1];//creates an array that gets whiped out each time we call the method
      //Rem: new Class[number of spaces]
      for(int j = 0; j < groceries.length; j++)//re-enters all of the items from the groceries list into the temp arr
         {
         tempG[j] = this.groceries[j];
         }
      tempG[this.groceries.length] = Ri2;//adds the item spec. to end of list
      this.groceries = tempG;//this makes a groceries to point to tempG
   }
   //---
   public void removeItem(int Rf)
   {
      Item[] tempGR = new Item[this.groceries.length-1];//makes arr that fits 1 less item
      int i = 0;
      
      for(int j = 0; j < this.groceries.length; j++)//re-enters all of the items from temp back into groceries list
         {
         if (j != Rf){//causes the array to skip over the specific element
            tempGR[i] = this.groceries[j];
            i++;}//Fix this
            //alt:
            //if (i<n)
            // tempGR[i] = this.groceries[i];
            //else if (i>n)
            // tempGR[i-1] = this.groceries[i];
         }
      this.groceries = tempGR;
   }
}
















/*
if (j != Rf)//causes the array to skip over
            this.groceries[j] = tempGR[j];
         else
            tempGR[j+1]
            j++
         
         //reasigns this pos to that of the next obj
         //might need a for loop to do this */