package com.iappium;


import com.iappium.utils.SpringContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author czy-2020727
 */
@EnableConfigurationProperties
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@EnableScheduling
public class IappiumApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(IappiumApplication.class, args);
        SpringContextUtils.setApplicationContext(context);
    }
}
