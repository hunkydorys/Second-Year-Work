package cs210;
import java.util.Scanner;


public class Queueapp 
{
	public static void main (String[] args){
        Queue myqueue = new Queue(5);
        Scanner in = new Scanner(System.in);
        String command = "";
        while(!command.equals("quit"))
        {
           System.out.println();
           System.out.println("Do you want to insert, remove, getsize,  or quit?");
           command = in.next();
           if(command.equals("insert"))
           {
                 System.out.println("Enter name to insert");
                 String name = in.next();
                 myqueue.insert(name);
                 System.out.println(name+" has been inserted into the queue");
           }
           else if(command.equals("remove"))
           {
                 System.out.println(myqueue.remove()+ " has been removed from the queue");
           }
           else if(command.equals("getsize"))
           {
                 System.out.println("The size of the queue is "+myqueue.getSize());
           }
           
           myqueue.printout();
           
           
        }
        
    }


}
