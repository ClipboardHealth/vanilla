package com.amazon.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amazon.base.WrappedWebDriver;
import com.amazon.base.WrappedWebElement;
import com.amazon.pages.CategoryPage;

public class HamburgerMenuContent extends WrappedWebElement {
	private WrappedWebElement element;
	private WrappedWebDriver driver;
	private final By hMenuItem = By.xpath("//a[@class=\"hmenu-item\"]");
	private final By hMenuTitle = By.cssSelector("#hmenu-content .hmenu-visible .hmenu-title");
	private final By seeAll = By.linkText("See All");
	private static final int DEFAULT_WAIT = 300;

	public HamburgerMenuContent(WrappedWebDriver driver, WebElement element) {
		super(driver, element);
		this.element = new WrappedWebElement(driver, element);
		this.driver = driver;
	}

	public List<WebElement> getHamburgerMenuItems() {
		return driver.findElements(hMenuItem);
	}

	public List<WebElement> getHamburgerMenuTitles() {
		return driver.findElements(hMenuTitle);
	}

	public void clickSeeAll() throws InterruptedException {
		List<WebElement> seeAllElements = driver.findElements(seeAll);
		for (WebElement seeAll : seeAllElements) {
			WrappedWebElement seeAllElement = new WrappedWebElement(driver, seeAll);
			seeAllElement.scrollIntoView();
			seeAllElement.click();
			driver.wait(DEFAULT_WAIT);

		}
	}

	public void clickHamburgerMenuItem(HamburgerMenuSBDItems hItem) {
		for(WebElement item : getHamburgerMenuItems()) {
			if(item.getText().contains(hItem.HamburgerMenuSBDItemsText())) {
				item.click();
				break;
			}
		}
	}

	public CategoryPage clickHamburgerMenuSubItem(HamburgerMenuSubItems hItem) {
		driver.waitUntilElementVisible(element, 300);
		for(WebElement item : getHamburgerMenuItems()) {
			if(item.getText().contains(hItem.HamburgerMenuSubItemsText())) {
				item.click();
				break;
			}
		}
		return new CategoryPage(driver);
	}

	public void scrollToHaburgerTitle(HamburgerMenuTitles h_title) {
		for (WebElement title : getHamburgerMenuTitles()) {
			if (title.getText().toLowerCase().contains(h_title.getHamburgerMenuTitleText())) {
				new WrappedWebElement(driver, title).scrollIntoView();
				break;

			}
		}
	}

	public void scrollToHaburgerItem(HamburgerMenuSBDItems hItem) {
		for (WebElement title : getHamburgerMenuTitles()) {
			if (title.getText().toLowerCase().contains(hItem.HamburgerMenuSBDItemsText())) {
				new WrappedWebElement(driver, title).scrollIntoView();
				break;

			}
		}
	}

	public enum HamburgerMenuTitles {
		TRENDING("trending"), DIGITAL_CONTENT_AND_DEVICES("digital content & devices"),
		// all the hmburger menu items can be added in the enum
		SHOP_BY_DEPARTMENT("shop by department");

		public final String text;

		HamburgerMenuTitles(String text) {
			this.text = text;
		}

		public String getHamburgerMenuTitleText() {
			return text;
		}

	}

	public enum HamburgerMenuSBDItems {
		MOBILES_AND_COMPUTERS("Mobiles, Computers"), MESS_FASHION("Men's Fashion"),
		// all the hmburger menu items can be added in the enum
		TV_APPLIANCES_ELECTRONICS("TV, Appliances, Electronics");

		public final String text;

		HamburgerMenuSBDItems(String text) {
			this.text = text;
		}

		public String HamburgerMenuSBDItemsText() {
			return text;
		}

	}

	public enum HamburgerMenuSubItems {
		TELEVISIONS("Televisions"), HEADPHONES("Headphones"),
		// all the hmburger menu items can be added in the enum
		SPEAKERS("Speakers");

		public final String text;

		HamburgerMenuSubItems(String text) {
			this.text = text;
		}

		public String HamburgerMenuSubItemsText() {
			return text;
		}

	}

}
