package cs265;

public class Lab7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int result = 4;
		result =ComputeInsurance(true, false);
		System.out.println(result);
	}

	public static int ComputeInsurance(boolean sportsEquipment, boolean musicEquipment) {
		int insurance;
		if (sportsEquipment == true && musicEquipment == true)
			insurance = 20;
		else if ((sportsEquipment == true && musicEquipment == false)
				|| (sportsEquipment == false && musicEquipment == true))
			insurance = 10;
		else
			insurance = 5;
		return insurance;
	}

	public static String Grade(int exam, int course) {
		String result = "null";
		long average;
		average = Math.round((exam + course) / 2);
		if ((exam < 0) || (exam > 100) || (course < 0) || (course > 100))
			result = "Marks out of range";
		else {
			if ((exam < 50) || (course < 50)) {
				result = "Fail";
			} else if (exam < 60) {
				result = "Pass,C";
			} else if (average >= 70) {
				result = "Pass,A";
			} else {
				result = "Pass,B";
			}
		}
		return result;
	}

	public boolean CheckTheDate(int day, int month, int year) {
		boolean date = true;
		if ((year > 2400) || (year < 1600) || (month < 1) || (month > 12)
				|| (day < 1) || (day > 31))
			date = false;
		else if (((month == 4) || (month == 6) || (month == 9) || (month == 11))
				&& (day > 30))
			date = false;
		else if ((month == 2) && (day > 29))
			date = false;
		else if ((month == 2) && (day == 29)) {
			if ((year % 100 == 0 && year % 400 != 0)
					|| (year % 4 != 0 && year % 400 != 0))
				date = false;
		} else
			date = true;
		return date;
	}

	public static String CheckTriangleType(int side1, int side2, int side3) {
		String Tri = "";
		if ((side1 + side2) <= side3 || (side2 + side3) <= side1
				|| (side1 + side3) <= side2)
			Tri = "Not a Triangle";
		else 
		{
			if ((side1 == side2) && (side2 == side3))
				Tri = "Equilateral";
			else if (((side1 == side2) && (side2 != side3))
					|| ((side1 == side3) && (side3 != side2))
					|| ((side2 == side3) && (side3 != side1)))
				Tri = "Isosceles";
			else if (side1 != side2 && side1 != side3 && side2 != side3) 
			{
				Tri = "Scalene";
				int side1sqr = side1 * side1;
				int side2sqr = side2 * side2;
				int side3sqr = side3 * side3;
				if ((side1sqr + side2sqr == side3sqr)
						|| (side1sqr + side3sqr == side2sqr)
						|| (side2sqr + side3sqr == side1sqr))
					Tri = "Right angle Scalene";
			} else
				Tri = "There is an error";
		}
		return Tri;
	}

}
