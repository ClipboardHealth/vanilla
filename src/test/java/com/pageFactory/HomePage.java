package com.pageFactory;

import com.testBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends TestBase implements Constants {

    public void clickOnElement(String elementXpath) {
        WebElement element = driver.findElement(By.xpath(elementXpath));
        waitForElementToBeVisible(element);
        element.click();
    }

    public void scrollToElement(String elementXpath) {
        WebElement elementToFocus = driver.findElement(By.xpath(elementXpath));
        je.executeScript("arguments[0].scrollIntoView(true);", elementToFocus);
    }

    public void waitForElementToBeClickable(String elementXpath) {
        WebElement element1 = driver.findElement(By.xpath(elementXpath));
        wait.until(ExpectedConditions.elementToBeClickable(element1));
    }

    public void switchToWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public void verifyElementIsPresent(String elementXpath) {
        WebElement element = driver.findElement(By.xpath(elementXpath));
        waitForElementToBeVisible(element);
        element.isDisplayed();
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
