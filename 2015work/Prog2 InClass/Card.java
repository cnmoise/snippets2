public class Card
{
   private int rank;
   private String suit;
   
   public Card(String s, int r)
   {
      this.suit = s;
      this.rank = r;
   }

   public String getSuit()
   {
      return this.suit;
   }
   
   public int getRank()
   {
      return this.rank;
   }
}