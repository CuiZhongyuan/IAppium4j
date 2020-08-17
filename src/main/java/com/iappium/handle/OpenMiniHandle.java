package com.iappium.handle;


import com.iappium.page.SwipToDownPage;
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
public class OpenMiniHandle {
    /**
     * 进入登录页面
     */
    public void weixin() {

        /**
         *启动被测小程序并下滑微信手势操作
         * */
        SwipToDownPage swipToDownPage = new SwipToDownPage();
        swipToDownPage.swipToDown();
    }

}
