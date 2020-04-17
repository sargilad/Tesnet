package tests.utils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Main777Page {
    WebDriver webDriver;
    public static By button_langButton_locator = By.xpath("//a[@class='langBUtton']");


    public Main777Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public WebElement button_langButton() {
        return webDriver.findElement(button_langButton_locator);
    }
}
