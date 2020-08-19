package com.iappium.handle;


import com.iappium.page.EnterMiniPage;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;

/**
 * 操作层
 *
 * @author czy
 * @version 1.0.0
 * @date 2020/8/1 23:26
 */

/**
 * 登录页面操作
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/8/4 14:31
 */
@Slf4j
public class EnterMiniHandle {
    /**
     * 进入登录页面
     * @param driver
     */
    EnterMiniPage elementPage = new EnterMiniPage();
    public void weixin(AndroidDriver driver) {

        /**
         *启动被测小程序并下滑微信手势操作
         * */
        elementPage.swipToDown(driver);
        //点击被测小程序坐标
        elementPage.tap(driver);
        //通过adb命令点击坐标
//        elementPage.adbInput();
    }
}
