//
public class Stock
{
	private String symbol;
   private String name;
   private double previousClosingPrice;
   private double currentPrice;
   public static int stockCount = 0;
	
   	
   public Stock(String s, String n)
   {
      this.symbol = s;
      this.name = n;
      stockCount++;
   }
   
   public String getSymbol()//example of a getter
   {
      return this.symbol;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public double getPreviousClosingPrice()
   {
      return this.previousClosingPrice;
   }
   
   public void setPreviousClosingPrice(double p)
   {
   this.setPreviousClosingPrice = p;
   }
}