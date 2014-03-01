package cs240;

public class reader extends Thread{
	
	private int id;
	private Datalock datalock;
	public reader(int id, Datalock datalock)
	{
		this.id=id;
		this.datalock=datalock;
	}
	
	public void run()
	{
		while(true)
		{
			
			System.out.println("i am waiting to read " + id);
			try {
				sleep ((int)(Math.random()*2000));
			} catch (InterruptedException e) {}
			
			datalock.acquireReadLock();
			System.out.println("look i am reading " + id);
			
			
			
			try {
				sleep ((int)(Math.random()*1000));
			} catch (InterruptedException e) {}
			datalock.releaseReadLock();
			System.out.println("i am not reading anymore " + id);
			try {
				sleep ((int)(Math.random()*1000));
			} catch (InterruptedException e) {}
		}
	}

}
