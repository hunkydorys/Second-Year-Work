package cs211;

public class Lab2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		CS211Reader reader = new CS211Reader();
		String[] contents = reader.load("numbers2");
		int len = contents.length;
		double num;
		Double [] contents1= new Double[len];
		for (int i=0; i<contents1.length; i++)
		{
			contents1[i] =Double.parseDouble(contents[i]);
		}
		
		
		
		for (int outer = 1; outer < contents1.length; outer++) 
		{
			double temp = contents1[outer]; //back it up
			int inner = outer; // inner used to track shifts
			while (inner > 0 && contents1[inner - 1] >= temp) 
			{

				contents1[inner] = contents1[inner - 1];// swap
				inner--;
			
			}
			//shift them all right until one is smaller
			contents1[inner] = temp;

		}
		double diff=contents1[1]-contents1[0];
		double num1;
		double num2;
		int index=1;
		double currentdiff;
		
		for (int i = 2;i<contents1.length;i++)
		{
			num1=contents1[i-1];
			num2 =contents1[i];
			currentdiff=num2-num1;
			if(currentdiff<diff)
			{
				diff= currentdiff;
				index =i;
			}
			
		}
		System.out.println("these are the 2 numbers");
		System.out.println(contents1[index-1]);
		System.out.println(contents1[index]);
		
		
		
		
		
		
		try{
			reader.save("numbers2.txt", contents);
			}catch(Exception e){}
			

	}
	
	
	

}
