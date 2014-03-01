package Cs210;

public class LotteryMonteCarlo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Set n to anything you want fool
		int n = 1000;
		boolean[] monteCarlo = new boolean[n];
		for (int in = 0; in < n; in++) {
			int[] lotteryDraw = new int[6];
			boolean[] lotto = new boolean[46];
			for (int i = 0; i < 6; i++) {

				lotteryDraw[i] = getRand(lotto);

			}

			monteCarlo[in] = isAdjacent(lotteryDraw);
		}
		for (int index = 0; index < monteCarlo.length; index++) {
			System.out.println(monteCarlo[index]);
		}
		System.out.println("You have " + getPercentage(monteCarlo)*100 + " % of getting  2 adjacent numbers from a draw in the Irish lottery" );		

	}

	public static int getRand(boolean[] array) {
		int rand = 1 + (int) (Math.random() * 45);
		for (int i = 0; i < array.length; i++)

		{

			if ((array[rand ] == false)) {
				array[rand ] = true;
				break;
			} else {
				rand = 1 + (int) (Math.random() * 45);
			}
		}

		return rand;
	}

	public static boolean isAdjacent(int[] array) {
		boolean is_Adjacent = false;
		quick_srt(array, 0, array.length - 1);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
			
		}
		System.out.println(" ");
		
		for (int i = 0; i < (array.length - 1); i++) {
			if (array[i]+1 == array[i + 1]) {
				is_Adjacent = true;
				break;
			}
		}
		return is_Adjacent;
	}

	public static void quick_srt(int array[], int low, int n) {
		int lo = low;
		int hi = n;
		if (lo >= n) {
			return;
		}
		int mid = array[(lo + hi) / 2];
		while (lo < hi) {
			while (lo < hi && array[lo] < mid) {
				lo++;
			}
			while (lo < hi && array[hi] > mid) {
				hi--;
			}
			if (lo < hi) {
				int T = array[lo];
				array[lo] = array[hi];
				array[hi] = T;
			}
		}
		if (hi < lo) {
			int T = hi;
			hi = lo;
			lo = T;
		}
		quick_srt(array, low, lo);
		quick_srt(array, lo == low ? lo + 1 : lo, n);
	}
	
	public static double getPercentage(boolean [] array)
	{
		
		double percen = 0;
		for(int i =0;i<array.length;i++)
		{
			if(array[i] == true)
			{
				percen ++;
			}
		}
		return (percen/array.length);
	}

}
 