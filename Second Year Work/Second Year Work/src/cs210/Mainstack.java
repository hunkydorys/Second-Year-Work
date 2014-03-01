package cs210;
import java.util.Scanner;

public class Mainstack 
{
	 public static void main (String[] args){
         Stack mystack = new Stack(20);
         Scanner in = new Scanner(System.in);
         System.out.println("Enter a word to reverse");
         String word = in.next();
         for (int i=0; i<word.length(); i++)
         {
             mystack.push(word.charAt(i));
             
         }
         String c = "";
         while (!mystack.isEmpty())
         {
             
             c+=  mystack.pop();
             
             
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
