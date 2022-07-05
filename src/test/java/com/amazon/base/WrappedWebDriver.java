package com.amazon.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WrappedWebDriver implements WebDriver {
	
	public WebDriver driver;

    public WrappedWebDriver(WebDriver driver){
        this.driver = driver;
    }

	@Override
	public void get(String url) {
		driver.get(url);
		
	}

	@Override
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		new Exception("Please use findElementsEx method");
		return null;
	}
	
	public List<WrappedWebElement> findElementsEx (By by) {
		List<WebElement> elements = driver.findElements(by);
		List<WrappedWebElement> list =  new ArrayList<WrappedWebElement>();
		elements.stream().forEach(ele -> list.add( new WrappedWebElement(ele)));
		return list;
	}

	@Override
	public WrappedWebElement findElement(By by) {
		return new WrappedWebElement(driver.findElement(by));
	}

	@Override
	public String getPageSource() {
		return driver.getPageSource();
	}

	@Override
	public void close() {
		driver.close();
		
	}

	@Override
	public void quit() {
		driver.quit();
		
	}

	@Override
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	@Override
	public Navigation navigate() {
		return driver.navigate();
	}

	@Override
	public Options manage() {
		return driver.manage();
	}

}
