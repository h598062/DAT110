package no.hvl.dat110.rpcinterface;

/**
 * dat110: DS Lab2
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TempSensorInterface extends Remote {
	
	public static final int SERVER_PORT = 9091;
	
	public static final String REMOTE_IFACE_NAME = "TempSensorInterface";
	
	// TODO
	// define the methods that should be remotely invoked here

	int getTemperature() throws RemoteException;

	void setTemperature(int tmp) throws RemoteException;
}
