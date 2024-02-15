package no.hvl.dat110.mqtt.brokerclient;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MQTTPubClient {
	
	private MqttClient publisherClient;
	
	
	public MQTTPubClient() {
		
	}
	
	public void publish(String temp) throws MqttPersistenceException, MqttException, InterruptedException {

		System.out.printf("Publishing on Topic %s: %s%n", Config.topic, temp);
		MqttMessage message = new MqttMessage(temp.getBytes());
		message.setQos(Config.qos);
		publisherClient.publish(Config.topic, message);
	}
	
	/**
	 * Call method to create a connection to the MQTT Broker
	 */
	public void connect() {

		MemoryPersistence persistence = new MemoryPersistence();

		try {
			publisherClient = new MqttClient(Config.broker, Config.pub_clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			System.out.println("MQTTPubClient Connecting to broker: " + Config.broker);
			publisherClient.connect(connOpts);
			System.out.println("MQTTPubClient Connected");

		} catch (MqttException e) {
			System.out.println("reason " + e.getReasonCode());
			System.out.println("msg " + e.getMessage());
			System.out.println("loc " + e.getLocalizedMessage());
			System.out.println("cause " + e.getCause());
			System.out.println("exception " + e);
			e.printStackTrace();
		}
	}
}
