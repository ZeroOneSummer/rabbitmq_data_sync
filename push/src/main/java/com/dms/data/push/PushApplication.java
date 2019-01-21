package com.dms.data.push;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class PushApplication implements ApplicationListener<ContextRefreshedEvent> {
    Logger logger = LoggerFactory.getLogger(PushApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PushApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("程序启动成功了哟......");
    }
}

