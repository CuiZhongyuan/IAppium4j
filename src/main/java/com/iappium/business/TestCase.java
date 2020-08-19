package com.iappium.business;


import com.iappium.basepage.BaseAndroidDriver;
import com.iappium.basepage.BaseConfig;
import com.iappium.handle.EnterMiniHandle;
import com.iappium.handle.OrderTicketHandle;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * 业务层
 *
 * @author czy
 * @version 1.0.0
 * @date 2020/8/1 23:26
 */
@Test
public class TestCase  {

    //引入驱动需要的配置参数
    BaseConfig baseConfig = new BaseConfig();
    //实例化驱动对象
    AndroidDriver driver = new BaseAndroidDriver().getDriver(baseConfig);
    /**
     * 测试示例用例维护
    */
    //进入被测小程序
    @BeforeTest
    public void enterMini()  {
        EnterMiniHandle openMiniHandle = new EnterMiniHandle();
        //启动微信APP进入被测小程序内
        openMiniHandle.weixin(driver);
    }
    //门票产品下单支付至订单查看
    @Test
    public void orderTicket() throws InterruptedException {
        OrderTicketHandle orderTicket = new OrderTicketHandle();
        orderTicket.order(driver);
    }
}
