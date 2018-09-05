public class Word
{
	private String word;
	private int numSpam;
	private int numNotSpam;
	private final double SPAM_TOTAL = 1929914;
	private final double NOT_SPAM_TOTAL = 508443;
	
	public Word(String w, int notSpam, int spam)
	{
		this.word = w;
		this.numSpam = spam;
		this.numNotSpam = notSpam;
	}
	
	public String getWord()
	{
		return this.word;
	}
	
	public double findSpamProb()
	{
		return (this.numSpam/SPAM_TOTAL)/(this.numSpam/SPAM_TOTAL + this.numNotSpam/NOT_SPAM_TOTAL);
	}
	
	public double findNotSpamProb()
	{
		return (this.numNotSpam/NOT_SPAM_TOTAL)/(this.numNotSpam/NOT_SPAM_TOTAL + this.numSpam/SPAM_TOTAL);
	}
}