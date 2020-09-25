package com.iappium.basepage;


import com.iappium.utils.DateUtils;
import com.iappium.utils.ScreenshotUtil;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

/**
 * BaseApp
 * @author czy
 * @version 1.0.0
 * @date 2020/8/1 23:28
 */
@Slf4j
public class BaseApp {
    /**
     * 持续时间，单位秒
     */
    static Duration duration=Duration.ofSeconds(2);
    /**
     * 动作
     */
    protected TouchAction action;

    /**
     * 显示等待
     */
    protected WebDriverWait wait ;

    /**
     * @param driver 驱动
     */
    BaseAndroidDriver baseAndroidDriver;
    /**
     * 启动被测机参数配置
     */
    BaseConfig baseConfig;
    /**
     * 构造方法
     */
    public BaseApp() {
    }

    public BaseApp(BaseAndroidDriver androidDriver, BaseConfig baseConfig) {
        this.baseAndroidDriver = androidDriver;
        this.baseConfig = baseConfig;
    }

    /*============================== 基本元素操作 ==============================*/
    /**
     * 通过元素定位拿到 Element 元素对象
     *
     * @param locator By 类型元素定位
     * @return 定位到的元素
     */
    public WebElement locateElement(AndroidDriver driver,By locator) {
        try {
            wait = new WebDriverWait(driver, 10);
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (NoSuchElementException | TimeoutException e) {
            System.out.println("================当前页面未捕获该元素，继续执行用例==================");
        }
        return null;
    }

    /**
     * 点击元素
     *
     * @param locator By 类型元素定位,做弹框或元素异常后接着往下执行
     * @return 点击的元素
     */
    public WebElement clickButton(AndroidDriver driver,By locator) {
        try {
            long time1 = DateUtils.getCurrentMillisecond();
            MobileElement buttonElement = (MobileElement) locateElement(driver,locator);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            if (buttonElement.isEnabled()){
                buttonElement.click();
                log.info("该点击事件耗时时间（ms）："+(DateUtils.getCurrentMillisecond()-time1));
                return buttonElement;
            }
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("================当前页面未捕获该元素，截图保留>>>>继续执行用例==================");
            ScreenshotUtil.snapshot(driver);
        }
        return null;
//       System.out.println("改点击事件耗时时间（ms）："+(DateUtils.getCurrentMillisecond()-time1));
    }
    /**
     * 输入框输入数据
     *
     * @param locator By 类型元素定位
     * @param content 输入的内容，支持多内容，可以键盘输入
     * @return 输入框元素
     */
    public WebElement sendInput(AndroidDriver driver,By locator, CharSequence... content) {
        WebElement inputElement = locateElement(driver,locator);
        inputElement.clear();
        inputElement.sendKeys(content);
        return inputElement;
    }

    /*============================== 切换 WebView ==============================*/

    /**
     * 切换到 webview 页面
     *
     * @return MobileDriver
     */
    public MobileDriver<WebElement> switchWebView() {
       baseAndroidDriver.getDriver(baseConfig).getContextHandles().forEach((context) -> {
            if (context.contains("WEBVIEW")) {
                baseAndroidDriver.getDriver(baseConfig).context(context);
            }
        });
        return baseAndroidDriver.getDriver(baseConfig);
    }

    /**
     * 切换到下一个窗口
     *
     * @return MobileDriver
     */
    public MobileDriver<WebElement> switchNextWindow() {
        // 当前窗口句柄
        String currentHandle = baseAndroidDriver.getDriver(baseConfig).getWindowHandle();
        // 所有窗口句柄
        Set<String> allHandlesSet = baseAndroidDriver.getDriver(baseConfig).getWindowHandles();
        for (String window : allHandlesSet) {
            if (!currentHandle.equals(window)) {
                baseAndroidDriver.getDriver(baseConfig).switchTo().window(window);
            }
        }
        return baseAndroidDriver.getDriver(baseConfig);
    }

    /**
     * 退出 webview 页面
     *
     * @return MobileDriver
     */
    public MobileDriver<WebElement> switchOutWebView() {
        baseAndroidDriver.getDriver(baseConfig).getContextHandles().forEach((context) -> {
            if (context.contains("NATIVE_APP")) {
                baseAndroidDriver.getDriver(baseConfig).context(context);
            }
        });
        return baseAndroidDriver.getDriver(baseConfig);
    }

    /*============================== 页面滑动操作 ==============================*/

    /**
     * 通过坐标滑动页面
     */
    public void slideScreen(int fromX, int fromY, int toX, int toY) {
        PointOption fromOption = PointOption.point(fromX, fromY);
        PointOption toOption = PointOption.point(toX, toY);
        action.press(fromOption).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)))
                .moveTo(toOption)
                .release().perform();
    }

    /*=====================通过动作滑动==================================*/
    /**
     *向上滑动操作
     */
    public void swipeToUp(AndroidDriver driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction action=new TouchAction(driver).press(PointOption.point(width/2, height*3/4)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(width/2, height/4)).release();
        action.perform();
    }
    /**
     *向下滑动操作
     */
    public void swipeToDown(AndroidDriver driver) {
        int height = driver.manage().window().getSize().height;
        int width = driver.manage().window().getSize().width;
        TouchAction action=new TouchAction(driver).press(PointOption.point(width/2, height/4)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(width/2, height*3/4)).release();
        action.perform();
    }
    /**
     *向左滑动操作
     */
    public void swipeToLeft(AndroidDriver driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction action=new TouchAction(driver).press(PointOption.point(width*3/4, height/2)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(width/4,height/2)).release();
        action.perform();
    }
    /**
     *向右滑动操作
     */
    public void swipeToRight(AndroidDriver driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction action=new TouchAction(driver).press(PointOption.point(width / 4, height / 2)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(width*3/4,height/2)).release();
        action.perform();
    }

    /*=====================通过具体坐标点击操作，appium&&adb两种方式==================================*/
    /**
     * 通过具体坐标点击
     */
    public void taptest(AndroidDriver driver,int x, int y){
        /**设置显示等待时间10s  driver=baseAndroidDriver.getDriver(baseConfig)
        特注：显示等待与隐式等待相对，显示等待必须在每一个需要等待的元素前面进行声明，如果在规定的时间内找到元素，则直接执行，即找到元素就执行相关操作
         */
        wait = new WebDriverWait(driver,5);
        //tap点击坐标，输入坐标，然后再release()释放坐标点，用perform()去执行一系列action操作
        action = new TouchAction(driver).tap(PointOption.point(x,y)).release().perform();

    }
    /**
     * 通过adb命令驱动被测设备
     */
    public void adbInput(AndroidDriver driver ,String input){
        try {
            Process process = Runtime.getRuntime().exec(input);
            wait = new WebDriverWait(driver,5);
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*=====================其它操作==================================*/
    /**
     * 前进、后退、刷新的动作
     */
    public void operation(AndroidDriver driver,String operation,int number )  {
        for (int i=0;i <number;i++){
            if (operation.equals("forward")){
                // 前进
                driver.navigate().forward();
            }else if (operation.equals("back")){
                // 后退
                driver.navigate().back();
            }else {
                // 刷新
                driver.navigate().refresh();
            }
            i++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.navigate().back();
        }
    }
    // todo : 页面中其他的最基本操作，可自行封装

}
