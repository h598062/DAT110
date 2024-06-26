package no.hvl.dat110.rpcinterface;

/**
 * dat110: DS Lab2
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TempSensorInterface extends Remote {

	int SERVER_PORT = 9091;

	String REMOTE_IFACE_NAME = "TempSensorInterface";

	// define the methods that should be remotely invoked here

	int getTemperature()
	throws RemoteException;

	void setTemperature(int tmp)
	throws RemoteException;
}
