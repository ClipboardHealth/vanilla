package com.amazon;
import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;

import com.amazon.base.BaseTestModule;
import com.amazon.pages.HomePage;
import com.typesafe.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSandbox extends BaseTestModule {
 


	@Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void assertThatHomePageTitleIsCorrect() {
    	getDriver().get(getUrl());
    	HomePage page = (HomePage) getPage(getDriver(), HomePage.class);
        assertEquals("Amazon.com. Spend less. Smile more.", page.getTitle());
        System.out.println(page.getNaveLinks().size());
    }
    
   
}
