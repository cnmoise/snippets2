public interface NumberQueue
{
   boolean isEmpty(); 
   boolean isFull();
   void enque(int v);//adds elem to the rear of the queue
   int dequeue();//remove and return the elem at the front of the queue
   int size();
   //overriden
   String toString();
}