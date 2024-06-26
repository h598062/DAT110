package no.hvl.dat110.rpcserver;

import no.hvl.dat110.rpcinterface.TempSensorInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * For demonstration purpose in dat110 course
 */

public class TempSensorImpl extends UnicastRemoteObject implements TempSensorInterface {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int temprature = 0;

	public TempSensorImpl()
	throws RemoteException {
		super();
	}

	// implement the remote methods defined in the interface here

	@Override
	public int getTemperature()
	throws RemoteException {
		return temprature;
	}

	@Override
	public void setTemperature(int tmp)
	throws RemoteException {
		temprature = tmp;
	}

}
