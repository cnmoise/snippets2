
// https://www.hackerrank.com/challenges/ctci-comparator-sorting/

class Checker implements Comparator<Player> {
  	// complete this method

    //Don't try to get fancy and use methods that you THINK you understand
    //Walk your goddamn code
    //think of a couple of good cases + examples + edge cases
	public int compare(Player a, Player b) {
        if(a.score>b.score){
            return -1;
        }
        else if (b.score > a.score){
            return 1;
        }
        else{
            if(a.name.equals(b.name)){
                return 0;
            }
            char[] aN = a.name.toCharArray();
            char[] bN = b.name.toCharArray();

            if(aN.length <= bN.length){
                for(int i=0; i< aN.length ;i++){
                    if((int) aN[i] < (int) bN[i]){
                        return -1;
                    }
                    else if ((int) aN[i] > (int) bN[i]) {
                        return 1;
                    }
                    //else continue loop
                    //don't worry about if they are exactly equal, we took care of it in the start
                }
                //case where we run out of letters in the first word
                return -1;
            }
            else{
                for(int i=0; i< bN.length ;i++){
                    if((int) aN[i] < (int) bN[i]){
                        return -1;
                    }
                    else if ((int) aN[i] > (int) bN[i]) {
                        return 1;
                    }
                    //else continue loop
                    //don't worry about if they are exactly equal, we took care of it in the start
                }
                return 1;
            }

            // String[] p2 = {a.name, b.name};
            // Arrays.sort(p2);
            // if(p2[0].equals(a.name)){
            //     return 1;
            // }
            // else{
            //     return 1;
            // }
        }
    }
}