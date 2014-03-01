package cs240;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
public class RemoteDateImp1 extends UnicastRemoteObject implements RemoteDate
{
	public RemoteDateImp1()throws RemoteException {}
	public Date getDate() throws RemoteException {
		return new Date();
	}
	public static void main(String[] args) {
		try {
			RemoteDate dateServer = new RemoteDateImp1();
			Naming.rebind("DateServer", dateServer);
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}
}
