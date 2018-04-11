public class PerformanceSeatingTest
{
	public static void main(String[] args)
	{
		PerformanceSeating ps = new PerformanceSeating(5, 10);
		ps.printSeats();
		System.out.println();
		
		ps.bookSeats(10);
      ps.cancelSeat(0, 4);
      ps.printSeats();
		System.out.println();
		
		

		
		ps.bookSeats(21);
		ps.cancelSeat(0, 3);
		ps.cancelSeat(1, 8);
		ps.cancelSeat(2, 1);
		ps.printSeats();
		System.out.println();
		
		System.out.println("Available seats: " + ps.findAvailableSeats());
		System.out.println("Booked seats: " + ps.findBookedSeats());
	}
}