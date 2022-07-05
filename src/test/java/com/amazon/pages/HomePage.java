package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.amazon.base.PageFactory;
import com.amazon.base.WrappedWebDriver;
import com.amazon.base.WrappedWebElement;

public class HomePage implements BasePage {
	private final WrappedWebDriver driver;

	public HomePage(WrappedWebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public  List<WrappedWebElement> getNaveLinks() {
		return driver.findElementsEx(By.xpath("//*[@id='nav-xshop']/a"));
	}
	
	

}
