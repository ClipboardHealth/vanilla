package com.amazon.pages;

import org.openqa.selenium.By;

import com.amazon.base.WrappedWebDriver;
import com.amazon.components.CategoryRefinements;
import com.amazon.components.TopNavBar;
//Category Page Object
public class CategoryPage implements BasePage {
	private final WrappedWebDriver driver;
	private static final int DEFAULT_WAIT = 300;
	private final By topNavBar = By.id("navbar-main");
	private final By categoryRefinement = By.id("s-refinements");

	public CategoryPage(WrappedWebDriver driver) {
		this.driver = driver;
		verifyPage();
	}

	public CategoryRefinements getRefinementSection() {
		return new CategoryRefinements(driver, driver.findElement(By.id("s-refinements")));
	}

	public TopNavBar getTopNavBar() {
		return new TopNavBar(driver, driver.findElement(topNavBar));

	}

	@Override
	public void verifyPage() {
		driver.waitUntilElementVisible(driver.findElement(topNavBar), DEFAULT_WAIT);

	}

}
