package amazon.uiutils;

import amazon.utils.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumUtils {

    final static Logger logger = Logger.getLogger(SeleniumUtils.class);

    public static String parentWindow;

    public static void openURL(String url) {
        if (DriverManager.getDriver() != null) {
            if (!url.equalsIgnoreCase((DriverManager.getDriver().getCurrentUrl()))) {
                try {
                    DriverManager.getDriver().get(url);
                    logger.info("Navigating to URL:" + url);
                    parentWindow = DriverManager.getDriver().getWindowHandle();
                } catch (Exception e) {
                    logger.error("Exception occurred while navigating to URL:" + url + ", Exception details:" + e.getMessage());
                    e.printStackTrace();
                    throw (e);
                }
            } else
                logger.info("Already on home page...");
        } else {
            logger.error("Driver is not initialized or browser is now closed.");
            throw new WebDriverException("Driver is not initialized or browser is now closed.");
        }

    }

    public static void selectValue(By elementBy, String optionValue) {

        if (DriverManager.getDriver() != null) {
            try {
                DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(elementBy));
                Select dropdown = new Select(DriverManager.getDriver().findElement(elementBy));
                dropdown.selectByVisibleText(optionValue);
                logger.info("Value selected from dropdown for " + elementBy.toString() + " as :" + optionValue);
            } catch (ElementNotVisibleException e) {
                logger.error("WebElement(dropdown) not found hence unable to select value:" + optionValue);
                throw (e);
            } catch (Exception e) {
                logger.error("Exception occurred while selecting value from dropdown:" + e.getMessage());
                e.printStackTrace();
                throw (e);
            }
        } else {
            logger.error("Driver is not initialized or browser is now closed.");
            throw new WebDriverException("Driver is not initialized or browser is now closed.");
        }
    }

    public static void click(By elementBy) {
        Click(elementBy, 10);
    }

    public static void Click(By elementBy, int implicitWaitSec) {
        if (DriverManager.getDriver() != null) {
            boolean elementFound = false;
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSec));
            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(elementBy));
            List<WebElement> elements = DriverManager.getDriver().findElements(elementBy);
            for (WebElement el : elements) {
                if (!elementFound) {
                    try {
                        DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(el));
                        new Actions(DriverManager.getDriver()).click(el).build().perform();
                        logger.info("Clicked on:" + el);
                        elementFound = true;
                        break;
                    } catch (Exception e) {
                        elementFound = false;
                    }
                }
            }
            if (!elementFound) {
                logger.error("WebElement not found hence unable to perform click operation for:" + elementBy.toString());
                throw new ElementNotVisibleException("WebElement not found hence unable to perform click operation: " + elementBy.toString());
            }
        } else {
            logger.error("Driver is not initialized or browser is now closed.");
            throw new WebDriverException("Driver is not initialized or browser is now closed.");
        }


    }

    public static boolean checkIfExists(By elementBy, int timeoutInMillis) {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(timeoutInMillis));
            try {
                List<WebElement> elementsFound = DriverManager.getDriver().findElements(elementBy);
                if (elementsFound != null) {
                    for (WebElement el : elementsFound) {
                        if (el.isDisplayed()) {
                            logger.info("Web element found on screen:" + elementBy.toString());
                            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
                            return true;
                        }
                    }
                    logger.info("Number of elements exists:" + elementsFound.size() + " for:" + elementBy.toString());
                }
            } catch (Exception e) {
                logger.error("Element not found on screen:" + elementBy.toString());
                e.printStackTrace();
                DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
                return false;
            }
        } else {
            logger.error("Driver is not initialized or browser is now closed.");
            throw new WebDriverException("Driver is not initialized or browser is now closed.");
        }
        DriverManager.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return false;
    }

    public static boolean checkIfExists(By elementBy) {
        return checkIfExists(elementBy, 5000);
    }

    public static String getCurrentURL() {
        return DriverManager.getDriver().getCurrentUrl();
    }

    public static void scrollToElement(By by) {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement element = DriverManager.getDriver().findElement(by);
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", element);
        logger.info("Scroll performed to specific element:" + element.toString());
    }

    public static String getValue(By locator) {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (DriverManager.getDriver() != null) {
            return DriverManager.getDriver().findElement(locator).getText();
        } else {
            logger.error("Driver is not initialized or browser is now closed.");
            throw new WebDriverException("Driver is not initialized or browser is now closed.");
        }
    }

    public static void waitUntil(int waitMillis, By elementBy) {
        Wait wait = new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofMillis(waitMillis))
                .ignoring(NoSuchElementException.class);

        if (DriverManager.getDriver() != null) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
        } else {
            logger.error("Driver is not initialized or browser is now closed.");
            throw new WebDriverException("Driver is not initialized or browser is now closed.");
        }
    }

}

