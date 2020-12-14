package com.iappium.basepage;


import com.iappium.utils.LoadStaticConfigUtil;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * @author czy
 * @version 1.0.0
 * @date 2020/8/2 18:21
 */
@Slf4j
@Component
public class BaseAndroidDriver {
    /**
     * driver驱动
     */
    public AndroidDriver driver;
    /**
     * 显示等待
     */
    public WebDriverWait wait ;
    /**
     *初始化驱动
     */
    public AndroidDriver<WebElement> getDriver() {
        /**
         * appium基本启动配置信息
         * */
        String platformName = (String) LoadStaticConfigUtil.getCommonYml("appium.platformName");
        String appPackage = (String) LoadStaticConfigUtil.getCommonYml("appium.appPackage");
        String appActivity = (String) LoadStaticConfigUtil.getCommonYml("appium.appActivity");
        String automationName = (String) LoadStaticConfigUtil.getCommonYml("appium.automationName");
        String deviceName = (String) LoadStaticConfigUtil.getCommonYml("appium.deviceName");
//        String chromePath = this.getClass().getClassLoader().getResource("chromedriver/chromedriver.exe").getPath();
        //引用配置参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("automationName", automationName);
        capabilities.setCapability("deviceName",deviceName);
        capabilities.setCapability("chromedriverExecutable", "D:\\work\\IAppium4j\\src\\main\\resources\\chromedriver\\chromedriver.exe");
        capabilities.setCapability("platformVersion","7.0");
        capabilities.setCapability("unicodeKeyboard",true);
        capabilities.setCapability("noReset",true);
        // 不重新签名apk
        capabilities.setCapability("resetKeyboard", true);
        // 支持X5内核应用自动化配置
        capabilities.setCapability("recreateChromeDriverSessions", true);
        /**
         *  ChromeOptions使用来定制启动选项，因为在appium中切换context识别webview的时候,
         *  把com.tencent.mm:toolsmp的webview识别成com.tencent.mm的webview.
         *  所以为了避免这个问题，加上androidProcess: com.tencent.mm:toolsmp
         * */
        ChromeOptions options = new ChromeOptions();
        /**
         * 这里很关键>>
         * ChromeOptions使用来定制启动选项，因为在appium中切换context识别webview的时候,把com.tencent.mm:toolsmp的webview识别成com.tencent.mm的webview.
         * 所以为了避免这个问题，加上androidProcess名:通过driver.getContextHandles()获取所有的上下文，我这里获取的是com.tencent.mm:appbrand0
         * */
        options.setExperimentalOption("androidProcess", "com.tencent.mm:appbrand0");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        // 初始化会默认将chrome浏览器打开，需要将Browser置为空
        capabilities.setBrowserName("");
        // 每次启动时覆盖session，否则第二次后运行会报错不能新建session
        capabilities.setCapability("sessionOverride", true);
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver(url, capabilities);
        //隐式等待时长，贯穿全部元素，设置一次即可
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //显示等待时间，作用域是局部，单独调用使用,元素之前使用
        wait = new WebDriverWait(driver,20);
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
    public AndroidDriver<WebElement> getMobileDriver()  {
        /**
         * appium基本启动配置信息
         * */
        String platformName = (String) LoadStaticConfigUtil.getCommonYml("appium.platformName");
        String appPackage = (String) LoadStaticConfigUtil.getCommonYml("appium.appPackage");
        String appActivity = (String) LoadStaticConfigUtil.getCommonYml("appium.appActivity");
        String automationName = (String) LoadStaticConfigUtil.getCommonYml("appium.automationName");
        String remoteIP = (String) LoadStaticConfigUtil.getCommonYml("appium.remoteIP");
        String remotePort = (String) LoadStaticConfigUtil.getCommonYml("appium.remotePort");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("automationName", automationName);
        // 支持中文输入
        capabilities.setCapability("noReset", "True");
        // 支持中文输入，必须两条都配置
        capabilities.setCapability("unicodeKeyboard", "True");
        // 不重新签名apk
        capabilities.setCapability("resetKeyboard", "True");
        // 通过远端 appium 服务开启 driver
        URL url = null;
        try {
            url = new URL("http://" + remoteIP + ":" + remotePort + "/wd/hub/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
         driver = new AndroidDriver<>(url, capabilities);
        return driver;
    }
    /**
     * 关闭驱动
     *
     * @throws
     */
    public void closeDriver()  {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        log.info( "app已成功关闭！");
    }
}
