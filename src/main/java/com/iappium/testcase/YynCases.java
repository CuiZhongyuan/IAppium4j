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
    //进入被测APP
    @Test
    public void enterMini() {
        //启动游云南APP并点击关闭广告弹框
        enterMiniElemnt.xpath(driver);
    }
}
