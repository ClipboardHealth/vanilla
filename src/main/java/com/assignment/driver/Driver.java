package com.assignment.driver;

import com.assignment.config.factory.ConfigFactory;
import com.assignment.driver.factory.DriverFactory;

import java.util.Objects;

public final class Driver {

    private static final Driver driver;

    static {
        driver = new Driver();
    }

    private Driver(){}

    public static Driver getInstance() {
        return driver;
    }

    public Driver setUpDriver(){
        if (Objects.isNull(DriverManager.getDriver()))
            DriverManager.setDriver(DriverFactory.getDriver());
        return this;
    }

    public Driver loadURL(){
        String urlUnderTest = ConfigFactory.getConfig().url();
        DriverManager.getDriver().get(urlUnderTest);
        return this;
    }

    public void maximiseWindow(){
        DriverManager.getDriver().manage().window().maximize();
    }

    public void tearDownDriver(){
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.unload();
        }
    }

}
