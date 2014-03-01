package cs210;
import java.util.Scanner;

public class MainLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		LinkedList mylist = new LinkedList();
		Scanner in = new Scanner(System.in);
        System.out.println("Enter a word to reverse");
        String word = in.next();
        for (int i=0; i<word.length(); i++)
        {
           Link test = new Link(word.charAt(i));
           mylist.push(test);
            
        }
        String c = "";
        while (!mylist.isEmpty())
        {
            
            c+=  mylist.pop().data;
            
            
        }
        System.out.println(c);
        if(c.equals(word))
        {
        	System.out.println("its a palindrome");
        	
        }
        else
        {
        	System.out.println("not a palindrome");
        }
		
		

	}

}
