//Teacher provided

public abstract class Item
{
	private int id;
	private String name;
	
	protected Item(int id, String n)
	{
		this.id = id;
		this.name = n;
	} 
	
	public int getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public abstract String getDescription();
	
	public abstract void printDetails();
}