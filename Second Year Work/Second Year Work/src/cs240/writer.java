package cs240;


public class writer extends Thread {
	
	private Datalock datalock;
	private int id;
	public writer(int id,Datalock datalock)
	{
		this.id=id;
		this.datalock=datalock;
	}
	
	public void run()
	{
		while(true)
		{
			
			System.out.println("i am waiting to write " + id);
			try {
				sleep ((int)(Math.random()*2000));
			} catch (InterruptedException e) {}
			datalock.acquireWriteLock();
			System.out.println("look i am writing " + id);
			
			try {
				sleep ((int)(Math.random()*1000));
			} catch (InterruptedException e) {}
			
			System.out.println(" i am not writing anymore " + id);
			datalock.releaseWriteLock();
		}
	}
	

}
