package com.rabbitmq.RabbitApp;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer1 {

	private final static String QUEUE_NAME = "kolaparthi";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		String message = null;
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		for (int a = 0; a < 500; a++) {
			message = "Test1" + a;
			channel.basicPublish("", QUEUE_NAME, null,
					message.getBytes("UTF-8"));
		}
		System.out.println(" [x] Sent '" + message + "'");

		channel.close();
		connection.close();
	}
}