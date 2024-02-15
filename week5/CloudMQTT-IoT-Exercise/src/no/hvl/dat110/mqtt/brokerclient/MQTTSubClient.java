package no.hvl.dat110.mqtt.brokerclient;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


public class MQTTSubClient implements MqttCallback {

	
	public MQTTSubClient() throws MqttException {

		MqttConnectOptions connOpts = new MqttConnectOptions();
		connOpts.setCleanSession(true);

		System.out.printf("MQTTSubClient Connecting to broker: %s%n", Config.broker);

		MqttClient client = new MqttClient(Config.broker, Config.sub_clientId, new MemoryPersistence());
		client.setCallback(this);
		client.connect(connOpts);
		System.out.println("MQTTSubClient Connected");

		client.subscribe(Config.topic, Config.qos);
		System.out.printf("Subscribed to Topic: %s%n", Config.topic);
	}
	
	
	@Override
	public void connectionLost(Throwable cause) {
		System.out.println("Connection lost because: " + cause);
		System.exit(1);
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception{
		
		// TODO: get the message payload 	
		// Hint: messageArrived method is a callback function that is called from the MQTT broker
		// print out the temp (See the MQTTSubTest)
		System.out.printf("The Temperature is: %s%n", new String(message.getPayload()));

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// 
		
	}

}
