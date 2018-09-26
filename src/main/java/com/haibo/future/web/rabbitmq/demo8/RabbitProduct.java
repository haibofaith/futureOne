package com.haibo.future.web.rabbitmq.demo8;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitProduct {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv) throws Exception {
        for (int i = 0; i < 10; i++) {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            String message = null;
            //P-->X :本次新增EXCHANGE:direct直接匹配，全匹配模式
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            //X-->Q :发送的时候只需要制定Exchange，不需要制定第二个参数队列名称/此处是drect模式，第二个参数为binding key/此处是topic模式，第二个参数为rooting key
            if (i == 5) {
                message = "第" + i + "条:" + "lazy.orange.rabbit" + i;
                channel.basicPublish(EXCHANGE_NAME, "lazy.orange.rabbit" + i, null, message.getBytes("UTF-8"));
            } else {
                if (i % 2 == 1) {
                    message = "第" + i + "条:" + i + ".orange." + "rabbit";
                    channel.basicPublish(EXCHANGE_NAME, i + ".orange." + "rabbit", null, message.getBytes("UTF-8"));
                } else {
                    message = "第" + i + "条:" + i + ".orange." + "bird";
                    channel.basicPublish(EXCHANGE_NAME, i + ".orange." + "bird", null, message.getBytes("UTF-8"));
                }
            }
            System.out.println(" [x] Sent '" + message + "'");
            channel.close();
            connection.close();
        }
    }
}
