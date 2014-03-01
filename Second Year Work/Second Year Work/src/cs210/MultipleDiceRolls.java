package Cs210;
/*Author Myles Cullen
 *Lab4 Cs220
 *
 *
 */
public class MultipleDiceRolls
{
	public static void main(String args[])
	{

		int num, num1,num2, num3, num4, result ;//declaring the 6 integers needed
		int dataArray [] = {5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};// array of all the numbers that can be rolled by the 5 die
		int lib [] = new int[26];// array which holds the value of the amount of times each number is rolled


		Dice [] test = new Dice[5];//declaring an array
		for(int i = 0;i<test.length;i++)//filling the array with Dice objects
		{
			test[i]= new Dice();

		}
		for (int i = 0;i <1000000; i++)
		{
			num = test[0].Roll();// Rolling the die
			num1 = test[1].Roll();
			num2 = test[2].Roll();
			num3 = test[3].Roll();
			num4 = test[4].Roll();
			result =num+num1+num2+num3+num4;//adding up all the rolls to give the total
			/*
			for(int j =0; j<dataArray.length;j++)
			{
				if(result==dataArray[j])
				{
					lib[j]= lib[j]+1;
				}
			}
			*/
			lib[result - 5] ++;// increasing the index of the rolled number


		}
		int tote=0;
		for (int i=0;i<lib.length;i++)//Loop printing out the how many times each number is rolled
		{
			System.out.println(dataArray[i] + " is rolled " + lib[i] + " times");
			tote = tote +lib[i];
		}
		System.out.println("total number of rolls is " + tote);//print out total number of rolls
	}
}