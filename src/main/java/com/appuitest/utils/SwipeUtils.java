package com.appuitest.utils;


import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static java.lang.Thread.sleep;

//滑动操作封装
public class SwipeUtils {

    Logger logger = LoggerFactory.getLogger(SwipeUtils.class);

    public void swipeTo(AndroidDriver driver,String direction) throws InterruptedException {

        int width=driver.manage().window().getSize().width;
        int height=driver.manage().window().getSize().height;

        if (direction == "right") {
            driver.swipe(width/4, height/2, width*3/4,height/2, 500);
            logger.info("右滑");
        } else if (direction == "left") {
            driver.swipe(width*3/4, height/2, width/4, height/2, 500);
            logger.info("左滑");
        } else if (direction == "down") {
            driver.swipe(width/2, height/4, width/2, height*3/4, 500);
            logger.info("下滑");
        } else if (direction == "up") {
            driver.swipe(width/2, height*3/4, width/2, height/4, 500);
            logger.info("上滑");
        } else if (direction == "end") {
            String page1;
            String page2;
            do {
                page1 = driver.getPageSource();
                driver.swipe(width/2, height*3/4, width/2, height/4, 500);
                sleep(2);
                page2 = driver.getPageSource();
            } while (!page1.equals(page2));
            logger.info("滑到底");
        } else if (direction == "top") {
            String page1;
            String page2;
            do {
                page1 = driver.getPageSource();
                driver.swipe(width/2, height/4, width/2, height*3/4, 500);
                sleep(4);
                page2 = driver.getPageSource();
            } while (!page1.equals(page2));
            logger.info("滑到顶");
        }
        sleep(1);
    }
}
