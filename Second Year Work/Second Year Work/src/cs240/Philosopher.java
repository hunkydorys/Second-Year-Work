package cs240;

public class Philosopher extends Thread {
	private int myName;
	private Semaphore2 chopSticks[];
	private SemaphoreRoom room;
	
	public Philosopher(int myName, Semaphore2 chopSticks[],SemaphoreRoom room) {
		this.myName = myName; 
		this.chopSticks = chopSticks;
		this.room=room;
		
	}

	public void run() {
		while (true) {
			System.out.println("Philosopher "+myName+" thinking.");
			try {
				sleep ((int)(Math.random()*20000));
			} catch (InterruptedException e) {}
			System.out.println("Philosopher "+myName+" hungry.");
			
				room.enter();
				chopSticks[myName].p();
				chopSticks[(myName+1)%5].p();
				System.out.println("Philosopher " +myName+" is eating");
			
			
			
			/*else
			{
				chopSticks[(myName+1)%5].v();
				chopSticks[(myName)].v();
				System.out.println("Philosopher " +myName+" is eating");
			}*/
		
			
			try {
				sleep ((int)(Math.random()*10000));
			} catch (InterruptedException e) {}
			chopSticks[myName].v();
			chopSticks[(myName+1)%5].v();
			room.leave();
			/*if(myName%5==1){
			chopSticks[myName].v();
		}*/
			}
	}
		}
	




