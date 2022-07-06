package com.amazon.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amazon.base.WrappedWebDriver;
import com.amazon.base.WrappedWebElement;

public class BrandSection extends WrappedWebElement {
	private WrappedWebElement element;
	private WrappedWebDriver driver;

	public BrandSection(WrappedWebDriver driver, WebElement element) {
		super(driver, element);
		this.element = new WrappedWebElement(driver, element);
		this.driver = driver;
	}

	public void clickBrandNameFilter(BrandNames brandName) throws InterruptedException {
		driver.waitUntilElementVisible(element.findElement(By.linkText(brandName.getBrandNamesText())), 300);
		element.findElement(By.linkText(brandName.getBrandNamesText())).click();
		driver.wait(500);

	}

	public enum BrandNames {
		ONE_PLUS("OnePlus"), 
		SAMSUNG("Samsung"),
		// all the menu items can be added in the enum
		LG("LG");

		public final String name;

		BrandNames(String name) {
			this.name = name;
		}

		public String getBrandNamesText() {
			return name;
		}

	}

}
