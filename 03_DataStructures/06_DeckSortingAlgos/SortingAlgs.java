// The SortingAlgs class that implements selection sort and merge sort
// Claudiu Moise

public class SortingAlgs 
{
    //Target // card comparison //static add?
    public int compares(Card c1, Card c2)
    {       
        //rets -1, 0, 1 if c1 is smaller, equal to, or greater than c2
        //compare by suits first, then rank
        
        //key in both algs
        int c1suit = c1.getSuit();
        int c1rank = c1.getRank();
        
        int c2suit = c2.getSuit();
        int c2rank = c2.getRank();
        
        if(c1suit == c2suit && c1rank == c2rank)
        {
            return 0;
        }
        
        if(c1suit == c2suit)
        {
            if(c1rank < c2rank)
               return -1;

        }
        
        if(c1suit < c2suit)
        {
            return -1;
        }
        
        //means that none of our other things have triggered a return
        return 1;
    }
    
    //Target // selection sort
    public void selectionSort(Card[] cardArray)
    {
        int endIndex = cardArray.length - 1;
        Card temp = new Card(0,0);//ini val
        int cmi = 0;
        
        for (int i = 0; i < endIndex; i++)
        {
            cmi = minIndex(cardArray, i, endIndex);//current min's index
            //put the smallest element in the (cur)front of the array
            temp = cardArray[i];
            cardArray[i] = cardArray[cmi];
            //and the front array put it in the place where the smallest used to be
            cardArray[cmi] = temp;
        }

    }
    
    //Target // find the INDEX of the smallest element in the specified range
    //helper method for selectionSort
    public int minIndex(Card[] cardArray, int startIndex, int endIndex)
    {
        //finds the smallest elem in given range
        //need compares
        int indexOfMin = startIndex +1;
        
        //needs to compare cmi with each other card in deck???
        for (int i = startIndex ; i < endIndex +1; i++)
        {   
            //need to compare card to the minimum
            if(compares(cardArray[i], cardArray[indexOfMin]) == -1)//means that card1 < card2
               indexOfMin = i;
        }
        //hopefully does not return 0
        return indexOfMin;
    }    

    // merge sort
    public void mergeSort(Card[] cardArray)
    {
        mergeSortRec(cardArray, 0, cardArray.length - 1);
    } 
    
    //No Edit
    // recursive helper recursive method for mergeSort
    // does all the messy div of merge sort
    public void mergeSortRec(Card[] cardArray, int startIndex, int endIndex)
    {
        if (startIndex < endIndex)
        {
            int midIndex = (startIndex + endIndex) / 2;
            mergeSortRec(cardArray, startIndex, midIndex);
            mergeSortRec(cardArray, midIndex + 1, endIndex);
            merge(cardArray, startIndex, endIndex);
        }
    } 
    
    //Target // merge two sorted halves into one sorted array
    //helper to mergeSortRec
    public void merge(Card[] cardArray, int startIndex, int endIndex)
    {        
        //use compare
        // two adjacent sorted halves -> one sorted array
        
        int midIndex = (startIndex + endIndex) / 2;  // calculate the index of the middle element
        int n = endIndex - startIndex + 1;           // size of the region to be merged
        Card[] tempArray = new Card[n];       // merge both havles into a temp array
        
        //this makes the splitting virtual
        int i1 = startIndex;         // next element to consider in the first half
        int i2 = midIndex + 1;  // next element to consider in the second half
        int j = 0;              // next open position in the temp array
        
        // as long as neither i1 nor i2 is past the end, move the smaller
        // element into the temp array
        while (i1 <= midIndex && i2 <= endIndex)
        {
            //
            if (compares(cardArray[i1],cardArray[i2]) == -1)//cardArray[i1] < cardArray[i2]
            {
                tempArray[j] = cardArray[i1];
                i1++;
            }
            else
            {
                tempArray[j] = cardArray[i2];
                i2++;                
            }
            
            j++; // next open position in the temp array

        }
        
        // copy any remaining elements of the first half
        while (i1 <= midIndex)
        {
            tempArray[j] = cardArray[i1];
            i1++;
            j++;
        }
        
        // copy any remaining elements of the second half
        while (i2 <= endIndex)
        {
            tempArray[j] = cardArray[i2];
            i2++;
            j++;
        }
        
        // copy back from the temp array
        for (j = 0; j < n; j++)
            cardArray[startIndex + j] = tempArray[j];

    }  
}
