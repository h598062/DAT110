package no.hvl.dat110.display;


import no.hvl.dat110.rpcinterface.TempSensorInterface;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DisplayDevice extends Thread {
		
	
	public void run() {
		
		System.out.println("Display started...");	
		
		// TODO
		try {
			// Get a reference to the registry using the port
			Registry registry = LocateRegistry.getRegistry(9091);
			// Look up the registry for the remote object (TempSensorInterface) using the name TempSensorInterface.REMOTE_IFACE_NAME
			TempSensorInterface tsi = (TempSensorInterface) registry.lookup(TempSensorInterface.REMOTE_IFACE_NAME);
			// loop 10 times and read the temp value from the TemperatureSensor each time
			for (int i = 0; i < 10; i++) {
				// get the temperature value by calling the getTemperature remote method via the object of TempSensorInterface
				// print the temperature value to console
				int tmp = tsi.getTemperature();
				System.out.printf("Temperatur: %d%n", tmp);
				Thread.sleep(100);
			}

		} catch (RemoteException | NotBoundException | InterruptedException e) {
			throw new RuntimeException(e);
		}


		//throw new RuntimeException("RPC DisplayDevice Client Not yet implemented...");
		
	}
}
