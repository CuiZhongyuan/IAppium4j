package com.iappium.utils;

/**
 * 截图工具类
 *
 * @author czy
 * @version 1.0.0
 * @date 2020/8/1 23:30
 */

import com.iappium.basepage.BaseAndroidDriver;
import com.iappium.basepage.BaseConfig;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 截图工具
 *
 * @author czy
 * @version 1.0.0
 * @date 2020/1/22
 */
@Slf4j
public class ScreenshotUtil {

    public static void snapshot(AndroidDriver driver) {
        String currentPath = "F:\\00_3IdeaProjects\\gitHubers\\AppAutomation\\src\\main\\resources\\img";
        String imgName = DateUtils.getTimeMillis();
        File screenShotFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File(currentPath+"\\"+imgName + "test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}