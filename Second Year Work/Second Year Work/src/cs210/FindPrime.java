package cs210;
import java.util.Scanner;

public class FindPrime {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println("please enter prime to find:");
		Scanner scan = new Scanner(System.in);
		int nth = scan.nextInt();
		
		double len = (Math.log(nth))*2 *nth;
		long start = System.currentTimeMillis();
		int actlen = (int)(len);
		boolean [] myArray = new boolean[actlen];
		for(int i = 0; i<myArray.length;i++)// setting all values to true
		{
			myArray[i]= true;
		}
		int divisor=2;
		boolean istrue = false;
		int limit = (int) Math.sqrt(len);
		while(divisor<limit)//
		{
			for(int j = divisor; j<myArray.length ; j++ )//setting all multiples of primes to false
			{
				if((j+1)%divisor==0)
				{
					myArray[j] = false;
				}
			}
			while(istrue == false)//skipping over numbers which are already set to false(not prime)
			{
				divisor++;
				if(myArray[divisor-1]==true)
				{
					istrue= true;
				}
			}
			istrue = false;
			
		}
		int counter =0;
		int ind= 0;
		for(int z = 1; z<myArray.length; z++)//printing out all primes
		{
			if(myArray[z]==true)
			{
				counter++;
				if(nth ==counter)
				{
					ind= z;
					break;
				}
			}
		}
		System.out.println("the " + nth + "th prime number is " + ind+1);
		
		
		long elapsed = System.currentTimeMillis() - start;
		System.out.println("The answer took " + elapsed + " milliseconds to compute");
		

	}

}
