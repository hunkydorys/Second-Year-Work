package cs240;

public class SemaphoreRoom {
	private int value;
	public SemaphoreRoom(int value) {
		this.value = value;
	}
	public synchronized void enter() {
		while (value == 0) {
			try {
				System.out.println("room is  full");
				wait(); 
			} catch(InterruptedException e) {}
		}
		value = value - 1;
	}
	public synchronized void leave() {
		value = value + 1;
		notify();
	}

}
