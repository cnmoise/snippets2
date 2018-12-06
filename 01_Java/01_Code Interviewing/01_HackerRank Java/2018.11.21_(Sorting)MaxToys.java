//Source:
//https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting

static int maximumToys(int[] prices, int k) {
        int[] sortedprices = sort(prices);
        int currentspent=0;
        int cotoys = 0;
        for(int i = 0; currentspent<k; i++){
            if(currentspent + sortedprices[i] < k){
                currentspent += sortedprices[i];
                cotoys++;
            }
            else{ break; }
        }
    return cotoys;
    }
    
    static int[] sort(int[] prices){
        return qsort(prices, 0, prices.length-1);
    }
    
    static int[] qsort(int[] prices, int first, int last){
        if(first < last){
            int splitpt = partition(prices, first, last);
            qsort(prices, first, splitpt-1);//goLeft
            qsort(prices, splitpt+1, last);//goRight
        }
        return prices;
    }
    
    static int partition(int[] prices, int low, int high){
        int pivotval = prices[high];
        int walli = low-1 ;
        int temp = -1;
        for(int j = low; j < high; j++){
            if(prices[j]<= pivotval){
                walli++;
                //swap positions such that we move the smaller element to the sorted section of the array, represented by walli
                temp = prices[walli];
                prices[walli] = prices[j];
                prices[j] = temp;
                }
        }
        //swap the pivot to the sorted side of the array
        temp = prices[walli+1];
        prices[walli+1] = prices[high];
        prices[high] = temp;
        
        return walli + 1;
    }