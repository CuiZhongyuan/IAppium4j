package com.iappium.page.data;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class XPathData {
    //点击登录按钮
    public static final By LOGIN = By.xpath("//android.widget.TextView[@text=\"登录/注册\"]");
    //后台环境切换
    public static final By ENV = By.xpath("//android.widget.TextView[@text='后台环境(需重启):']");
    //测试选择
    public static final By CESHI = By.xpath("//android.widget.CheckedTextView[@text='测试环境']");
    public static final By NAMEID = By.id("//android.widget.EditText[@text=\"请填写出行人姓名\"]");
    public static final By PHONE = By.id("//android.widget.EditText[@text=\"填写手机号码接收确认短信\"]");
    public static final By SUBMIT = By.id(" //android.widget.TextView[@text=\"提交订单\"]");
//
//    @FindBy(xpath = "//android.widget.TextView[@text=\"登录/注册\"]")
//    public static  By LOGIN ;
//    @FindBy(xpath = "//android.widget.TextView[@text='后台环境(需重启):']")
//    public static By ENV;
    @FindBy(xpath = "//android.widget.CheckedTextView[@text='测试环境']")
    public static By CESHITest;
}
