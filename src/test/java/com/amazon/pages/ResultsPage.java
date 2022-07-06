package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amazon.base.WrappedWebDriver;
//Result Page Object
public class ResultsPage implements BasePage {
	private final WrappedWebDriver driver;
	private static final int DEFAULT_WAIT = 300;
	private final By sortByDropdown = By.id("a-autoid-0-announce");
	private final By resultItem = By.cssSelector(".s-result-list.s-main-slot .s-result-item");

	public ResultsPage(WrappedWebDriver driver) {
		this.driver = driver;
		verifyPage();
	}

	public void clickSortByDropdown() {
		driver.findElement(sortByDropdown).click();
	}

	public void sortBy(SortBy type) {
		clickSortByDropdown();
		driver.findElement(By.linkText(type.getSortType())).click();

	}

	private List<WebElement> getResultItemList() {
		return driver.findElements(resultItem);

	}

	public void clickResultItemIndex(int index) {
		getResultItemList().get(index).click();

	}

	public void openAndSwitchToResultItemIndex(int index) {
		String currentWindow = driver.getWindowHandle();
		clickResultItemIndex(index);
		for (String window : driver.getWindowHandles()) {
			if (!window.equals(currentWindow)) {
				driver.switchTo().window(window);
			}
		}

	}

	public enum SortBy {
		PRICE_HIGH_TO_LOW("Price: High to Low"), PRICE_LOW_TO_HIGH("Price: Low to High"),
		// all the menu items can be added in the enum
		NEWEST_ARRIVALS("Newest Arrivals");

		public final String type;

		SortBy(String type) {
			this.type = type;
		}

		public String getSortType() {
			return type;
		}

	}

	@Override
	public void verifyPage() {
		driver.waitUntilElementVisible(driver.findElement(sortByDropdown), DEFAULT_WAIT);

	}

}
