public class Iris {

    private double petalLength;
    private double petalWidth;
    private char species;
    private double distance;

    public Iris(double petalLength, double petalWidth, char species)
    {
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.species = species;
    }
    
    public Iris(double petalLength, double petalWidth, char species, double distance)
    {
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.species = species;
        this.distance = distance;
    }

    public double getPetalLength()
    {
        return this.petalLength;
    }
    
    public double getPetalWidth()
    {
        return this.petalWidth;
    }
    
    public char getSpecies()
    {
        return this.species;
    }
    
    public double getDistance()
    {
        return this.distance;
    }
    
    public void setDistance(double dis)
    {
    	this.distance = dis;
    }

}
