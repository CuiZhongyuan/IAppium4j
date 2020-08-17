package com.iappium.page;

import com.iappium.basepage.BaseAndroidDriver;
import com.iappium.basepage.BaseConfig;
import io.appium.java_client.android.AndroidDriver;

/**
 * 元素层
 *
 * @author czy
 * @version 1.0.0
 * @date 2020/8/1 23:26
 */
public class StartAppDriverPage {
    //返回APP驱动，供后续定位使用
    public AndroidDriver start() {
        BaseConfig baseConfig = new BaseConfig();
        BaseAndroidDriver baseAndroidDriver = new BaseAndroidDriver();
        //获取驱动
        AndroidDriver driver =  baseAndroidDriver.getDriver(baseConfig);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
