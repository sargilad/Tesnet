package tests.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import tests.utils.*;
import tests.utils.pages.Main777PageObjects;
import tests.utils.pages.TablePage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTestClass {

    public static WebDriver webDriver;
    public static WebDriverWait wait;
    public static TestBlocks testBlocks;
    public Main777PageObjects main777PageObjects;
    public SevenTestUtils sevenTestUtils;
    public PropertyUtils propertyUtils = new PropertyUtils();
    public TablePage tablePage;
    public static ExtentReports extent;
    public Properties testProps;


    @BeforeTest
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver_win32/stable/chromedriver.exe");
        webDriver = WebDriverInstance.getInstance().getWebDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, 10);
        testBlocks = new TestBlocks(webDriver, wait);

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = ExtentInstance.getInstance().getExtentReport();
        extent.attachReporter(htmlReporter);


    }

    @AfterTest
    public void afterSuite() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }

        extent.flush();
    }


}
