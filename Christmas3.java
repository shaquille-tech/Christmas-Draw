// libaires that are needed for the program to run 

import java.util.*;
import javafx.util.Pair; 

public class Christmas3 {

	public static void main(String[] args) {
        // This the array for buying
		String [] buyFor= {
				"x1","y1",
				"x2","y2",
				"x3","y3",
				"x4","y4",
				"x5","y5"};

		String [] buyTo= {
				"x1","y1",
				"x2","y2",
				"x3","y3",
				"x4","y4",
				"x5","y5"};
		// This the array of couples to compare against 
		String [][]couples= {
				{"x1","y1"},
				{"x2","y2"},
				{"x3","y3"},
				{"x4","y4"},
				{"x5","y5"}
		};
		// This is a pair that i have imported and made an array of them, 
		// this array will store this year results that will be checked against the next year
		ArrayList <Pair <String, String> >  lastYear = new ArrayList <Pair <String, String> > ();
		// making variables that i will use later 
		Random r = new Random();		
		int p= 10;
		int n=0;
		
		System.out.println("This year's draw: ");
		while(n<p) 
		{	
			int n1= r.nextInt(p);
			String a= buyFor[n1];
			int n2= r.nextInt(p);
			String b = buyTo[n2];
			if(!checkForCouples(a, b, couples)) // checks if the a and b are a couples
			{
				if(!checkForLastYear(lastYear, new Pair(a,b))) // check if a and b were pairs last year
				{
					lastYear.add(new Pair(a,b));
					System.out.println(a + " will buy for " + b);
					// when pair has been found move that pair out temp array so it cant be picked again 
					String temp = buyFor[n1];
					buyFor[n1] = buyFor[p-1];
					buyFor[p-1]=temp;

					temp = buyTo[n2];
					buyTo[n2] = buyTo[p-1];
					buyTo[p-1]=temp;
					p = p -1;
				}
			}
		}


	}
     // this is the funtion that checks if the pairs picked are couples and returns a boolen 
	static boolean checkForCouples(String x, String y, String[][]a) 
	{
		for(int i=0; i<a.length; i++) // loop that checks if it macthes 
		{
			if((a[i][0].equals(x) && a[i][1].equals(y)) || (a[i][0].equals(y) && a[i][1].equals(x)))
			{
				return true; // returns boolen that can be used
			}
		}
		return false;
	}



	// this is the funtion that checks if the pairs picked were also picked last year eturns a boolen 
	static boolean checkForLastYear(ArrayList <Pair <String, String> > ly, Pair <String, String>  tyr)
{

 for(int i = 0; i < ly.size() -1; i ++){ // loop to check for last year match 
 {


  if(ly.get(i).equals(tyr)){

    return true; // return boolen to be used

  }
  
 }

}
 return false;
}

}