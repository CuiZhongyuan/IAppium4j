package com.iappium.page.element;


import com.iappium.basepage.BaseApp;
import com.iappium.page.data.MiniParamsData;
import com.iappium.page.data.MiniXPathData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;


/**
 * 元素层
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/4 14:31
 */
@Slf4j
public class EnterMiniElemnt extends BaseApp{
    BaseApp baseApp = new BaseApp();
    public void xpath(AndroidDriver driver) {
        clickButton( driver,MiniXPathData.POPUP1);
    }
}
