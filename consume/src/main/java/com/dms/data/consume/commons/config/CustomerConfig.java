package com.dms.data.consume.commons.config;

import com.dms.data.consume.commons.mq.PublicCustomer;
import com.dms.data.consume.commons.utils.Constant;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jp on 2019/01/14
 */
@Configuration
public class CustomerConfig {

    @Autowired
    PublicCustomer publicCustomer;

    //交换机
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(Constant.EXCHANGE_ASYNC);
    }

    //队列
    @Bean
    public Queue couponQueue() {
        return new Queue(Constant.QUEUE_COUPON);
    }

    //将队列绑定到交换机
    @Bean
    Binding bindingExchangeA(Queue couponQueue,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(couponQueue).to(fanoutExchange);
    }

    //设置消息监听
    @Bean
    public SimpleMessageListenerContainer couponCustomerLister(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);

        container.setQueues(couponQueue()); //监听队列名称
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(5);
        container.setConcurrentConsumers(1);
        container.setReceiveTimeout(15000);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);   //设置确认模式手工确认
        container.setMessageListener(publicCustomer);   //设置监听
        container.setMessageConverter(new Jackson2JsonMessageConverter());  //指定了我们接受消息的时候，以 JSON 传输的消息可以转换成对应的类型传入到方法中

        return container;
    }

}

