package com.iappium.page;

import com.iappium.basepage.BaseApp;
import io.appium.java_client.android.AndroidDriver;

/**
 * 元素层
 *
 * @author czy
 * @version 1.0.0
 * @date 2020/8/1 23:26
 */
public class EnterMiniPage {

    BaseApp baseApp = new BaseApp();
    //调取baseAPP下滑手势方法
    public void swipToDown(AndroidDriver driver){
        baseApp.swipeToDown(driver);
    }
    public void tap(AndroidDriver driver){
        //点击具体坐标
        baseApp.taptest(driver,170,694);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * 执行adb命令tap点击、text输入
     * */
    public void adbInput() {
        baseApp.adbInput("cmd /c adb shell input tap 170 694");
    }
}
