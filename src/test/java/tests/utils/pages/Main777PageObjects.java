package tests.utils.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.utils.CommonUtils;
import tests.utils.Consts;

import java.util.ArrayList;
import java.util.List;

public class Main777PageObjects {
    private static final Logger logger = LogManager.getLogger(Main777PageObjects.class);

    WebDriver webDriver;
    Main777Page main777Page;
    WebDriverWait wait;
    CommonUtils commonUtils;

    public Main777PageObjects(WebDriver webDriver, WebDriverWait wait, CommonUtils commonUtils) {
        this.webDriver = webDriver;
        main777Page = new Main777Page(webDriver);
        this.wait = wait;
        this.commonUtils = commonUtils;
    }

    public void gotoMainPage() {
        webDriver.get(Consts.SEVEN_URL);
    }

    //return list of available languages
    public List<String> getAvailableLanguages() {
        commonUtils.waitForPageLoaded();
        mouseOver(main777Page.button_langButton());

        //get content of list
        List<WebElement> langDropDownelements = webDriver.findElements(Main777Page.DROP_DOWN_LANGUAGES_LOCATIOR);

        List<String> langList = new ArrayList<String>();
        for (WebElement element : langDropDownelements) {
            String lang = element.getText();
            logger.info("Available language: " + lang);
            langList.add(lang);
        }

        return langList;


    }


    public void selectLanguage(String language) {
        commonUtils.waitForPageLoaded();
        mouseOver(main777Page.button_langButton());

        //select language
        webDriver.findElement(By.xpath("//a[contains(text(),'" + language + "')]")).click();

    }

    public void mouseOver(WebElement webElement) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).perform();
    }


}
