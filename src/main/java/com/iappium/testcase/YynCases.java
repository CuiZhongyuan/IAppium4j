package com.iappium.testcase;

import com.iappium.basepage.BaseTest;
import com.iappium.page.service.AnJianJuShuaTiBaoService;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.iappium.listener.AssertListener.class)
public class YynCases extends BaseTest {
    /**
     * 测试示例用例,继承BaseTest获取driver
     * 操作层
     */
    @Autowired
    AnJianJuShuaTiBaoService anJianJuShuaTiBaoService;
    //进入被测APP
    @Severity( SeverityLevel.NORMAL)
    @Description("ly-进入安工小程序")
    @Test
    public void enterMini() {
      //通过测试父类打开微信APP-BaseAndroidDriver通过yaml配置启动
        // 下拉操作+点击被测小程序
        anJianJuShuaTiBaoService.startMini(driver);
    }

    //进入微信小程序-点击福利-免费领课
    @Severity( SeverityLevel.NORMAL)
    @Description("ly-进入安工小程序")
    @Test
    public void tengXunKeTang() {
        //通过测试父类打开微信APP-BaseAndroidDriver通过yaml配置启动
        // 下拉操作+点击被测小程序
        anJianJuShuaTiBaoService.startTx(driver);
    }

}
