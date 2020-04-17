package tests.Excercises;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.base.BaseTestClass;
import tests.utils.TableUtils;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Exercise2 extends BaseTestClass {
    private static final Logger logger = LogManager.getLogger(Exercise2.class);

    TableUtils tableUtils = new TableUtils();
    Properties testProps;

    @BeforeClass
    public void beforeClass() throws IOException {
        testProps = propertyUtils.getPropertiesData();
        webDriver.get("https://www.w3schools.com/html/html_tables.asp");
    }

    @Test
    public void getTextFromTable() {
        WebElement table = webDriver.findElement(By.xpath("//table[@id='customers']"));

        Set<String> strings = testProps.stringPropertyNames();
        for (String key : strings) {
            Assert.assertTrue(tableUtils.verifyTableCellText(table, 1, key, 3, testProps.getProperty(key)));
        }

        logger.info("All text in cells match");
    }

    @Test
    public void getTextFromTable_mismatch() {
        WebElement table = webDriver.findElement(By.xpath("//table[@id='customers']"));

            Assert.assertFalse(tableUtils.verifyTableCellText(table, 1, "Ernst Handel", 3, testProps.getProperty("invalidText")));

        logger.info("Text in cell mismatch");
    }
}
