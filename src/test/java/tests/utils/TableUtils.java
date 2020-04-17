package tests.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableUtils {
    WebDriver webDriver;

    public TableUtils(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public TableUtils() {
    }

    public String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        return getTableCellTextByXpath(table, searchColumn, searchText, returnColumnText);
    }

    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) {
        String cellText = getTableCellText(table, searchColumn, searchText, returnColumnText);
        return cellText.equals(expectedText);
    }

    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        WebElement tdElement = table.findElement(By.xpath("//td[contains(., '" + searchText + "')]"));

        List<WebElement> tdElements = table.findElements(By.xpath("//tbody[1]/tr/td[" + searchColumn + "]"));
        int row = tdElements.indexOf(tdElement) - 1;
        return table.findElement(By.xpath("//tbody[1]/tr[" + row + "]/td[" + returnColumnText + "]")).getText();
    }
}
