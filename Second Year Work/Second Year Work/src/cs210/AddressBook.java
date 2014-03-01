package Cs210;
public class AddressBook{

      private String[] contacts = {"Alan", "Brendan", "Declan", "Fiona", "Garrath", "James", "John", "Karl", "Kate", "Louise", "Niall", "Olivia", "Paddy", "Rebecca", "Sarah", "Tony", "blank", "blank"};
      private int size = 16;
      private int arraySize = contacts.length;

      public AddressBook(){}//this constructor is completely blank – nothing happens when you create a new addressbook 

      public void insert(String name)
      {

            int j = 0;
            while(contacts[j].compareTo(name)<0 && j<size)
            {

                  j++;

            }
            int move = contacts.length-1;
            while(move >j)
            {
            	contacts[move] = contacts[move-1];
            	move--;
            }
            contacts[j-1] = name;


      }
      public void delete(String name)
      {
      	int j = 0;
      	while(contacts[j].compareTo(name) < 0 && j< size)
      	{
      		j++;
      	}
      	if(j==size)
      	{
      		System.out.print("what the hell, you can't delete " + name + "because it aint there" );
      	}
      	else
      	{
      		for(int k=j; k<size; k++)
      		{
      			contacts[k] = contacts[k+1];
      		}
      		size--;
      	}



      }
      public void biggerSize()
      {

      	String temp [] = new String[(contacts.length)*2];
      	for (int i = 0;i<arraySize; i++ )
      	{
      		temp[i]=contacts[i];
      	}
      	temp = contacts;
      	contacts = null;



      }



      public void display()
      	{
            System.out.println("");
            for(int j=0; j<size;j++){

                  System.out.print(contacts[j]+" ");


            }
            System.out.println("");
      }

      public boolean search(String name)
      {

		int j = 0;
		while(j<size)
		{
			int mid = (j+size)/2;//compute mid-point
			if(name.compareTo(contacts[mid])<0)//repeat search in bottom half
			{
				size= mid;
			}
			else if(name.compareTo(contacts[mid])>0)// repeat search in top half
			{
				j= mid+1;
			}
			else
			{
				return true;//found it
			}

		}
		return false;// couldn't find it



      }
}