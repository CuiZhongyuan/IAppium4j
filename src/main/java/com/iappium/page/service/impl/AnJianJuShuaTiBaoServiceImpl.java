package com.iappium.page.service.impl;

import com.iappium.basepage.BaseApp;
import com.iappium.dto.UIElement;
import com.iappium.entity.TestData;
import com.iappium.page.dao.AnJianDao;
import com.iappium.page.service.AnJianJuShuaTiBaoService;
import com.iappium.utils.SaveFailureScreenUtil;
import com.iappium.utils.UIElementUtil;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AnJianJuShuaTiBaoServiceImpl extends BaseApp implements AnJianJuShuaTiBaoService {
    @Autowired
    AnJianDao anJianDao;

    @Override
    public void startMini(AndroidDriver driver) {
        //进入微信下拉滑动
        swipeToDown(driver);
        //点击被测小程序，通过坐标点击
        taptest(driver,190,664);
        //切换webview页面
        switchWebView(driver,"每日刷题");
        //下拉滑动操作
        swipeToUp(driver);
        //进入正常的web元素定位操作
        //点击模拟试卷
        UIElementUtil.clickButton("首页","点击模拟试卷",driver);
    }

    @Override
    public void startTx(AndroidDriver driver) {
        //进入微信下拉滑动
        swipeToDown(driver);
        //点击被测小程序，通过坐标点击
        taptest(driver,190,664);
        //切换webview页面--根据进入小程序首页包含关键字信息--IT互联网热门课程
        switchWebView(driver,"IT互联网热门课程");
        //点击【福利】
        UIElementUtil.clickButton("腾讯课堂","分类",driver);
    }
}
