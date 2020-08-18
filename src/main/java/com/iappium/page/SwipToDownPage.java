package com.iappium.page;

import com.iappium.basepage.BaseApp;

/**
 * 元素层
 *
 * @author czy
 * @version 1.0.0
 * @date 2020/8/1 23:26
 */
public class SwipToDownPage {

    StartAppDriverPage startAppDriverPage = new StartAppDriverPage();
    BaseApp baseApp = new BaseApp();
    //调取baseAPP下滑手势方法
    public void swipToDown(){
        baseApp.swipeToDown(startAppDriverPage.start());
    }
}
