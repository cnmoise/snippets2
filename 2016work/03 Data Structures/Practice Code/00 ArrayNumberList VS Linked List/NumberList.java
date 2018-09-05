//Author: Claudiu Moise
//Number list interface



public interface NumberList{

   void insert(int v); //insert a number into the list   
   boolean isFull(); //check if our list is full
   boolean contains(int v); //checks if a number exists in the list
   
   @Override//not strictly necessary
   String toString(); //return a string representation of the num list
   
}