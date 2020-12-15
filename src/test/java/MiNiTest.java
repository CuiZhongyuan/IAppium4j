import com.iappium.basepage.BaseApp;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MiNiTest extends BaseApp {

    @Test
    public void miniTest(){
        //引用配置参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("appPackage", "com.tencent.mm");
        capabilities.setCapability("appActivity", "com.tencent.mm.ui.LauncherUI");
        capabilities.setCapability("automationName", "uiautomator1");
        capabilities.setCapability("deviceName","小程序测试");
        capabilities.setCapability("chromedriverExecutable", "D:\\work\\IAppium4j\\src\\main\\resources\\chromedriver\\chromedriver.exe");
        capabilities.setCapability("platformVersion","7.0");
        capabilities.setCapability("unicodeKeyboard",true);
        capabilities.setCapability("noReset",true);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("androidProcess", "com.tencent.mm:toolsmp");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        capabilities.setCapability("adbPort",5083);
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        AndroidDriver  driver = new AndroidDriver(url, capabilities);
        //进入微信下拉滑动
        swipeToDown(driver);
        //点击被测小程序，通过坐标点击
        taptest(driver,190,664);
    }

}
