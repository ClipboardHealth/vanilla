package amazon.utils;
import amazon.factories.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;

public class DriverManager {

    private static final Logger logger = Logger.getLogger(DriverManager.class);
    private static WebDriver driver;
    private static Set<String> windowHandles;
    private static WebDriverWait wait;
    private static Alert alert;

    private DriverManager() {
        throw new IllegalStateException("Utility class");
    }

    public static WebDriver getDriver() {
        if (null == driver || driver.toString().contains("(null)")) {
            logger.info("Creating Driver...");
            driver = DriverFactory.getDriver();
            windowHandles = new LinkedHashSet<>();
            windowHandles.add(driver.getWindowHandle());
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }
        return driver;
    }

    public static void closeDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            logger.info("Closing browser....");
        } else {
            logger.error("Driver is not initialized or browser was already closed.");
        }
    }

    public static void switchToWindowOpened() {
        try {
            getWait().until(d -> d.getWindowHandles().size() > windowHandles.size());
        } catch (TimeoutException e) {
            throw new NoSuchWindowException("New Window not found.", e);
        }
        driver.switchTo().window(
                driver.getWindowHandles().stream()
                        .filter(
                                handle -> !windowHandles.contains(handle)
                        ).findFirst().orElseThrow(
                        () -> new NoSuchWindowException("New Window not found.")
                )
        );
        windowHandles.add(driver.getWindowHandle());
    }

    public static WebDriverWait getWait() {
        if (wait == null) getDriver();
        return wait;
    }
}
