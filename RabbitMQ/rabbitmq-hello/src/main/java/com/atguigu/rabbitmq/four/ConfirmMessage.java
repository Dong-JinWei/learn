package com.atguigu.rabbitmq.four;

import com.atguigu.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;

import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 发布确认模式
 * 1。 单个确认  发布100个单独确认消息耗时3452ms
 * 2。 批量确认  发布100个批量确认消息耗时388ms
 * 3。 异步批量确认  发布100个异步确认消息耗时6ms
 */
public class ConfirmMessage {

    // 批量发消息的个数
    public static final int MESSAGE_COUNT = 100;

    public static void main(String[] args) throws Exception {
        // * 1。 单个确认
        // publicMessageIndividually(); // 发送100条
        // * 2。 批量确认
        // publishMessageBatch();
        // * 3。 异步批量确认
        publishMessageAsync();

    }

    // 单个确认
    public static void publicMessageIndividually() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, true, false, false, null);
        // 开启发布确认
        channel.confirmSelect();
        // 开始时间
        long begin = System.currentTimeMillis();
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            // 单个消息就马上发布确认
            boolean flag = channel.waitForConfirms();
        }

        // 结束时间
        long end = System.currentTimeMillis();

        System.out.println("发布" + MESSAGE_COUNT + "个单独确认消息耗时" + (end - begin) + "ms");
    }

    // 批量确认
    public static void publishMessageBatch() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, true, false, false, null);
        // 开启发布确认
        channel.confirmSelect();
        // 开始时间
        long begin = System.currentTimeMillis();

        // 批量确认消息大小
        int batchSize = 10;

        // 批量发送消息 批量发布确认
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());

            // 判断达到10条消息的时候 批量确认一次
            if (0 == i % batchSize){
                channel.waitForConfirms();
            }
        }


        // 结束时间
        long end = System.currentTimeMillis();

        System.out.println("发布" + MESSAGE_COUNT + "个批量确认消息耗时" + (end - begin) + "ms");
    }

    // 异步确认
    public static void publishMessageAsync() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, true, false, false, null);
        // 开启发布确认
        channel.confirmSelect();

        /**
         * 线程安全有序的一个哈希表，适用于高并发的情况下
         * 1. 将序号与消息关联
         * 2. 轻松批量删除条目，只要给到需要
         * 3。 支持高并发
         */
        ConcurrentSkipListMap<Long, String> outstandingConfirms = new ConcurrentSkipListMap<>();


        // 接受成功回调函数
        ConfirmCallback confirmCallback = (deliveryTag, multiple) -> {
            if (multiple){
                // 2. 删除已经确认的消息，剩下就是为发送的消息
                ConcurrentNavigableMap<Long, String> confirmed = outstandingConfirms.headMap(deliveryTag);
                confirmed.clear();
            }else {
                outstandingConfirms.remove(deliveryTag);
            }
            System.out.println("确认的消息" + deliveryTag);

        };

        // 接受失败回调函数
        // deliveryTag 消息的标记
        // multiple 是否批量确认
        ConfirmCallback nackCallback = (deliveryTag, multiple) -> {
            // 3. 剩下的就是为确认的消息
            String message = outstandingConfirms.get(deliveryTag);
            System.out.println("未确认的消息" + deliveryTag + ": " + deliveryTag);
        };

        // 消息监听器
        channel.addConfirmListener(confirmCallback, nackCallback);

        // 开始时间
        long begin = System.currentTimeMillis();
        // 批量发送消息 异步
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());

            // 1. 记录所有要发送的消息
            outstandingConfirms.put(channel.getNextPublishSeqNo(), message);
        }


        // 结束时间
        long end = System.currentTimeMillis();

        System.out.println("发布" + MESSAGE_COUNT + "个异步确认消息耗时" + (end - begin) + "ms");
    }
}
