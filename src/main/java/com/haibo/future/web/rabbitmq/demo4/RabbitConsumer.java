package com.haibo.future.web.rabbitmq.demo4;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitConsumer {
    private final static String QUEUE_NAME = "hello4";

    public static void main(String[] argv)
            throws IOException,
            InterruptedException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        final Channel channel = connection.createChannel();
        //队列持久化
        boolean durable = true;
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        //本次添加：每次接受1个没ack的消息
        channel.basicQos(1); // accept only one unack-ed message at a time (see below)
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                //本次添加
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        //本次添加
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);
    }
}
