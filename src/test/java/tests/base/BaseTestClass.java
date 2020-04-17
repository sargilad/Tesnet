package tests.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tests.utils.*;
import tests.utils.pages.Main777PageObjects;
import tests.utils.pages.TablePage;

import java.util.concurrent.TimeUnit;

public abstract class BaseTestClass {

    public static WebDriver webDriver;
    public static WebDriverWait wait;
    public static TestBlocks testBlocks;
    public Main777PageObjects main777PageObjects;
    public SevenTestUtils sevenTestUtils;
    public PropertyUtils propertyUtils = new PropertyUtils();
    public TablePage tablePage;
    public ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver_win32/stable/chromedriver.exe");
        webDriver = WebDriverInstance.getInstance().getWebDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, 30);
        testBlocks = new TestBlocks(webDriver, wait);

        main777PageObjects = new Main777PageObjects(webDriver);
        sevenTestUtils = new SevenTestUtils();
        tablePage = new TablePage(webDriver);

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent.attachReporter(htmlReporter);





    }

    @AfterSuite
    public void afterSuite() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }

        extent.flush();
    }


}
