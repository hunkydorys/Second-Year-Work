package Cs210;
import java.util.Scanner;

public class PalindromeRecursion 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner (System.in);
		System.out.println("please enter a string");
		String pal = scan.nextLine();
		boolean result; 
		result = isPalindrome(pal);
		System.out.println(result);
	}
	public static boolean isPalindrome(String a)
	{
		if(a.length()<2)
		{
			return true;
		}
		else
		{
			if(a.charAt(0)==a.charAt(a.length()-1)) 
			{	
				return isPalindrome(a.substring(1,a.length()-1));
			}
			else
			{
				return false;
			}
		}
		
	}
	public static int triangularNumber(int n)
	{
		int nth =0;
		if(n==1)
		{
			return 1;
		}
		else{
			
		return triangularNumber(nth)
		}
	
	    return nth;
	}
	
	

}
