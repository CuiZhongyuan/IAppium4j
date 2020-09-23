package com.iappium.testcase;

import com.iappium.basepage.BaseTest;
import com.iappium.page.element.EnterMiniElemnt;
import com.iappium.utils.Json2MapUtil;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

public class YynCases extends BaseTest {
    /**
     * 测试示例用例
     * 操作层
     */
    EnterMiniElemnt enterMiniElemnt = new EnterMiniElemnt();
    //进入被测小程序
    @Test
    public void enterMini() {
        //启动微信APP并下滑窗口
//        enterMiniElemnt.swipToDown(driver);
        enterMiniElemnt.xpath(driver);
        //点击特定小程序
//        enterMiniElemnt.tap(driver);
        //点击最美云南
//        enterMiniElemnt.xpath(driver);
    }
}
