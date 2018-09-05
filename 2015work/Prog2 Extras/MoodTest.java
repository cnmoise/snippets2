public class MoodTest
{
 public static void main(String[] args)
 {
 MoodRing m1 = new MoodRing();
 MoodRing.display();
 m1.receivePinch(1);
 MoodRing m2 = new MoodRing("Calm");
 System.out.println(m2.display("Breathe"));
 m2.receivePinch(3);
 MoodRing[] rings = { m1, m2, new MoodRing() };
 int a = MoodRing.num;
 rings[2].receivePinch(a);
 MoodRing.display();
 rings[2] = m1;
 for (int i = 0; i < rings.length; i++)
 System.out.println(rings[i].getMood());

 }
}