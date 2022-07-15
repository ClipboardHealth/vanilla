package com.assignment.driver.remoteimpl;

import com.assignment.config.factory.ConfigFactory;
import com.assignment.driver.abstraction.IRemoteDriver;
import com.assignment.driver.enums.DriverType;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SeleniumGrid implements IRemoteDriver {

    @SneakyThrows
    @Override
    public WebDriver getDriver(){
        WebDriver driver;
        DesiredCapabilities capabilities= new DesiredCapabilities();
        if (ConfigFactory.getConfig().browser() == DriverType.EDGE) {
            capabilities.setBrowserName(BrowserType.EDGE);
        } else {
            capabilities.setBrowserName(BrowserType.CHROME);
        }
        driver = new RemoteWebDriver(new URL(ConfigFactory.getConfig().gridPath()),capabilities);
        return driver;
    }
}
