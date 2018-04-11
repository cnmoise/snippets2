public class WordInheritanceTest
{
	public static void main(String[] args)
	{
		ConsonantWord cw1 = new ConsonantWord("apple");
		System.out.println("New ConsonantWord object");
		System.out.println("Superclass word: " + cw1.getWord());
		System.out.println("Subclass word: " + cw1.getCword());
		System.out.println("Is cWord a substring of word? " + cw1.isSubstring() + "\n");
		
		ConsonantWord cw2 = new ConsonantWord("banana");
		System.out.println("New ConsonantWord object");
		System.out.println("Superclass word: " + cw2.getWord());
		System.out.println("Subclass word: " + cw2.getCword());
		System.out.println("Is cWord a substring of word? " + cw2.isSubstring() + "\n");
			
		Word w1 = new Word("apple");
		System.out.println("New Word object");
		System.out.println("Instance variable word: " + w1.getWord());	
		System.out.println("Is ConsonantWord object cw1 equal to Word object w1? " + cw1.equals(w1));
	}
}