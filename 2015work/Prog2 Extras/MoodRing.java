public class MoodRing
{
 private String mood;
 public static int num = 0;

 public MoodRing()
 {
 num++;
 this.mood = "happy";
 System.out.println(this.mood + " "
 + num);
 }
 public MoodRing(String m)
 {
 this.mood = m;
 num++;
 System.out.println(num + " "
 + this.mood);
}
 public String getMood()
 {
 return this.mood;
 }
 public void receivePinch(int n)
 {
 if (n == 1)
 this.mood = "fine";
 else if (n < 6)
 this.mood = "angry";
 else
 this.mood = "annoyed";
 num += n;
 }
 public static void display()
 {
 System.out.println("Moods: " + num);
 }
 public static String display(String m)
 {
 return m + num;
 }
}