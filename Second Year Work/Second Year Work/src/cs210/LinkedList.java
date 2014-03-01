package cs210;

public class LinkedList 
{
	private Link first;
	public LinkedList()
	{
		first = null;
		
	}
	
	
	public void push(Link newLink)
	{
		newLink.next = first;
		first = newLink;
		
	}
	
	public Link pop( )
	{
		Link current = first;
		first=current.next;
		return current;
		
	}
	public boolean isEmpty()
	{
		return (first==null);
	}
	
	
	
}
