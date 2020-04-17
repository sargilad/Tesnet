package tests.utils;

import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableUtils {
    private static final Logger logger = LogManager.getLogger(TableUtils.class);
    ExtentTest extentTest;

    public void setExtentTest(ExtentTest extentTest) {
        this.extentTest = extentTest;
    }

    public String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        return getTableCellTextByXpath(table, searchColumn, searchText, returnColumnText);
    }

    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) {
        String cellText = getTableCellText(table, searchColumn, searchText, returnColumnText);
        boolean equals = cellText.equals(expectedText);
        if (!equals) {
            logger.info("Expected text (" + expectedText + ") from cell does not match actual text (" + cellText + ")");
            extentTest.info("Expected text (" + expectedText + ") from cell does not match actual text (" + cellText + ")" );
        } else {
            logger.info("Expected text (" + expectedText + ") from cell matches actual text (" + cellText + ")");
            extentTest.info("Expected text (" + expectedText + ") from cell matches actual text (" + cellText + ")");
        }

        return equals;
    }

    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        WebElement tdElement = table.findElement(By.xpath("//td[contains(., '" + searchText + "')]"));

        List<WebElement> tdElements = table.findElements(By.xpath("//tbody[1]/tr/td[" + searchColumn + "]"));
        int row = tdElements.indexOf(tdElement) - 1;
        String text = table.findElement(By.xpath("//tbody[1]/tr[" + row + "]/td[" + returnColumnText + "]")).getText();
        logger.info("Data retrieved from cell by xpath (" + text + ")");
        extentTest.info("Data retrieved from cell by xpath (" + text + ")");

        return text;
    }
}
