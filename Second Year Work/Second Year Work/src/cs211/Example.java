package cs211;

public class Example 
{
	public static void main(String[] args){
		//instantiate an instance of CS211Reader
		CS211Reader reader = new CS211Reader();
		//the code below shows how to load a file
		String[] contents = reader.load("numbers.txt");//i did this in eclipse in ubuntu so the file directory was different because i imported the file into eclipse 
		//now you can process the contents as a String array
		double min = Double.parseDouble(contents[0]);//initialising the minimum as the first element in the array
		double max = min;//initialising the maximum as the first element in the array
		double num;//creating the  variable to keep track of the elements in the array 
		
		for (int i = 0; i< contents.length; i++)//loop to find the minimum
		{
			
			
			num = Double.parseDouble(contents[i]);//converting the string to a double
			
			if(num<min)// if the number is less than the minimum then it is the new minimum
			{
				min = num;
			}
			if(num>max)//if the number is greater than the maximum then it is the new maximum
			{
				max = num;
			}
		
		
		}
		
		System.out.println("the max is " + max);//printing 
		System.out.println("the samllest is " + min);
		//the code below demonstrates how to save a file
		try{
		reader.save("numbers2.txt", contents);
		}catch(Exception e){}
		}


}
