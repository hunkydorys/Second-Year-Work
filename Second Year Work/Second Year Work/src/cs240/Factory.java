package cs240;

public class Factory {
	public static void main (String args[]) {
	Buffer buffer = new Buffer();
	// Create one producer and one consumer process
	Thread producer = new Thread(new Producer(buffer,1));
	Thread producer1 = new Thread(new Producer(buffer,2));
	Thread producer2 = new Thread(new Producer(buffer,3));
	Thread producer3 = new Thread(new Producer(buffer,4));
	Thread producer4 = new Thread(new Producer(buffer,5));
	Thread consumer = new Thread(new Consumer(buffer,1));
	Thread consumer1 = new Thread(new Consumer(buffer,2));
	Thread consumer2 = new Thread(new Consumer(buffer,3));
	Thread consumer3 = new Thread(new Consumer(buffer,4));
	Thread consumer4 = new Thread(new Consumer(buffer,5));
	
	producer.start();
	consumer.start();
	producer1.start();
	consumer1.start();
	producer2.start();
	consumer2.start();
	producer3.start();
	consumer3.start();
	producer4.start();
	consumer4.start();
	
	
	}
	}
