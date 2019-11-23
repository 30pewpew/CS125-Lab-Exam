import java.util.Scanner;

public class LabExam 
{
	/**	
	 * 	Flow of Program
	 * 	
	 * 	1. Input 3 integers with the format (min, max, top)
	 * 	2. Will start at min going to max value
	 * 		- Counting the number of factors of the said integer
	 * 		* Use a separate thread for each number
	 * 	3. Display the ranking of each number based on the number of factors and the value
	 * 		- In case of a tie (same number of factors)
	 * 		- Then the lowest number that reached x number of factors will be selected
	 * 
	 */	
	
	
    public static void main(String[] args)
    {   
        Scanner input = new Scanner(System.in);
		System.out.println("Input min: ");
		int min = input.nextInt();
		System.out.println("Input max: ");
		int max = input.nextInt();
		System.out.println("Input top: ");
		int top = input.nextInt();
		input.close();
		
		
		int numOfFactors;
		int [] factorCounter = new int[max + 1];
		int [] rank = new int[max + 1];
		
		for (int i = min; i < (max + 1); i++)
		{	        
	        //System.out.print("{ ");
	        numOfFactors = 0;
			for (int loopCounter = 1; loopCounter <= i; loopCounter++)
			{
				if (i % loopCounter == 0)
				{
					//System.out.print(loopCounter + " ");
					numOfFactors++;
				}
			}
			factorCounter[i] = numOfFactors;
			//System.out.print("}");
			//System.out.println();
		}
		
		System.out.println();
		
		// Just check the number of factors
//		for (int i = min; i < (max + 1); i++)
//		{
//			System.out.print("Factors of " + i + ": ");
//			System.out.println(factorCounter[i]);
//		}
		
		System.out.println();
		
		// Initialize Base Rank Array
		for (int i = min; i < (max + 1); i++)
		{
			rank[i] = i;
		}	
		
		// Sorting factorCounter descending order
		for (int i = min; i < (max + 1); i++)
		{
			for (int j = i + 1; j < (max + 1); j++)
			{
				if (factorCounter[i] < factorCounter[j])
				{
					// Sort factorCounter
					int temp = factorCounter[i];
					factorCounter[i] = factorCounter[j];
					factorCounter[j] = temp;
					
					// Sort Rank based on sort of factorCounter
					int anothertemp = rank[i];
					rank[i] = rank[j];
					rank[j] = anothertemp;
				}
			}
		}		
		
		// Output new rank
		for (int i = min; i < (min + top); i++)
		{
			System.out.print((i - min + 1) + ") ");
			System.out.println("RANK: " + rank[i] + ", FACTOR: " + factorCounter[i]);
		}
		
		
    }
	
}
