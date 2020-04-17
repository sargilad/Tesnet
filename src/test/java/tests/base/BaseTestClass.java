package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tests.utils.SevenTestUtils;
import tests.utils.TestBlocks;
import tests.utils.WebDriverInstance;
import tests.utils.pages.Main777PageObjects;

import java.util.concurrent.TimeUnit;

public abstract class BaseTestClass {

    public static WebDriver webDriver;
    public static WebDriverWait wait;
    public static TestBlocks testBlocks;
    public Main777PageObjects main777PageObjects;
    public SevenTestUtils sevenTestUtils;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver_win32/stable/chromedriver.exe");
        webDriver = WebDriverInstance.getInstance().getWebDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, 30);
        testBlocks = new TestBlocks(webDriver, wait);

        main777PageObjects = new Main777PageObjects(webDriver);
        sevenTestUtils = new SevenTestUtils();

    }

    @AfterSuite
    public void afterSuite() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }


}
