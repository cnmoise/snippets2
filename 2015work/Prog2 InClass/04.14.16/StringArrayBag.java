public class StringArrayBag implements Bag
{
   private String[] bag;
   private int numberOfEntries;
   
   public StringArrayBag(int i)
   {
      this.bag = new String[i];//REM how to declare the number of spaces in our array
      this.numberOfEntries = 0;
   }
   //
   public boolean isEmpty()
   {
      boolean bool = false;
      
      for(int i = 0; i < this.bag.length; i++)
      {
         if(this.bag[i] == null)//GT, checks if each position in our bag array
            bool = true;
         else
            bool = false;
      }     
      return bool;
   }
   
   public boolean add(String s)
   {
      boolean complete = false;//checks if loop executes
      int counter = 0;
            
      while(!complete && counter < this.bag.length)//while NOT complete, equivalent to complete == false
      {
         if(this.bag[counter] == null)//if bag is empty at this position...
            {
            this.bag[counter] = s;//REM were still working with an instance var, so use this.
            complete = true;
            numberOfEntries++;
            }
         //else we can move to the next elem
         counter++;
      }
      //if we have not performed our task, it means there are no more spaces, thus we return false
      
      return complete;
      }
   
   public boolean remove(String s)//Checks to see if it can remove the indicated s, if so it returns true
   {
      boolean complete = false;
      int counter = 0;

      while(!complete && counter < this.bag.length)
      {
         if(this.bag[counter].matches(s))//works?
           {
           this.bag[counter] = null;
           complete = true;
           numberOfEntries--;
           } 
         counter++;
      }
      
      return complete;
   }
   
   public boolean contains(String s)//Checks to see if it can remove the indicated s, if so it returns true
   {
      boolean complete = false;
      boolean retBool = false;
      int counter = 0;

      while(!complete && counter < this.bag.length)
      {
         if(this.bag[counter] != null && this.bag[counter].matches(s))//works?
           {
           retBool = true;
           complete = true;
           }
         counter++; 
      }
      if(complete == false)//reduntant but clarity
      {
         retBool = false;
      }
      
      return retBool;
   }
   
   public void printBag()
   {
      
      for(int i = 0; i < this.bag.length; i++)
         {
            System.out.print(this.bag[i] + " ");
         }
      System.out.println();
      
   }
}