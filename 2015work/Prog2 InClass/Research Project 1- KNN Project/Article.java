public class Article {

    public double numPics;
    public double numPars;
    public char label;
    public double distance;

    public Article(double pics, double pars, char label)
    {
        this.label = label;
        this.numPics = pics;
        this.numPars = pars;
    }
    
    public Article(double pics, double pars, char label, double dis)
    {
        this.label = label;
        this.numPics = pics;
        this.numPars = pars;
        this.distance = dis;
    }

    public char getLabel()
    {
        return this.label;
    }
    
    public double getNumPics()
    {
        return this.numPics;
    }
    
    public double getNumPars()
    {
        return this.numPars;
    }
    
    public void setDistance(double dis)
    {
    	this.distance = dis;
    }
    
    public double getDistance()
    {
    	return this.distance;
    }
}
