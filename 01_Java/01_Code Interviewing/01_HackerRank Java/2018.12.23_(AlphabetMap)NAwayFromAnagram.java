public class anagram {

    public static void main(String[] args)
    {
        String[] tests = {
        	"hhpddlnnsjfoyxpciioigvjqzfbpllssuj",
			"xulkowreuowzxgnhmiqekxhzistdocbnyozmnqthhpievvlj",
			"dnqaurlplofnrtmh",
			"aujteqimwfkjoqodgqaxbrkrwykpmuimqtgulojjwtukjiqrasqejbvfbixnchzsahpnyayutsgecwvcqngzoehrmeeqlgknnb",
			"lbafwuoawkxydlfcbjjtxpzpchzrvbtievqbpedlqbktorypcjkzzkodrpvosqzxmpad",
			"drngbjuuhmwqwxrinxccsqxkpwygwcdbtriwaesjsobrntzaqbe",
			"ubulzt",
			"vxxzsqjqsnibgydzlyynqcrayvwjurfsqfrivayopgrxewwruvemzy",
			"xtnipeqhxvafqaggqoanvwkmthtfirwhmjrbphlmeluvoa",
			"gqdvlchavotcykafyjzbbgmnlajiqlnwctrnvznspiwquxxsiwuldizqkkaawpyyisnftdzklwagv"
        };

        System.out.println(anagram(tests[1]));
    }
   

   public static int anagram(String s) {
        //Extremely clear code!! Wow
        int slen = s.length();
        if(slen % 2 != 0 || slen == 0){
            return -1;
        }

        String subL = s.substring(0, slen/2);
        String subR = s.substring(slen/2);
        int offset = (int) 'a';
        int diffco = 0;

        int[] alphacountL = new int[26];
        int[] alphacountR = new int[26];

        for(int i = 0; i<subL.length(); i++){
            int mapind = subL.charAt(i)-offset;
            alphacountL[mapind] += 1;
        }
        for(int j = 0; j<subR.length(); j++){
            int mapind = subR.charAt(j)-offset;
            alphacountR[mapind] += 1;
        }
        for(int k = 0; k<alphacountR.length; k++){
            diffco += Math.abs(alphacountL[k]-alphacountR[k]);
        }
        //we count the number of differences twice
        diffco = diffco/2;
        return diffco;

    }
}
        
