package com.iappium.page.element;

import com.iappium.basepage.BaseApp;
import com.iappium.page.data.MiniParamsData;
import io.appium.java_client.android.AndroidDriver;

public class WeiXinElement extends BaseApp {
    BaseApp baseApp = new BaseApp();
    //调取baseAPP下滑手势方法
    public void swipToDown(AndroidDriver driver){
        baseApp.swipeToDown(driver);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //调用baseApp点击方法
    public void tap(AndroidDriver driver){
        //点击具体坐标
        baseApp.taptest(driver, MiniParamsData.X,MiniParamsData.Y);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * 执行adb命令tap点击、text输入
     * */
    public void adbInput(AndroidDriver driver) {
        baseApp.adbInput(driver,MiniParamsData.ADBIPUT);
    }
}
