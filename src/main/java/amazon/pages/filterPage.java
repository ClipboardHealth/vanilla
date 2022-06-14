package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import amazon.utils.utils;
import amazon.consts.consts;

public class filterPage {

    protected WebDriver driver;
    protected utils utils;

    public filterPage(WebDriver driver) {
        this.driver = driver;
        utils = new utils(driver);
    }

    public void sortByPriceHighToLow() {
        utils.click(By.cssSelector(consts.SORT_DROPDOWN_CSS));
        utils.click(By.linkText(consts.SORT_DROPDOWN_BY_HIGH_TO_LOW_LINKTEXT));
    }
}