package com.iappium.page.element;


import com.iappium.basepage.BaseApp;
import com.iappium.page.data.PopupData;
import com.iappium.page.data.ResourceIDData;
import com.iappium.page.data.SendKeyData;
import com.iappium.page.data.XPathData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * 元素层
 * @author czy
 * @version 1.0.0
 * @date 2020/3/4 14:31
 */
@Slf4j
public class EnterYynElemnt extends BaseApp{

    @FindBy(id = "com.tengyun.yyn:id/layout_confirm_cancel")
    private WebElement aa;

    /**
     * 继承BaseApp使用公共封装方法
     * */
    //点击弹框
    public void popupClick(AndroidDriver driver) {
        //使用封装By类型元素定位，且数据和元素分离
        log.info("点击弹框");
        clickButton( driver, PopupData.POPUP1);
    }
    //点击环境选择至测试环境
    public void testEnvSelection(AndroidDriver driver) {
        //点击我的图标
        clickButton(driver, ResourceIDData.MYID);
        //点击右上角设置按钮
        clickButton(driver, ResourceIDData.SETTING);
        //点击环境选择
        clickButton(driver,ResourceIDData.TESTENV);
        //后台环境切换
        clickButton(driver,XPathData.ENV);
        //需要做判断，如果是当前测试环境无需切换，如果不是需求切换测试环境
        AndroidElement els =  (AndroidElement)driver.findElement(XPathData.CESHI);
        String a =  els.getAttribute("checked");
        if (a.equals("false")){
            els.click();
        }
        //点击取消按钮
        clickButton(driver,ResourceIDData.CANCLE);
        //后退2次
        for (int i=0;i<2;i++){
            operation(driver,"back");
        }
    }
    //点击登录至微信授权
    public void weixinLogin(AndroidDriver driver) {
            //点击我的图标
            clickButton(driver, ResourceIDData.MYID);
            //点击登录按钮
            clickButton(driver, XPathData.LOGIN);
            //点击微信授权图标
            clickButton(driver, ResourceIDData.WEIXINLOGINID);
            log.info(String.valueOf(ResourceIDData.WEIXINLOGINID));
            //返回首页
            clickButton(driver, ResourceIDData.SHOUYEID);
    }
    //门票下单流程
    public void ticketCase(AndroidDriver driver) {
        //返回首页
        clickButton(driver, ResourceIDData.SHOUYEID);
        popupClick(driver);
        clickButton(driver,ResourceIDData.AREA);
        sendInput(driver,ResourceIDData.SEARCH, SendKeyData.KM);
        //展开列表
        clickButton(driver,ResourceIDData.ZHANGKAI);
        //调转门票列表详情
        clickButton(driver,ResourceIDData.TICKETLIST);
        swipeToDown(driver);
        //点击预订
        clickButton(driver,ResourceIDData.TICKET);
        sendInput(driver,XPathData.NAMEID,SendKeyData.NAME);
        sendInput(driver,XPathData.PHONE,SendKeyData.PHONE);
        //提交订单
        clickButton(driver,XPathData.SUBMIT);
    }
}
