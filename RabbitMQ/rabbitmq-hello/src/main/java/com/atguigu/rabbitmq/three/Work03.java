package com.atguigu.rabbitmq.three;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.atguigu.rabbitmq.utils.SleepUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

/**
 * 消息在手动应答时不丢失，返回队列中重新消费
 */
public class Work03 {
    public static final String TASK_QUEUE_NAME = "ack_queue";

    // 接受消息
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        System.out.println("C1等待接受消息，较短的等待");

        // 声明 接受消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            // 沉睡1s
            SleepUtils.sleep(1);
            System.out.println("接受到的消息是：" + new String(message.getBody(), "UTF-8"));

            // 手动应答
            /**
             * 1. 消息的标记
             * 2。 是否批量应答，false 不批量应答
             */
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        };

        //设置不公平分发
        // int prefetchCount = 1;
        // 设置预取值
        int prefetchCount = 2;
        channel.basicQos(prefetchCount);

        CancelCallback cancelCallback = consumerTag -> {
            System.out.println(consumerTag + "：消息消费被中断");
        };

        // 采用手动应答
        boolean autoAsk = false;
        channel.basicConsume(TASK_QUEUE_NAME, false, deliverCallback, cancelCallback);
    }
}
