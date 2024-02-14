package no.hvl.dat110.rpcserver;

import no.hvl.dat110.rpcinterface.TempSensorInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * dat110: DS Lab 2
 */


public class TempRPCServer {

	public static void main(String[] args) {

		TempRPCServer server = new TempRPCServer();
		server.start();
	}

	public void start() {

		try {
			// create registry and start it on a port (e.g. 9091)}
			Registry registry = LocateRegistry.createRegistry(TempSensorInterface.SERVER_PORT);

			// Make a new instance (stub) of the implementation class
			TempSensorInterface tsi = new TempSensorImpl();

			// Bind the remote object (stub) in the registry using the name TempSensorInterface.REMOTE_IFACE_NAME
			registry.bind(TempSensorInterface.REMOTE_IFACE_NAME, tsi);

			System.out.println("Startet server...");

		} catch (Exception e) {
			System.err.println("Temp RPCServer: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
