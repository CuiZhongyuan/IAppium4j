package com.iappium.testcase;

import com.iappium.basepage.BaseTest;
import com.iappium.page.element.EnterYynElemnt;
import org.testng.annotations.Test;

public class YynCases extends BaseTest {
    /**
     * 测试示例用例,继承BaseTest获取driver
     * 操作层
     */
    EnterYynElemnt enterMiniElemnt = new EnterYynElemnt();
    //进入被测APP
    @Test
    public void enterMini() {
        //启动游云南APP并点击关闭广告弹框
        enterMiniElemnt.popupClick(driver);
        //修改测试环境
        enterMiniElemnt.testEnvSelection(driver);
        //微信授权login
        enterMiniElemnt.weixinLogin(driver);
        //门票下单业务流程
//        enterMiniElemnt.ticketCase(driver);
    }
}
