package cs240;

public class RWSimulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		writer [] write=new writer[5];
		reader [] read = new reader[5];
		
		
		
		Datalock data = new Datalock();
		
		for(int i=0;i<5;i++)
		{
			read[i]= new reader(i,data);
			read[i].start();
			write[i]=new writer(i,data);
			write[i].start();
			
		}
		
		
		

	}

}
