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

    public void gotoMainPage() {
        webDriver.get(Consts.SEVEN_URL);
    }

    //return list of available languages
    public void getAvailableLanguages(){
        //mouse over

        //get content of list


        //log all available languages


    }


    public void selectLanguage(){

        //mouse over

        //select language



    }



}
