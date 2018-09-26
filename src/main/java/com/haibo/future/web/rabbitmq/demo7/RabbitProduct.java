package com.haibo.future.web.rabbitmq.demo7;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitProduct {
    private final static String EXCHANGE_NAME = "logs2";

    public static void main(String[] argv) throws Exception {
        for (int i = 0; i < 20; i++) {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            String message = "第"+i+"条"+"Hello World!";;
            //本次新增EXCHANGE:direct直接匹配，全匹配模式
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");
            //发送的时候只需要制定Exchange，不需要制定第二个参数队列名称/此处是drect模式，第二个参数为binding key
            channel.basicPublish(EXCHANGE_NAME, "black", null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
            channel.close();
            connection.close();
        }
    }
}
