package tests.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.utils.pages.Main777PageObjects;

import java.util.List;
import java.util.Properties;

public class SevenTestUtils {
    private static final Logger logger = LogManager.getLogger(SevenTestUtils.class);

    Main777PageObjects main777PageObjects;
    WebDriver webDriver;
    WebDriverWait wait;

    public SevenTestUtils(Main777PageObjects main777PageObjects, WebDriver webDriver, WebDriverWait wait) {
        this.main777PageObjects = main777PageObjects;
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public boolean isLangLinkValid(List<String> availableLanguages, Properties properties) {

        //loop over languages and check each language validity
        for (String lang : availableLanguages) {
            main777PageObjects.selectLanguage(lang);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='pctopmenuContainr']//a[contains(text(),'" + properties.getProperty(lang) + "')]")));
                logger.info("Language validated: " + lang);
            } catch (Exception e) {
                logger.error("Exception while validating page according to language: " + lang + ", " + e.getMessage());
                return false;
            }
        }


        return true;
    }


}
