package com.iappium.basepage;


import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author czy
 * @version 1.0.0
 * @date 2020/8/2 18:21
 */
@Slf4j
public class BaseAndroidDriver {

    private AndroidDriver driver;
    /**
     *初始化驱动
     */
    public AndroidDriver<WebElement> getDriver(BaseConfig baseConfig) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", baseConfig.getPlatformName());
        capabilities.setCapability("appPackage", baseConfig.getAppPackage());
        capabilities.setCapability("appActivity", baseConfig.getAppActivity());
        capabilities.setCapability("automationName", baseConfig.getAutomationName());
        // 支持中文输入
        capabilities.setCapability("noReset", "True");
        // 支持中文输入，必须两条都配置
        capabilities.setCapability("unicodeKeyboard", "True");
        // 不重新签名apk
        capabilities.setCapability("resetKeyboard", "True");
        capabilities.setCapability("chromedriverExecutable",baseConfig.getChromeDriverPath());
        // 通过本地 appium 服务开启 driver
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver<>(url, capabilities);
        //隐式等待时长，贯穿全部元素，设置一次即可
        driver.manage().timeouts().implicitlyWait(baseConfig.getImplicitlyWait(), TimeUnit.SECONDS);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver;
    }
    /**
     * 运行远端
     */
    public AndroidDriver<WebElement> getMobileDriver(BaseConfig baseConfig)  {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", baseConfig.getPlatformName());
        capabilities.setCapability("appPackage", baseConfig.getAppPackage());
        capabilities.setCapability("appActivity", baseConfig.getAppActivity());
        capabilities.setCapability("automationName", baseConfig.getAutomationName());
        // 支持中文输入
        capabilities.setCapability("noReset", "True");
        // 支持中文输入，必须两条都配置
        capabilities.setCapability("unicodeKeyboard", "True");
        // 不重新签名apk
        capabilities.setCapability("resetKeyboard", "True");
        // 通过远端 appium 服务开启 driver
        URL url = null;
        try {
            url = new URL("http://" + baseConfig.getRemoteIP() + ":" + baseConfig.getRemotePort() + "/wd/hub/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
         driver = new AndroidDriver<>(url, capabilities);
        return driver;
    }

    /**
     * 退出驱动
     */
    public void closeDriver(BaseConfig baseConfig) {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        log.info(baseConfig.getPlatformName() + "驱动已成功关闭！");
    }
}
