package tests.Excercises;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private final int COMPANY_COLUMN = 1, COUNTRY_COLUMN = 3;

    @BeforeClass
    public void beforeClass() throws IOException {
        testProps = propertyUtils.getPropertiesData();
        webDriver.get("https://www.w3schools.com/html/html_tables.asp");
    }

    @Test
    public void getTextFromTable() {
        Set<String> strings = testProps.stringPropertyNames();
        for (String key : strings) {
            Assert.assertTrue(tableUtils.verifyTableCellText(tablePage.table_customer(), COMPANY_COLUMN, key, COUNTRY_COLUMN, testProps.getProperty(key)));
        }

        logger.info("All text in cells match");
    }

    @Test
    public void getTextFromTable_mismatch() {
        Assert.assertFalse(tableUtils.verifyTableCellText(tablePage.table_customer(), COMPANY_COLUMN, "Ernst Handel", COUNTRY_COLUMN, testProps.getProperty("invalidText")));
        logger.info("Text in cell mismatch");
    }
}
