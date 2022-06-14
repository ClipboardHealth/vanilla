package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import amazon.utils.utils;
import amazon.consts.consts;

public class resultPage {

    protected WebDriver driver;
    protected utils utils;

    public resultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectResultByIndex(int index) {
        driver.findElements(By.cssSelector(consts.MAIN_SEARCH_RESULT_IMAGES)).get(index + 1).click();
    }

}