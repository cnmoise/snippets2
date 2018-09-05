public class MP3Test
{
	public static void main(String[] args)
	{
		Mp3Player iPod = new Mp3Player(129.99);
      System.out.println("Sale price: " + iPod.calculateSalePrice());
	}
}