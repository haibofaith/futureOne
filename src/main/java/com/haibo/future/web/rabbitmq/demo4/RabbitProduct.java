package com.haibo.future.web.rabbitmq.demo4;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class RabbitProduct {
    private final static String QUEUE_NAME = "hello4";

    public static void main(String[] argv) throws Exception {
        for (int i = 0; i < 20; i++) {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            //1、队列持久化
            boolean durable = true;
            channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
            String message = "第"+i+"条"+"Hello World!";
            //MessageProperties.PERSISTENT_TEXT_PLAIN 2、消息持久化
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");

            channel.close();
            connection.close();
        }
    }
}
