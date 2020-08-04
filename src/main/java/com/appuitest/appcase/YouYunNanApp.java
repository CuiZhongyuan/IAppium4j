package com.appuitest.appcase;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class YouYunNanApp {
    AndroidDriver driver;

    @Test
    public void start() throws MalformedURLException {
        initial();
        ticketCase(driver);

    }

    //点击景区预订
    public void  ticketCase( AndroidDriver driver){
        driver.findElementByXPath("");
    }
    //初始化APP
    @Test
    public void initial() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //手机类型或模拟器类型
        capabilities.setCapability("deviceName", "Android");
        //自动化测试引擎
        capabilities.setCapability("automationName", "Appium");
        //手机操作系统iOS, Android, or FirefoxOS
        capabilities.setCapability("platformName", "Android");
        //手机操作系统版本号
        capabilities.setCapability("platformVersion", "7.0");
        //打开微信应用
        capabilities.setCapability("appPackage","com.tengyun.yyn");
        capabilities.setCapability("appActivity","com.tengyun.yyn.ui.SplashActivity");
        // 支持中文输入
        capabilities.setCapability("noReset", "True");
        // 支持中文输入，必须两条都配置
        capabilities.setCapability("unicodeKeyboard", "True");
        // 不重新签名apk
        capabilities.setCapability("resetKeyboard", "True");
        //初始化驱动
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
