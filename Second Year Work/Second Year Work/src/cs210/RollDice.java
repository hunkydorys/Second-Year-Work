package Cs210;
import java.util.Scanner;
public class RollDice
{
	public static void main (String args [])
	{
		
		Scanner scan = new Scanner(System.in);
		int num;
		String v= null;
		Dice d = new Dice();//creating new dice
		while (true )
		{
			System.out.println("  ");
			System.out.println("press enter");
			System.out.println("      ");
			v = scan.nextLine();
			if(v.equals(""))
			{

				num = d.Roll();
				System.out.println("your number is " + d.GetValue());


				if(d.IsHigh())
				{
					System.out.println("Roll is High");
				}
				else
				{
					System.out.println("Roll is Low");
				}
				if(d.IsEven())
				{
					System.out.println("Roll is Even");
				}
				else
				{
					System.out.println("Roll is Odd");
				}



			}
			if(!(v.equals("")))
			{
				break;
			}





		}

	}
}