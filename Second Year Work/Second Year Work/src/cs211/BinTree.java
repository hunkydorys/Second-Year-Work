package cs211;

public class BinTree 
{	
	public  Node root;
	public BinTree(Node node)
	{
		root=node;
	}
	public BinTree()
	{
		root=null;
	}
	public int getValue(Node node)
	{
		return node.value;
	}


	public void insert( Node newNode) 
	{
		
		Node parent = null;
		Node current = root;
		if(root==null)
			root = newNode;
		else
		{
			
			
			while(true)
			{
				parent = current;
				if(newNode.value < current.value) // go left?
				{
					current = current.left;
					if(current == null) // if end of the line,
					{
						// insert on left
						parent.left = newNode;
						
						return;
					}
				} // end if go left
				else
					// or go right?
				{
					current = current.right;
					if(current == null) // if end of the line
					{
						// insert on right
						parent.right = newNode;
						
						return;
					}
				} // end else go rig

			}

		}


	}

	public void printInOrder(Node node) 
	{
		
		if (node != null) 
		{
			
			printInOrder(node.left);
			System.out.println("  Traversed " + node.value);
			printInOrder(node.right);
		}
	}
	
	public Node minimum()
	{
		Node current;
		Node last = null;
		current = root;
		while(current!=null)
		{
			last=current;
			current=current.left;
		}
		return last;
	}
	public Node maximum()
	{
		Node current;
		Node last = null;
		current =root;
		while(current!=null)
		{
			last=current;
			current=current.right;
		}
		return last;
	}


	public boolean find(int key){
		Node current = root; //start at the root
		while(current.value != key && current.value !=key)
		{ //while no match
			if(key < current.value)
			{//go left?
				current=current.left;
			}
			else{
				current=current.right ;//or go right?
			}
			
		}
		
		if(current != null && current.value == key)
		{
			return true;
		}
		else{
			return false;
		}
	}
}