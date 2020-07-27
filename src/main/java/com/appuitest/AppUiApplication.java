package com.appuitest;

import com.appuitest.utils.SpringContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author czy-2020727
 */
@SpringBootApplication
public class AppUiApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(com.appuitest.AppUiApplication.class, args);
        SpringContextUtils.setApplicationContext(context);
    }
}
