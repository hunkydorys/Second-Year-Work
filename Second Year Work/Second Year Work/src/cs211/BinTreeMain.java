package cs211;
import java.util.Scanner;

public class BinTreeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		BinTree mytree = new BinTree();
		
		int i = 0;
		
		while(true)
		{
			System.out.println("What would you like to do?");
			System.out.println(" insert \n delete \n search \n print \n max \n min \n quit ");
			String in = scan.nextLine();
			
			if(in.compareToIgnoreCase("quit")==0)
	        {
	        	System.out.println("you have quit");
	        	break;
	        }
			else if(in.compareToIgnoreCase("insert")==0)
	        {
	        	System.out.println("What number would you like to insert?");
	        	i = scan.nextInt();
	        	scan.nextLine();
	        	Node newNode  = new Node(i);
	    		mytree.insert(newNode);
	    		System.out.println(i +" has been inserted");
	        }
	        /*else if(in.compareToIgnoreCase("delete")==0)
	        {
	        	System.out.println("What number would you like to delete?");
	        	
	        	
	        }*/
	        else if(in.compareToIgnoreCase("search")==0)
	        {
	        	System.out.println("What number would you like to search for?");
	        	int j = scan.nextInt();
	        	scan.nextLine();
	        	System.out.println(j + "'s status is " + mytree.find(j));
	        }
	        else if(in.compareToIgnoreCase("print")==0)
	        {
	        	mytree.printInOrder(mytree.root);
	        }
	        else if(in.compareToIgnoreCase("max")==0)
	        {
	        	
	        	int max = mytree.getValue(mytree.maximum());
	        	System.out.println("he maximum value is " +max);
	        }
	        else if(in.compareToIgnoreCase("min")==0)
	        {
	        	int min = mytree.getValue(mytree.minimum());
	        	
	        	System.out.println("the minimum value is "+ min);
	        }
	        
	        
			
		}
		
		
		
		

	}

}
