package com.pageFactory;

import com.testBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends TestBase implements Constants {

    public void verifyElementIsPresent(String elementXpath) {
        WebElement element = driver.findElement(By.xpath(elementXpath));
        waitForElementToBeVisible(element);
        element.isDisplayed();
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
