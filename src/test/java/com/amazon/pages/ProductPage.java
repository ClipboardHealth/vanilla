package com.amazon.pages;

import org.openqa.selenium.By;

import com.amazon.base.WrappedWebDriver;
//Product Page Object
public class ProductPage implements BasePage {
	private final WrappedWebDriver driver;
	private static final int DEFAULT_WAIT = 300;
	private final By aboutThisItemLabel = By.cssSelector("#feature-bullets h1");
	private final By aboutThisItemDetails = By.cssSelector("#feature-bullets > ul");

	public ProductPage(WrappedWebDriver driver) {
		this.driver = driver;
		verifyPage();
	}

	public boolean isAboutThisItemPresent() {
		return driver.findElements(aboutThisItemLabel).size() != 0;
	}

	public String getAboutThisItemLabel() {
		return driver.findElement(aboutThisItemLabel).getText();
	}

	public String getAboutThisItemSectionText() {
		return driver.findElement(aboutThisItemDetails).getText();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	@Override
	public void verifyPage() {
		driver.waitUntilElementVisible(driver.findElement(aboutThisItemLabel), DEFAULT_WAIT);

	}

}
