package com.iappium.basepage;

import com.iappium.utils.WordartDisplayer;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

/**
 * 测试基类
 *
 * @author czy
 * @date 2020/1/22
 */
@Slf4j
@Component
@SpringBootTest
public class BaseTest extends AbstractTestNGSpringContextTests {
    /**
     * 获取驱动driver
     * */
    @Autowired
    public BaseAndroidDriver baseAndroidDriver;
    /**
     * 驱动
     * 对外暴露
     */
    public AndroidDriver driver;
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
    @BeforeClass(alwaysRun = true)
    public void beforeTest() {
        driver = baseAndroidDriver.getDriver();
        /* 驱动配置 */
    }
    /**
     * 执行一个测试用例之后执行
     */
    @AfterClass(alwaysRun = true)
    public void afterTest() {
        //关闭被测APP
        baseAndroidDriver.closeDriver();
        // todo : 其他工具的释放操作（看需要）
    }
}