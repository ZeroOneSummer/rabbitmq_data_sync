package com.dms.data.push.commons.mq;

import com.dms.data.push.commons.utils.Constant;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublicPush{
    Logger logger = LoggerFactory.getLogger(PublicPush.class);

    @Autowired
    ConnectionFactory factory;

    //推送数据
    public void sendMessage(String message, String exchange, String routingKey){

        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.createConnection();
            channel = connection.createChannel(false);
            channel.queueDeclare(Constant.ROUTING_KEY_COUPON, true, false, false, null); //durable=true队列持久化
            channel.exchangeDeclare(exchange, Constant.EXCHANGE_TYPE_FANOUT, true); //durable=true交换机持久化

            logger.info("推送MQ信息：{}|{}", exchange, routingKey);
            //deliveryMode=2消息持久化,immediate=false当没有消费者时也将消息放入队列中
            channel.basicPublish(exchange, routingKey, true, false, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("utf-8"));
            logger.info("本次推送成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.info("本次推送失败：{}", e.getMessage());
        }finally {
            try {
                channel.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("资源关闭失败");
            }
        }
    }

}
