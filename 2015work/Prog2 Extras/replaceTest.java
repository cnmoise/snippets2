public class replaceTest
{
	public static void main(String[] args)
	{
		String s = "chincherinchee";
      System.out.println(s);
      s = s.replaceAll("ch", "");
      System.out.println(s);
      
      String a = "manically";
      String v = "ic";
      System.out.println(a);
      //a = a.replaceAll(v , "");//yes replaceAll can take variables
      System.out.println(a.matches(".*" + v + ".*"));//GT
      //in order to pass in a variable it has to not be in the quotes
      //since we still want to match with everything, we need the .* on both sides
	}
}