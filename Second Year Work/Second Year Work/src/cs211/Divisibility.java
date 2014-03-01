package cs211;//10347613 myles cullen answer is 2520

public class Divisibility {
	public static void main(String[] args)
	{
	
		for(int i =0; i<10000;i+=5)//loop from 0 to 10000, incremented by 5 because the number has to be divisible by 5 
		{
			if(i%6==0 && i%7==0 && i%8==0 && i%9==0)// only needs to be divisible be these numbers because all numbers below them are covered by these numbers 
			{
				System.out.println(i);// prints out all the numbers between 0 and 10,000 that are divisble by the numbers 1-9 
				
			}
		}
		


}


}
