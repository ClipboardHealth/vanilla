package com.assignment.tests;

import com.assignment.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp(){
        Driver.getInstance().setUpDriver().loadURL().maximiseWindow();
    }

    @AfterMethod
    public void tearDown(){
        Driver.getInstance().tearDownDriver();
    }

}
