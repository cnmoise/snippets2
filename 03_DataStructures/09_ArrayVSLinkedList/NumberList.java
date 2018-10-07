// The NumberList interface
// Xiwei Wang

public interface NumberList 
{
    void insert(int v);         // insert a number into the list
    boolean isFull();           // check whether the list is full
    boolean contains(int v);    // check whether a given number exists in the list
    @Override
    String toString();          // return a string representation of the list
}
