public class Mp3Player extends Product
{      
      public Mp3Player(double rG)//constructors must me protected
      {
         super(rG);
      }
      
      public double calculateSalePrice()
      {
         double p = super.getProductPrice();//remember if were using a method from our superclass, to use super
         return p*.87;
         
      }
}