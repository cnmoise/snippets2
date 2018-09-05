public class CarTest
{
public static void main(String[] args)
{
   Car c = new Car(1111, "John", "Blue");
   c.printInfo();
   System.out.println();
   
   c.transferOwner("JOHN CENA");
   c.printInfo();
}
}