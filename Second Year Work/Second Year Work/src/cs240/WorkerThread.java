package cs240;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WorkerThread extends Thread 
{
	
	
	private ServerSocket sock;
	public WorkerThread(int id,ServerSocket sock)
	{
		
		this.sock=sock;
	}
	public void run()
	{
		try{
			
			while(true)
			{
				Socket client = sock.accept();
				PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
				pout.println(new java.util.Date().toString());
				client.close();
			}
			
		}
		catch (IOException ioe)
		{
			System.err.println(ioe);
		}
	}

}
