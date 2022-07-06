package com.amazon.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amazon.base.WrappedWebDriver;
import com.amazon.base.WrappedWebElement;

public class TopNavBar extends WrappedWebElement {
	private WrappedWebElement element;
	private WrappedWebDriver driver;
	private final By hamburgerMenu = By.id("nav-hamburger-menu");
	private final By hMenuContent = By.id("nav-hamburger-menu");
	private static final int DEFAULT_WAIT = 300;

	public TopNavBar(WrappedWebDriver driver, WebElement element) {
		super(driver, element);
		this.element = new WrappedWebElement(driver, element);
		this.driver = driver;
	}

	public WrappedWebElement getHamburgerMenu() {
		return element.findElement(hamburgerMenu);
	}

	public HamburgerMenuContent clickHamburegerMenu() {
		driver.waitUntilElementVisible(getHamburgerMenu(), DEFAULT_WAIT);
		getHamburgerMenu().click();
		driver.waitUntilElementVisible(driver.findElement(hMenuContent), DEFAULT_WAIT);
		return new HamburgerMenuContent(driver, driver.findElement(hMenuContent));

	}

}
