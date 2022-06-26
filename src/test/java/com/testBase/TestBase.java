package com.testBase;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
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
        InitialSetup(driver);

    }

    private static void RemoteExecution() {
        InitialSetup(driver);
    }

    private static void InitialSetup(WebDriver driver) {
    }

    @AfterSuite
    public static void closeBrowser() {
        driver.quit();
    }


}
