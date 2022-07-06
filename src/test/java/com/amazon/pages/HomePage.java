package com.amazon.pages;

import org.openqa.selenium.By;
import com.amazon.base.WrappedWebDriver;
import com.amazon.components.TopNavBar;
//Home Page Object
public class HomePage implements BasePage {
	private final WrappedWebDriver driver;
	private By topNavBar = By.id("navbar-main");
	private static final int DEFAULT_WAIT = 300;

	public HomePage(WrappedWebDriver driver) {
		this.driver = driver;
		verifyPage();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public TopNavBar getTopNavBar() {
		return new TopNavBar(driver, driver.findElement(topNavBar));

	}

	@Override
	public void verifyPage() {
		driver.waitUntilElementVisible(driver.findElement(topNavBar), DEFAULT_WAIT);
	}

}
