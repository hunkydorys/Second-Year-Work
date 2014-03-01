package cs240;
import java.util.Date;

public class Consumer implements Runnable{
	private Buffer buffer;
	private int id;
	public Consumer (Buffer buffer, int id) {
		this.buffer = buffer;
		this.id=id;
	}
	public void run() {
		Date message;
		while (true) {
			try {
				//System.out.println("i am consuming this " + id );
				//Thread.sleep(1000); // Sleep for 1000 ms
				message = (Date) buffer.remove();
				System.out.println("consumer id: " + id +" and the date is "+ message);
				Thread.sleep(1000);
			} catch (InterruptedException e){}
				
			
			
			
			
		}
		
	}


}
