//Class Author: Claudiu Moise || Homework 4 || Problem 2


public class MyPointTest
{
	public static void main(String[] args)
	{
		MyPoint p1 = new MyPoint();
		MyPoint p2 = new MyPoint(4, 8);
		
		double dis = p1.distance(3, 4);
		System.out.print("The distance from " + p1.toString());
		System.out.println(" to (3, 4) is: " + dis);
		
		p1.setXY(10, 10);
		System.out.println("x is: " + p1.getX());
		System.out.println("y is: " + p1.getY());
		
		MyPoint[] points = { p1, p2, new MyPoint(7, 3) };
		for (int i = 0; i < points.length - 1; i++)
		{
			System.out.print("The distance from " + points[i].toString());
			System.out.print(" to " + points[i + 1].toString() + " is: ");
			dis = points[i].distance(points[i + 1]);
			System.out.println(dis);
		}
		
	}
}