package com.appuitest.appcase;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumWeiXin {
    private  AndroidDriver driver;

    @Test
    public  void testApp() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        // appium做自动化
        cap.setCapability("automationName", "uiautomator2");
        // cap.setCapability("app", "C:\\software\\jrtt.apk");//安装apk
        // cap.setCapability("browserName", "chrome");//设置HTML5的自动化，打开谷歌浏览器
        // 设备名称
        cap.setCapability("deviceName", "5fa632f");
        // 安卓自动化还是IOS自动化
        cap.setCapability("platformName", "Android");
        // 安卓操作系统版本
        cap.setCapability("platformVersion", "7.0");
        // 设备的udid (adb devices 查看到的)
        cap.setCapability("udid", "EJL4C17428010332");
        // 被测app的包名
        cap.setCapability("appPackage", "com.tencent.edu");
        // 被测app的入口Activity名称
        cap.setCapability("appActivity", "com.tencent.eduActivity");
        // 支持中文输入
        cap.setCapability("unicodeKeyboard", "True");
        // 支持中文输入，必须两条都配置
        cap.setCapability("resetKeyboard", "True");
        // 不重新签名apk
        cap.setCapability("noSign", "True");
        // 没有新命令，appium30秒退出
        cap.setCapability("newCommandTimeout", "300");
        // 把以上配置传到appium服务端并连接手机
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        // 隐式等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 通过xxx定位元素
        driver.findElement(MobileBy.AccessibilityId("我的")).click();
//        driver.findElement(MobileBy.AndroidUIAutomator("")).click();
//        driver.findElement(MobileBy.id("")).click();
//        driver.findElement(MobileBy.xpath("")).click();
    }


    @Test
    public void testAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //手机类型或模拟器类型
        capabilities.setCapability("deviceName", "Android");
        //自动化测试引擎
        capabilities.setCapability("automationName", "Appium");
        //手机操作系统iOS, Android, or FirefoxOS
        capabilities.setCapability("platformName", "Android");
        //手机操作系统版本号
        capabilities.setCapability("platformVersion", "7.0");
        //app包名
        capabilities.setCapability("appPackage", "com.android.settings");
        //app中启动的 Activity名称
        capabilities.setCapability("appActivity", ".Settings");
        capabilities.setCapability("newCommandTimeout", "300");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        // 隐式等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.quit();
    }

    @Test
    public void caseTest() throws MalformedURLException {
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
        capabilities.setCapability("chromedriverExecutable","F:\\00_12UI-test\\chromedriver\\LATEST_RELEASE_78.0.3904");

//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("androidProcess","com.tencent.mm:appbrand0");
//        capabilities.setCapability("chromeOptions",options);
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();//
        capabilities.setCapability("deviceName", "Android");//设备名称
        capabilities.setCapability("platformName", "Android");//平台名称
        capabilities.setCapability("platformVersion", "7.0");//平台版本
        capabilities.setCapability("appPackage", "com.android.calculator2");//app包名
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");//APPactivity名称
        capabilities.setCapability("appWaitActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("sessionOverride", true);
        capabilities.setCapability("automationName", "Appium");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//DEMO计算7*7算术得出结果
        driver.findElementById("com.android.calculator2:id/digit_7").click();
        driver.findElementById("com.android.calculator2:id/op_mul").click();
        driver.findElementById("com.android.calculator2:id/digit_7").click();
        driver.findElementById("com.android.calculator2:id/eq").click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
