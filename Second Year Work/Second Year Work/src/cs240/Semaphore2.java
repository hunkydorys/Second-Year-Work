package cs240;

public class Semaphore2 {
	private int value;
	public Semaphore2(int value) {
		this.value = value;
	}
	public synchronized void p() {
		while (value == 0) {
			try {
				System.out.println("ChopStick in use");
				wait(); 
			} catch(InterruptedException e) {}
		}
		value = value - 1;
	}
	public synchronized void v() {
		value = value + 1;
		notify();
	}


}
