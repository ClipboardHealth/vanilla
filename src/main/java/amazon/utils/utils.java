package amazon.utils;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utils {

    protected WebDriver driver;

    public utils(WebDriver driver){
        this.driver = driver;
    }
    
    public void waitForElementToBePresent(By we){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(we));
    }

    public void hoverAndClick(By we) {
        Actions action = new Actions(driver);
        waitForElementToBePresent(we);
        action.moveToElement(driver.findElement(we)).click().build().perform();
    }

    public void click(By we) {
        waitForElementToBePresent(we);
        driver.findElement(we).click();
    }

    public void switchTab(int tabIndex){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabIndex));
    }
}
