package com.iappium.page.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * 用于XPath定位数据存放
 * */
@Getter
@Setter
@ToString
@Component
public class PopupData {
    //升级弹框
    public static final By POPUP1= By.id("com.tengyun.yyn:id/layout_confirm_cancel");
    //第二个弹框
    public static final By POPUP2 = By.id("com.tengyun.yyn:id/layout_activity_cancel");
    //第三个弹框，“欢迎来到云南”
    public static final By POPUP3 = By.id("com.tengyun.yyn:id/common_dialog_cancel");
}
