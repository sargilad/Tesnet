package tests.utils.pages;

import org.openqa.selenium.WebDriver;
import tests.utils.Consts;

public class Main777PageObjects {
    WebDriver webDriver;
    Main777Page main777Page;

    public Main777PageObjects(WebDriver webDriver) {
        this.webDriver = webDriver;
        main777Page = new Main777Page(webDriver);
    }

    public void gotoPage() {
        webDriver.get(Consts.SEVEN_URL);
    }

}
