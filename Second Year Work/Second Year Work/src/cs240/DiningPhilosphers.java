package cs240;

public class DiningPhilosphers {
	public static void main(String args[]) {
		Semaphore2 chopSticks[];
		Philosopher woman[];
		SemaphoreRoom room;
		room= new SemaphoreRoom(4);
		
		// Create an array of five Semaphore Object Reference Handles
		chopSticks = new Semaphore2[5];
		
		// Create five Semaphore Objects and assign to the array
		for (int i=0; i<5; i++){
			chopSticks[i] = new Semaphore2(1); 
		}
		
			woman = new Philosopher[5];
		// Create and initiate five Philosopher Thread Objects
		for (int i=0; i<5; i++) {
			woman[i] = new Philosopher(i, chopSticks,room);
			woman[i].start();
		}
	}


}
