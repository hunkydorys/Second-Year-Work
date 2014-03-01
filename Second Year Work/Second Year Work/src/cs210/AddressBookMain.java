package Cs210;
import java.util.Scanner;

public class AddressBookMain
{

    public static void main (String[] args)
    	{
           AddressBook mybook = new AddressBook();
           Scanner scan = new Scanner(System.in);
           mybook.display();
           /*System.out.println("Enter a name to enter");
           String name = in.next();
           mybook.insert(name);
           mybook.display();
           System.out.println("Enter a name to delete");
           name = in.next();
           mybook.delete(name);
           mybook.display();
           System.out.println("Enter a name to search for");
           name = in.next();
           if(mybook.search(name)){
                System.out.println(name+" is in the addressbook");
            }else{
                System.out.println(name+" is not in the addressbook");
            */

            String name = " ";
            boolean quit = false;
            char option = 'q';
            do{
            	System.out.println("Do you want to?");
            	System.out.println("Quit   (q)");
            	System.out.println("Insert (i)");
            	System.out.println("Delete (d)");
            	System.out.println("Search (s)");
            	String toChar =scan.nextLine();
            	option = toChar.charAt(0);
            	switch (option)
            	{
            		case 'q':
            			quit = true;
            			break;
            		case 'i':
            			System.out.println("Enter a name to insert");
            			name = scan.nextLine();
            			mybook.insert(name);
            			break;
            		case 'd':
            			System.out.println("Enter a name to delete");
            			name = scan.nextLine();
            			mybook.delete(name);
            			break;
            		case 's':
            			System.out.println("Enter a name to Search ");
            			name= scan.nextLine();
            			mybook.search(name);
            			break;




            	}
            	mybook.display();
            }while(quit==false);




           }
    }
