package cs211;// Myles cullen  10347613 anagram was dragafuse and the answer was safeguard
// there was a better way of doing this i just didnt have time where is use regex then i use a counter to count the number of instances of the 'a'  character

public class Crossword {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		CS211Reader reader = new CS211Reader();
		String[] contents = reader.load("dict");
		
		
		
		for(int i = 0; i< contents.length; i++)//loop to find 
		{
			
			if(contents[i].matches("^[dragafuse]{9}"))// use regex statement  to refine the search
			{
				if(contents[i].contains("s")&& contents[i].contains("a") && contents[i].contains("d")&& contents[i].contains("r") && contents[i].contains("g")&& contents[i].contains("f") && contents[i].contains("u")&& contents[i].contains("e") )// use the 
				{
					System.out.println(contents[i]);
				}
				
			}
			
		
		
		}
		
		
	}}