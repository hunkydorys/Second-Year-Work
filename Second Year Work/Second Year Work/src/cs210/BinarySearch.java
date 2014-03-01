package cs210;

import java.util.Scanner;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter a number for the range?");
		int range = scan.nextInt();
		System.out.println("Ok, pick a random number between 1 and " + range
				+ ". Are you ready?");
		int i = 1;
		int mid;
		String guess;
		int counter=0;
		while (i < range) {
			mid = (range+ i) / 2;
			System.out.println("My guess is " + mid);
			guess = scan.next();
			if (guess.compareToIgnoreCase("lower") == 0) {
				range = mid;
				counter++;
			}

			if (guess.compareToIgnoreCase("higher") == 0) {
				i = mid +1;
				counter++;
			}
			if (guess.compareToIgnoreCase("correct") == 0) {
				counter++;
				System.out.println("I got it in " + counter + " guesses");
			}

		}

	}

}
