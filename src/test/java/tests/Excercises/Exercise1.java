package tests.Excercises;

import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.base.BaseTestClass;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Exercise1 extends BaseTestClass {
    private static final Logger logger = LogManager.getLogger(Exercise1.class);
    Properties testProps;

    @BeforeClass
    public void beforeClass() throws IOException {
        testProps = propertyUtils.getPropertiesData("SevenData.properties");
    }


    @Test
    public void languageValidateTest() {
        ExtentTest extentTest = extent.createTest("languageValidateTest");

        //goto main
        testBlocks.openMainPage();
        extentTest.info("opened main page");

        //get available languages
        List<String> availableLanguages = main777PageObjects.getAvailableLanguages();
        extentTest.info("Available languages retrieved from floating menu");

        //validate languages
        Assert.assertTrue("Page redirect by language failed", sevenTestUtils.isLangLinkValid(availableLanguages, testProps));
        extentTest.info("page redirect by language validated");


    }


}
