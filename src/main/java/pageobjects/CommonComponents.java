package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonComponents {

        public void scrollintoview(WebDriver driver,WebElement element){
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
        }

}
