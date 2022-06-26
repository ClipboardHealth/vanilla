package com.testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class TestBase {

    public static Properties prop;
    public static FileInputStream fip;
    public static String Browser;
    public static String Environment;
    public static WebDriver driver;
    public static Logger log;
    public static SoftAssert st;

    @BeforeSuite
    public static void openBrowser() throws Throwable {
        BasicConfigurator.configure();
        st = new SoftAssert();
        prop = new Properties();
        log = Logger.getLogger("devpinoyLogger");
        fip = new FileInputStream("src/test/java/config/GlobalProperties.Properties");
        prop.load(fip);
        Browser = prop.getProperty("Browser");
        Environment = prop.getProperty("Env");
        if (Environment.equalsIgnoreCase("local")) {
            LocalExecution();
        } else if (Environment.equalsIgnoreCase("selenium_grid")) {
            RemoteExecution();
        }

    }

    private static void LocalExecution() {
        if (Browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (Browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (Browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        InitialSetup(driver);

    }

    private static void RemoteExecution() throws MalformedURLException {
        String Selenium_Grid_URL = prop.getProperty("Selenium_Grid_URL");
        if (Browser.equalsIgnoreCase("chrome")) {
            driver = new RemoteWebDriver(new URL(Selenium_Grid_URL), new ChromeOptions());
        } else if (Browser.equalsIgnoreCase("firefox")) {
            driver = new RemoteWebDriver(new URL(Selenium_Grid_URL), new FirefoxOptions());
        } else if (Browser.equalsIgnoreCase("ie")) {
            driver = new RemoteWebDriver(new URL(Selenium_Grid_URL), new InternetExplorerOptions());
        } else if (Browser.equalsIgnoreCase("safari")) {
            driver = new RemoteWebDriver(new URL(Selenium_Grid_URL), new SafariOptions());
        }
        InitialSetup(driver);
    }

    private static void InitialSetup(WebDriver driver) {
    }

    @AfterSuite
    public static void closeBrowser() {
        driver.quit();
    }


}
