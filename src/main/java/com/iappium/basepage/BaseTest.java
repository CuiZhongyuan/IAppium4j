package com.iappium.basepage;

import com.iappium.utils.WordartDisplayer;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * 测试基类
 *
 * @author czy
 * @date 2020/1/22
 */
@Slf4j
public class BaseTest {
    /**
     * 驱动
     * 对外暴露
     */
    public AndroidDriver driver;
    BaseConfig baseConfig = new BaseConfig();
    /**
     * 执行一个测试套之前执行
     */
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        // 显示文字 IAppium
        WordartDisplayer.display();
        // todo : 这里可以自己定制其他工具初始化操作（看需要）
    }
    /**
     * 执行一个测试用例之前执行
     * 这里做多线程的处理
     *
     */
    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        driver = new BaseAndroidDriver().getDriver(baseConfig);
        /* 驱动配置 */
    }
    /**
     * 每个方法之后出现异常截图
     */
    public void printscreen(){
        System.out.println("捕获异常");
    }
    /**
     * 执行一个测试用例之后执行
     */
//    @AfterTest(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        // 驱动退出关闭浏览器
//        Thread.sleep(10000);
        // todo : 其他工具的释放操作（看需要）
    }
}