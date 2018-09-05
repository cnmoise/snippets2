//Teacher provided

public interface Transportable
{
	public abstract boolean isFragile();
	
	public abstract boolean isHazardous();
		
	public abstract double calculateShippingCost(int units);
}