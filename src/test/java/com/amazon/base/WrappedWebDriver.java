package com.amazon.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
// Wrapper class on WebDriver interface to add some additional functionality to driver object.
public class WrappedWebDriver implements WebDriver {

	public WebDriver driver;

	public WrappedWebDriver(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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

		return driver.findElements(by);
	}

	public List<WrappedWebElement> findElementsEx(By by) {
		List<WebElement> elements = driver.findElements(by);
		List<WrappedWebElement> list = new ArrayList<WrappedWebElement>();
		elements.stream().forEach(ele -> list.add(new WrappedWebElement(new WrappedWebDriver(driver), ele)));
		return list;
	}

	@Override
	public WrappedWebElement findElement(By by) {
		return new WrappedWebElement(new WrappedWebDriver(driver), driver.findElement(by));
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

	public WebDriver getWebDriver() {
		return driver;
	}

	public void waitUntilElementVisible(WrappedWebElement element, int miliSec) {
		Wait wait = new FluentWait<>(this.driver).withTimeout(Duration.ofMillis(miliSec))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element.getWebElement()));
	}

	public void wait(int timeInMilliSec) throws InterruptedException {
		Thread.sleep(timeInMilliSec);
	}

}
