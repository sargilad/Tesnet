package tests.Excercises;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import tests.base.BaseTestClass;
import tests.utils.Consts;

public class Excercise1 extends BaseTestClass {

    private static final Logger logger = LogManager.getLogger(Excercise1.class);

    @Test
    public void languageValidateTest(){
        //goto main
        testBlocks.openMainPage();

        //get available languages
        main777PageObjects.getAvailableLanguages();

        //validate languages
        sevenTestUtils.isLangLinkValid();






    }




}
