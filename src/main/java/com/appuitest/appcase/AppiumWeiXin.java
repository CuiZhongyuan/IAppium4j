package com.appuitest.appcase;

import com.appuitest.utils.SwipeUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumWeiXin {

    AndroidDriver driver;
    TouchAction ta ;
    SwipeUtils swipeUtils = new SwipeUtils();
    @Test
    public void miniTest() throws MalformedURLException {
        //初始化Android设备并打开微信APP实例
        initializeApp();
        //进入微信下滑操作
        entryMi(driver,"down");
        //打印下驱动名称
        System.out.println(driver.getContext());
        //点击第一个小程序坐标
        taptest(driver);
        //点击门票坐标
        ticketCase(driver);
        //进入门票点击“美好家园”商户
        ticketList(driver);
        //进入美好家园上滑
        upTo(driver,"up");
        //点击武夷山门票
        wuyishan(driver);
        end(driver);
    }


    //小程序xpath不好定位,忽略
    public void XpathTest(AndroidDriver driver){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementByXPath("//input[contains(@class,'uni-input')]").sendKeys("美好家园");
    }

    //进入武夷山门票
    public void wuyishan(AndroidDriver driver){
        ta = new TouchAction(driver);
        ta.tap(864,1511).release().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("*************");
    }
    //上滑操作
    private void upTo(AndroidDriver driver, String data) {
        try {
            swipeUtils.swipeTo(driver,data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //进入门票点击“美好家园”商户
    public void ticketList(AndroidDriver driver){
        ta = new TouchAction(driver);
        ta.tap(433,418).release().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("*************");
    }
    //点击首页门票产品坐标
    public void ticketCase(AndroidDriver driver){
        ta = new TouchAction(driver);
        ta.tap(154,970).release().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("点击美好家园");
    }

    //点击屏幕具体坐标（打开手机调试模式开启指针，可以查看手机屏幕位置）
    public void taptest(AndroidDriver driver){
        ta = new TouchAction(driver);
        ta.tap(191,667).release().perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void entryMi(AndroidDriver driver,String data) {
        try {
            swipeUtils.swipeTo(driver,data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //初始化参数启动微信APP
   @Test
    public void initializeApp() throws MalformedURLException {
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
        capabilities.setCapability("appPackage","com.tencent.mm");
        capabilities.setCapability("appActivity","com.tencent.mm.ui.LauncherUI");
        // 支持中文输入
        capabilities.setCapability("noReset", "True");
        // 支持中文输入，必须两条都配置
        capabilities.setCapability("unicodeKeyboard", "True");
        // 不重新签名apk
        capabilities.setCapability("resetKeyboard", "True");
        //chromedriver对应版本路径
        capabilities.setCapability("chromedriverExecutable","F:\\00_12UI-test\\chromedriver\\chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("androidProcess","com.tencent.mm:appbrand0");
        capabilities.setCapability("chromeOptions",options);
        //初始化驱动
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        //等待初始化驱动延迟时间
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //无操作时离开
    public void end(AndroidDriver driver){
        System.out.println("无操作即将离开");
        driver.quit();
    }
}
