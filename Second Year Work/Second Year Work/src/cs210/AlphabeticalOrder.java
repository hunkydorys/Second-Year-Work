package Cs210;
import java.util.Scanner;

public class AlphabeticalOrder
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);

		String order[] = {"first", "second", "third"};
		String words[] = {"", "", ""};

		for(int i = 0; i < 3; i ++)
		{
			System.out.println("Please enter your " + order[i] + " word: ");
			words[i] = scan.nextLine();
		}
		String word1 = words[0];
		String word2 = words[1];
		String word3 = words[2];

		System.out.println();
		System.out.println("The three words in alphabetical order are: ");

		if(word1.compareTo(word2) <= 0 && word1.compareTo(word3) <= 0 && word2.compareTo(word3) <= 0)
		{
			// First
			System.out.println(word1);
			System.out.println(word2);
			System.out.println(word3);
		}
		if(word1.compareTo(word2) > 0 && word1.compareTo(word3) <= 0 && word2.compareTo(word3) <= 0)
		{
			// Second
			System.out.println(word2);
			System.out.println(word1);
			System.out.println(word3);
		}
		if(word1.compareTo(word2) <= 0 && word1.compareTo(word3) <= 0 && word2.compareTo(word3) > 0)
		{
			// Third
			System.out.println(word1);
			System.out.println(word3);
			System.out.println(word2);
		}
		if(word1.compareTo(word2) > 0 && word1.compareTo(word3) > 0 && word2.compareTo(word3) <= 0)
		{
			// Fourth
			System.out.println(word2);
			System.out.println(word3);
			System.out.println(word1);
		}
		if(word1.compareTo(word2) <= 0 && word1.compareTo(word3) > 0 && word2.compareTo(word3) > 0)
		{
			// Fifth
			System.out.println(word3);
			System.out.println(word1);
			System.out.println(word2);
		}
		if(word1.compareTo(word2) > 0 && word1.compareTo(word3) > 0 && word2.compareTo(word3) > 0)
		{
			// Sixth
			System.out.println(word3);
			System.out.println(word2);
			System.out.println(word1);
		}

	}
}