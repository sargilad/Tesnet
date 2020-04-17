package tests.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverInstance {

    private static WebDriverInstance singleton = null;
    private WebDriver webDriver;

    private WebDriverInstance() {
        webDriver = new ChromeDriver();

    }

    public static WebDriverInstance getInstance() {
        if (singleton == null) {
            singleton = new WebDriverInstance();
        }
        return singleton;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

}
