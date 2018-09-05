public abstract class Product
{
      private double regularPrice;
      
      protected Product(double rG)//constructors must me protected
      {
         this.regularPrice = rG;
      }
      
      public double getProductPrice()//methods must be public
      {
         return this.regularPrice;
      }
      
      public abstract double calculateSalePrice();
}