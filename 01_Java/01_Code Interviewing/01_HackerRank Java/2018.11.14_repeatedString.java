public class repeatedString {

    public static void main(String[] args)
    {
         long n = 736778906400L;
        System.out.println(repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", n));
    }

    public static long repeatedString(String s, long n) {
        static long repeatedString(String s, long n) {
        long aco = 0;
       
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='a'){
                aco++;
            }
        }
        System.out.println(aco);
        long yang = n/s.length();
        long total = yang*aco;
        
        long remainder = n % s.length();
        
        //Determines how many characters in we will analyze towards the end of our n range
        for(int i = 0; i < remainder; i++)
        {
            if(s.charAt(i) == 'a')
            {
                total++;
            }
        }
        
        return total;
         }
    }


}
