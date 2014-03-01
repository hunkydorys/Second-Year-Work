package cs211;
import java.util.Stack;

public class Lab5 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{	
		CS211Reader reader = new CS211Reader();
		String[] contents = reader.load("dict");
		String longest ="";
		
		for(int i =0; i<contents.length; i++)
		{
			if(isPalindrome(contents[i]))
			{
				
				if(contents[i].length()>longest.length())
				{
					longest =contents[i];
					
				}
				
			}
			
		}
		System.out.println(longest);

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
				return false;			
		}
		
		/*Stack mystack= new Stack();
		for (int i=0; i<a.length(); i++)
        {
            mystack.push(a.charAt(i));
            
        }
        String c = "";
        while (!mystack.isEmpty())
        {
            
            c+=  mystack.pop();
            
            
        }
        
        if(c.equals(a))
        {
        	return true;
        	
        }
        else
        {
        	return false;
        }*/
		
		
		
	}

}
