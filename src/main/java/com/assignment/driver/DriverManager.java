package com.assignment.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager(){}

    private static final ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadSafeDriver.get();
    }
    public static void setDriver(WebDriver driver){
        threadSafeDriver.set(driver);
    }
    public static void unload(){
        getDriver().quit();
        threadSafeDriver.remove();
    }

}
