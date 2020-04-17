package tests.Excercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.base.BaseTestClass;
import tests.utils.TableUtils;

import java.util.List;

public class Exercise2 extends BaseTestClass {


    @Test
    public void getTextFromTable(){

        TableUtils tableUtils = new TableUtils();
        webDriver.get("https://www.w3schools.com/html/html_tables.asp");
        WebElement table = webDriver.findElement(By.xpath("//table[@id='customers']"));
        Boolean valid = tableUtils.verifyTableCellText(table, 1, "Island Trading", 3,"UK");


    }
}
