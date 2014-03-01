package cs210;

public class Queue {
	private String[] array;
	private int size;
	private int front;
	private int rear;
	private int nItems;

	public Queue(int sizein) {
		size = sizein;
		array = new String[size];
		front = 0;
		rear = -1;
		nItems = 0;

	}

	public boolean insert(String name) {
		if (isFull())
			return false;
		if (rear == size - 1) {
			rear = -1;
		}
		rear++;
		array[rear] = name;
		nItems++;
		return true;

	}

	public String remove() {
		if (isEmpty())
			return "theres nothing in here idiot ";
		String temp = array[front];
		front++;
		if (front == size) {
			front = 0;

		}
		nItems--;
		return temp;

	}

	public boolean isFull() {
		if (nItems == size)
			return true;
		else
			return false;
	}

	public boolean isEmpty() {
		if (nItems == 0)
			return true;
		else
			return false;
	}

	public String peek() {
		if (nItems == 0)
			return "null";
		return array[front];

	}

	public int getSize() {
		return nItems;
	}

	public void printout() 
	{
		 
		for (int i = front; i <= rear; i++) 
		{
			System.out.println(array[i]);
		}

		
		
	}

}
