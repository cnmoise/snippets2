// https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
static int sherlockAndAnagrams(String s) {

  //Solution logic was solid, seriously need to believe myself more
  //DON'T BE LAZY
  //WALK YOUR GODDAMN SOLUTION CODE 

  String anagI, anagJ;
  int co = 0;

  for(int win = 1; win <= s.length()-1; win++){
    for(int i = 0; i <= s.length()-win; i++){
      for(int j = i+1; j <= s.length()-win; j++){


      anagI = s.substring(i, i + win-1);
      anagJ = s.substring(j, j + win-1);

      System.out.println("i: " + i +" anagI: " + anagI);
      System.out.println("j: " + j +" anagJ: " + anagJ);

        if(areAnagrams(anagI, anagJ)){
        co++;
        }
      }
    }
  }
  return co;
}

//prime example of an alphamap
static boolean areAnagrams(String anagI, String anagJ){
    int[] alphamapI = new int[26];
    int[] alphamapJ = new int[26];
    int offset = (int) 'a';
    int mapind = -1;

    //build frequency tables
    for(int i = 0; i< anagI.length(); i++){
      mapind = anagI.charAt(i)-offset;
      alphamapI[mapind] += 1;
    }
    //alternatively we can remove this for loop by doing a depop
    for(int j = 0; j< anagJ.length(); j++){
      mapind = anagJ.charAt(j)-offset;
      alphamapJ[mapind] += 1;
    }

    //Check each for equiv.
    for(int k = 0; k< 26; k++){
      if(alphamapI[k] != alphamapJ[k]){
      return false;
    }
  }

return true;
}