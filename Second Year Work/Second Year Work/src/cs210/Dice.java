package Cs210;
import java.util.Random;

public class Dice
{


	private int number;

	public Dice()//creating a dice object
	{


        number = 0;
	}

	public int Roll()//roll method
	{
		Random r;
		r = new Random();
		number = r.nextInt(6)+1;
		return number;
	}

	public  int GetValue()//
	{
		return number;

	}
	public  boolean IsHigh()//checks whether the number is high or low
	{
		if(number >=4)
		{
		  return true;
		}
		else
		{
			return false;
		}

	}
	public  boolean IsEven()//checks whether the number is odd or even
	{
		if(number%2==0)
		{
		    return true;
		}
		else
		{
			return false;
		}

	}




}
