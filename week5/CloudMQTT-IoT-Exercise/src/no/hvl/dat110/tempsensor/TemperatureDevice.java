package no.hvl.dat110.tempsensor;


import no.hvl.dat110.mqtt.brokerclient.MQTTPubClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class TemperatureDevice extends Thread {

	private TemperatureSensor sn;
	
	public TemperatureDevice() {
		this.sn = new TemperatureSensor();
	}

	@Override
	public void run() {
		
		System.out.println("temperature device started");

		//call MQTTPubClient (create a new instance) and make connection
		MQTTPubClient client = new MQTTPubClient();
		client.connect();
		// loop 10 times to read temp values			
		for (int i = 0; i < 10; i++) {
			// read the temp from the TemperatureSensor
			int temp = sn.read();
			// use the MQTTPubClient instance object to publish the temp to the MQTT Broker
			try {
				client.publish("" + temp);
			} catch (MqttException | InterruptedException e) {
				throw new RuntimeException(e);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		//throw new RuntimeException("TemperatureDevice Client Not yet implemented...");
		
	}
	
}
