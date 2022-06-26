package com.testCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.pageFactory.HomePage;

public class Test1 extends HomePage {
    @Test
    public void testCase1() throws Throwable {
        //openBrowser();
        HomePage hp = new HomePage();
        //Step1: Open https://www.amazon.in/
        driver.navigate().to("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        hp.verifyElementIsPresent(Xpath_Todays_Deals);
        closeBrowser();
    }

}
