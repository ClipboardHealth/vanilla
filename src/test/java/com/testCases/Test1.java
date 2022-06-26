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
        //Step2: Click on the hamburger menu in the top left corner
        hp.clickOnElement(Xpath_Hamburger_Menu);
        //Step3: Scroll own and then Click on the TV, Appliances and Electronics link under Shop by Department section
        hp.clickOnElement(Xpath_TvAppliancesDept_Link);
        //Step 4: Then click on Televisions under Tv, Audio & Cameras sub-section
        hp.clickOnElement(Xpath_Televisions);
        //Step 5: Scroll down and filter the results by Brand ‘Samsung
        hp.scrollToElement(Xpath_Samsung_Branch_Checkbox);
        hp.waitForElementToBeClickable(Xpath_Samsung_Branch_Checkbox);
        Thread.sleep(3000);
        hp.clickOnElement(Xpath_Samsung_Branch_Checkbox);
        //Step 6: Sort the Samsung results with price High to Low
        hp.waitForElementToBeClickable(Xpath_Sort_Items_Price);
        hp.clickOnElement(Xpath_Sort_Items_Price);
        Thread.sleep(2000);
        hp.clickOnElement(Xpath_Sort_Price_LowToHigh);
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        //Step 7:Click on the second highest priced item
        hp.clickOnElement(Xpath_Second_Result_Item);
        hp.switchToWindow();
        closeBrowser();
    }

}
