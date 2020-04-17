package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tests.utils.WebDriverInstance;

import java.util.concurrent.TimeUnit;

public abstract class BaseTestClass {

    public static WebDriver webDriver;
    public static WebDriverWait wait;
    public static TestBlocks testBlocks;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver_win32/stable/chromedriver.exe");
        webDriver = WebDriverInstance.getInstance().getWebDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, 10);
        testBlocks = new TestBlocks(webDriver, wait);
    }

    @AfterSuite
    public void afterSuite() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }


}
