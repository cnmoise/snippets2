//very interesting program

public class changeDuplicates
{
   public static void main(String[] args)
      {
        String s = "mississippi";//in the problem this is actually an argument passed into a static method
        if(s.matches(".*[A-Z].*")){
            throw new IllegalArgumentException("Capital letters not permitted");}
        
        String s1 = s;//for storing the argument
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            //f = front, b = back end of the String
            String f = s1.substring(0, i+1);//brings us to the desired stoping point
            String b = s1.substring(i+1);//brings us all the way to the end of the string
            
            b = b.replace(c, '-');//we replace the offending character with -
            s1 = f + b;
        }
        
        System.out.println(s1);
   
   }
}