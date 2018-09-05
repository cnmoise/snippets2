public class KNN
{
	public static void main(String[] args)
	{
		Iris[] array = new Iris[21];
		createArray(array);
		
		findDistances(array);
		
		int k = 5;
		sortByMinDistance(array);
		classifyNewIris(array, k);	
	}
	
	
	public static void createArray(Iris[] array)
	{
		array[0] = new Iris(1.4, 0.2, 'S');
      array[1] = new Iris(1.4, 0.2, 'S');
      array[2] = new Iris(1.3, 0.2, 'S');
      array[3] = new Iris(1.5, 0.2, 'S');
      array[4] = new Iris(1.4, 0.2, 'S');
      
      array[5] = new Iris(1.7, 0.4, 'S');
      array[6] = new Iris(1.4, 0.3, 'S');
      array[7] = new Iris(4.7, 1.4, 'C');
      array[8] = new Iris(4.5, 1.5, 'C');
      array[9] = new Iris(4.9, 1.5, 'C');

      array[10] = new Iris(4.0, 1.3, 'C');
      array[11] = new Iris(4.6, 1.5, 'C');
      array[12] = new Iris(4.5, 1.3, 'C');
      array[13] = new Iris(4.7, 1.6, 'C');
      array[14] = new Iris(5.9, 2.1, 'V');
      
      array[15] = new Iris(5.6, 1.8, 'V');
      array[16] = new Iris(5.8, 2.2, 'V');
      array[17] = new Iris(6.6, 2.1, 'V');
      array[18] = new Iris(4.5, 1.7, 'V');
      array[19] = new Iris(6.3, 1.8, 'V');
      
      array[20] = new Iris(5.8, 1.8, 'V');//REM chars use single quotes
	}
	
	
	public static void findDistances(Iris[] array)
	{
		double newIrisLength = 5.4;
		double newIrisWidth = 1.4;
		for (int i = 0; i < array.length; i++)
		{
			double distance = calculateDistance(array[i], newIrisLength, newIrisWidth);
			array[i].setDistance(distance);
		}
	}
	
	
	public static double calculateDistance(Iris f, double newIrisLength, double newIrisWidth)
	{
		return Math.sqrt(Math.pow(f.getPetalLength() - newIrisLength , 2) + (Math.pow(f.getPetalWidth() - newIrisWidth, 2)));
      //rem to use your . operators to get info
	}
	
	
	public static void sortByMinDistance(Iris[] array)
	{
		for (int i = 0; i < array.length - 1; i++)
		{
			double tempMin = array[i].getDistance();
			int tempIndex = i;
			
			for (int j = i + 1; j < array.length; j++)
			{
				if (array[j].getDistance() < tempMin)
				{
					tempMin = array[j].getDistance();
					tempIndex = j;
				}
			}
			
			swap(array, i, tempIndex);
		}
	}
	
	public static void swap(Iris[] array, int i, int m)
	{
		Iris tempPoint = new Iris(array[i].getPetalLength(), array[i].getPetalWidth(), array[i].getSpecies(), array[i].getDistance());
		Iris tempMinPoint = new Iris(array[m].getPetalLength(), array[m].getPetalWidth(), array[m].getSpecies(), array[m].getDistance());
		array[i] = tempMinPoint;
		array[m] = tempPoint;
	}
	
	
	public static void classifyNewIris(Iris[] array, int k)//k is the dist to a new obj
	{
      int cCount;//last end point
      int sCount;
      int vCount;
      
		for(int i = 0; i <= k; i++)
      {
         if (array[i].getSpecies == 'C')
            cCount++;
         else if(array[i] == 'V')
           
      }
	}
	
}