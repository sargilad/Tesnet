package tests.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.utils.pages.Main777PageObjects;

public class TestBlocks {
    WebDriverWait wait;
    Main777PageObjects main777PageObjects;

    public TestBlocks(WebDriver webDriver, WebDriverWait wait) {
        main777PageObjects = new Main777PageObjects(webDriver);
        this.wait = wait;
    }

    public void getAvailableLanguages(){

        //goto url
        main777PageObjects.gotoPage();


    }
}
