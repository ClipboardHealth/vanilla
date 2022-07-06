package com.amazon.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amazon.base.WrappedWebDriver;
import com.amazon.base.WrappedWebElement;

public class CategoryRefinements extends WrappedWebElement {
	private WrappedWebElement element;
	private WrappedWebDriver driver;
	private String categoryRefinementSectionParent = "//*/div[@id=\"s-refinements\"]//span[text()="
			+ "\"%s\"]/parent::div/parent::div";

	public CategoryRefinements(WrappedWebDriver driver, WebElement element) {
		super(driver, element);
		this.element = new WrappedWebElement(driver, element);
		this.driver = driver;
	}

	public WrappedWebElement getASectionsComponent(A_SectionHeaderItems aSectionItem) {
		WrappedWebElement categoryRefinement = driver.findElement(
				By.xpath(String.format(categoryRefinementSectionParent, aSectionItem.aSectionHeaderItemsText())));
		return categoryRefinement;
	}

	public enum A_SectionHeaderItems {
		BRANDS("Brands"), 
		NEW_ARRIVALS("New Arrivals"),
		// all section items can be added in the enum
		ITEM_CONDITION("Item condition");

		public final String text;

		A_SectionHeaderItems(String text) {
			this.text = text;

		}

		public String aSectionHeaderItemsText() {
			return text;
		}

	}

}
