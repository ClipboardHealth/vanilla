package amazon.utils;

import amazon.factories.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SynchronizationUtils {
    private WebDriver driver = DriverFactory.getDriver();

    public void waitUntilElementIsVisible(By by){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
