import java.util.Random;
public class PokerHand
{
	public static void main(String[] args)
	{
		int r1, r2;
      String suit;
      Random randGen = new Random();
      Card[] hand = new Card[5];
      
      for (int i = 0; i < hand.length; i++)//fills your poker hand with cards
      {
         r1 = randGen.nextInt(4) + 1;//generates one of the four suits
         r2 = randGen.nextInt(13) + 1;
         if (r1 == 1)
            suit = "Clubs";
         else if (r1 == 2)
            suit = "Diamonds";
         else if (r1 == 2)
            suit = "Hearts";
         else(r1 == 2)
            suit = "Spades";
            
         hand[i] = new Card(suit, r2);   
      }
      
	}
}