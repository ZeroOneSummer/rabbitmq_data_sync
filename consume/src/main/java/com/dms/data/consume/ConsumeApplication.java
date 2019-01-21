package com.dms.data.consume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class ConsumeApplication implements ApplicationListener<ContextRefreshedEvent> {
    Logger logger = LoggerFactory.getLogger(ConsumeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumeApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("程序启动成功了哟......");
    }
}


