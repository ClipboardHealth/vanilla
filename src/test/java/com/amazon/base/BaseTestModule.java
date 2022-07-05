package com.amazon.base;
import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;

import com.amazon.pages.HomePage;
import com.typesafe.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTestModule extends PageFactory {

	private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private ThreadLocal<WrappedWebDriver> driver ;

    @BeforeEach
    void setupDriverObject() {
    	driver = new ThreadLocal<>();
    	driver.set(new WrappedWebDriver(DriverFactory.getDriver()));
    }
    
    @AfterEach
    void tearDownpDriverObject() {
    	if(null != driver) {
    	driver.get().quit();
    	}
    }
    
    public WrappedWebDriver getDriver(){
    	return driver.get(); 
    }
    
    /*
     * getUrl method will be used for all URL manipulations in future if need.
     * @return String application base url
     */
    public String getUrl() {
    	return HOME_PAGE_URL;
    }
    
    public HomePage getHomePage() {
    	return (HomePage) getPage(driver.get(), HomePage.class);
    }
    
 
}
