package amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import amazon.utils.utils;
import amazon.consts.consts;

public class articlePage {

    protected WebDriver driver;
    protected utils utils;

    public articlePage(WebDriver driver) {
        this.driver = driver;
        utils = new utils(driver);
    }

    public String getAboutThisItemSectionText() {
        utils.waitForElementToBePresent(By.cssSelector(consts.ABOUT_THIS_ITEM_SECTION_TEXT_CSS));
        return driver.findElement(By.cssSelector(consts.ABOUT_THIS_ITEM_SECTION_TEXT_CSS)).getText();
    }

    public List<WebElement> getBulletList() {
        utils.waitForElementToBePresent(By.cssSelector(consts.ABOUT_THIS_ITEM_BULLETS_CSS));
        return driver.findElements(By.cssSelector(consts.ABOUT_THIS_ITEM_BULLETS_CSS));
    }
}