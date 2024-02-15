package no.hvl.dat110.display;


import no.hvl.dat110.mqtt.brokerclient.MQTTSubClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class DisplayDevice extends Thread {


	@Override
	public void run() {
		
		System.out.println("Display started");	

		try {
			// Make a new instance of MQTTSubClient
			MQTTSubClient client = new MQTTSubClient();
			// use the sub instance to get the temperature
			client.messageArrived("", new MqttMessage());
			// Do the display in the MQTTSubClient
		} catch (Exception e) {
			throw new RuntimeException(e);
		}


		
		//throw new RuntimeException("DisplayDevice Client Not yet implemented...");
		
	}

}
