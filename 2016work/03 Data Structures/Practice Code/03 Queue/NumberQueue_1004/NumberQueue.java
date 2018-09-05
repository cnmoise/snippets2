// The NumberQueue interface
// Xiwei Wang

public interface NumberQueue
{
    boolean isEmpty();      // check whether the queue is empty
    boolean isFull();       // check whether the queue is full
    void enqueue(int v);    // add an element to the rear of the queue
    int dequeue();          // remove and return the element at the front of the queue
    int size();             // return the size of the queue
    @Override
    String toString();      // return a string representation of the queue
}
