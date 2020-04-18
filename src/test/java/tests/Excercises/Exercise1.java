package tests.Excercises;

import com.aventstack.extentreports.ExtentTest;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.base.BaseTestClass;
import tests.utils.SevenTestUtils;
import tests.utils.pages.Main777PageObjects;

import java.io.IOException;
import java.util.List;

public class Exercise1 extends BaseTestClass {

    @BeforeClass
    public void beforeClass() throws IOException {
        testProps = propertyUtils.getPropertiesData("SevenData.properties");
        main777PageObjects = new Main777PageObjects(webDriver, wait);
        sevenTestUtils = new SevenTestUtils(main777PageObjects, webDriver, wait);
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
