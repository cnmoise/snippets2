public class BagTest
{
   public static void main(String[] args)
   {
   StringArrayBag b = new StringArrayBag(4);
   System.out.println(b.isEmpty());
   System.out.println(b.add("Apples"));
   System.out.println(b.contains("Apples"));
   System.out.println(b.add("Steak"));
   System.out.println(b.add("Chicken"));
   System.out.println(b.add("Oranges"));
   System.out.println(b.add("Chocolate"));
   b.printBag();
   System.out.println(b.remove("Chicken"));
   System.out.println(b.contains("Chicken"));
   b.printBag();
   System.out.println(b.add("Jews"));
   System.out.println(b.isEmpty());
   b.printBag();
   }
}