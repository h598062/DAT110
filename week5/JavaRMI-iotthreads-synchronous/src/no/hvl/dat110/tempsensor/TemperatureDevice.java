package no.hvl.dat110.tempsensor;


import no.hvl.dat110.rpcinterface.TempSensorInterface;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Locale;

public class TemperatureDevice extends Thread {

	private TemperatureSensor sn;
	
	public TemperatureDevice() {
		this.sn = new TemperatureSensor();
	}
	
	public void run() {
		
		System.out.println("temperature device started");
		
		// TODO
		try {
			// Get a reference to the registry using the port
			Registry registry = LocateRegistry.getRegistry(9091);

			// Look up the registry for the remote object (TempSensorInterface) using the name TempSensorInterface.REMOTE_IFACE_NAME
			TempSensorInterface tsi = (TempSensorInterface)registry.lookup(TempSensorInterface.REMOTE_IFACE_NAME);

			// loop 10 times and read the temp value from the TemperatureSensor each time
			for (int i = 0; i < 10; i++) {
				int tmp = sn.read();
				// set the temperature value by calling the setTemperature remote method via the object of TempSensorInterface
				tsi.setTemperature(tmp);
				Thread.sleep(100);
			}


		} catch (RemoteException | NotBoundException | InterruptedException e) {
			throw new RuntimeException(e);
		}

		
		//throw new RuntimeException("RPC TemperatureDevice Client not yet implemented...");
		
	}
}
