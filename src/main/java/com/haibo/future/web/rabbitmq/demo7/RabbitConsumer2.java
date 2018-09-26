package com.haibo.future.web.rabbitmq.demo7;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitConsumer2 {
    private static final String EXCHANGE_NAME = "logs2";


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
        //定义路由模式direct
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        //消费者需要知道队列名称，因为已知是direct模式，queueName直接从channel定义中获取
        String queueName = channel.queueDeclare().getQueue();
        //将队列和Exchange绑定起来,binding key 为black
        channel.queueBind(queueName, EXCHANGE_NAME, "red");
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
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
            }
        };
        boolean autoAck = true;
        channel.basicConsume(queueName, autoAck, consumer);
    }
}
