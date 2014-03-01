package cs240;
import java.util.Date;

public class Producer implements Runnable {
	private Buffer buffer;
	private int id;
	public Producer(Buffer buffer, int id){
		this.buffer = buffer;
		this.id=id;
		
	}
	public void run() {
		Date message;
		while (true) {
			message = new Date(); // produce an item
			try {
				System.out.println("product id: "+id +  " and the date is  " + message);
				Thread.sleep(1000); // Sleep for 1000 ms
			} catch (InterruptedException e){}
			buffer.insert(message);
		}
	}


}
