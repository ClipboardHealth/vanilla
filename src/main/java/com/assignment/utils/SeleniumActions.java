package com.assignment.utils;

import com.assignment.constants.FrameworkConstants;
import com.assignment.driver.DriverManager;
import com.assignment.reports.FrameworkLogger;
import com.assignment.reports.enums.LogType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public final class SeleniumActions {

    private SeleniumActions(){}

    public static void waitAndClick(By by,String elementname){
        waitForElementToBePresent(by).click();
        FrameworkLogger.log(LogType.PASS,elementname+ " is clicked successfully");
    }
    public static String getText(By by){
        return waitForElementToBePresent(by).getText();
    }

    public static void selectValueInDropDown(By by, Consumer<Select> consumer) {
        WebElement element = waitForElementToBePresent(by);
        Select select = new Select(element);
        consumer.accept(select);
        FrameworkLogger.log(LogType.PASS,element+ " is selected from the drop-down");
    }

    public static void switchToNewlyOpenedWindow(){
        String parentWinHandle = DriverManager.getDriver().getWindowHandle();

        Set<String> winHandles = DriverManager.getDriver().getWindowHandles();
        for(String temp:winHandles) {
            if(!temp.equalsIgnoreCase(parentWinHandle)) {
                DriverManager.getDriver().switchTo().window(temp);
                FrameworkLogger.log(LogType.INFO, "Switched to new window successfully");
            }
        }
    }

    public static void waitAndEnterText(By by,String value,String elementname){
        waitForElementToBePresent(by).sendKeys(value);
        FrameworkLogger.log(LogType.PASS,String.format("%s is entered in %s successfully",value,elementname));
    }

    private static WebElement waitForElementToBePresent(By by){
        return new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getTIMEOUT())
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static boolean verifyPresenceOfElement(By by){
        try{
            boolean isElementPresent = DriverManager.getDriver().findElement(by).isDisplayed();
            FrameworkLogger.log(LogType.PASS,
                    String.format("Verify the presence of element: %s", DriverManager.getDriver().findElement(by).getText()));
            return true;
        }
        catch (NoSuchElementException e)
        {
            FrameworkLogger.log(LogType.INFO, "Element is not present");
            return false;
        }
    }

    public static void logListofElements(By listValue){
        List<String> sectionText = new ArrayList<>();
        List<WebElement> listElement = DriverManager.getDriver().findElements(listValue);
        for (WebElement webElement : listElement) {
            sectionText.add(webElement.getText());
        }
        for (int i=1; i<sectionText.size();i++)
            FrameworkLogger.log(LogType.INFO, String.format("About this item section description %d : %s", i, sectionText));
    }

}
