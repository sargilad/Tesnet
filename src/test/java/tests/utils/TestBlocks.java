package tests.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.utils.pages.Main777Page;
import tests.utils.pages.Main777PageObjects;

public class TestBlocks {
    private static final Logger logger = LogManager.getLogger(TestBlocks.class);

    WebDriverWait wait;
    Main777PageObjects main777PageObjects;

    public TestBlocks(WebDriver webDriver, WebDriverWait wait) {
        main777PageObjects = new Main777PageObjects(webDriver);
        this.wait = wait;
    }

    public void openMainPage(){
        //goto url
        main777PageObjects.gotoMainPage();
        wait.until(ExpectedConditions.elementToBeClickable(Main777Page.button_langButton_locator));
        logger.debug("Redirected to login page");
    }


}
