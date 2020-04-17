package tests.utils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TablePage {
    WebDriver webDriver;
    public static By customer_table_locator = By.xpath("//table[@id='customers']");


    public TablePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public WebElement table_customer() {
        return webDriver.findElement(customer_table_locator);
    }
}
