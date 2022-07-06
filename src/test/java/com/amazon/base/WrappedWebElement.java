package com.amazon.base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
//Wrapper class on WebElement interface to add some additional functionality to WebElement object.
public class WrappedWebElement implements WebElement {

	public WebElement element;
	public WrappedWebDriver driver;

	public WrappedWebElement(WrappedWebDriver driver, WebElement element) {
		this.element = element;
		this.driver = driver;
	}

	public WebElement getWebElement() {
		return this.element;
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		return element.getScreenshotAs(target);
	}

	@Override
	public void click() {
		element.click();

	}

	@Override
	public void submit() {
		element.submit();

	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		element.sendKeys(keysToSend);

	}

	@Override
	public void clear() {
		element.clear();

	}

	@Override
	public String getTagName() {
		return element.getTagName();
	}

	@Override
	public String getAttribute(String name) {
		return element.getAttribute(name);
	}

	@Override
	public boolean isSelected() {
		return element.isSelected();
	}

	@Override
	public boolean isEnabled() {
		return element.isEnabled();
	}

	@Override
	public String getText() {
		return element.getText();
	}

	public List<WrappedWebElement> findElementsEx(By by) {
		List<WebElement> elements = element.findElements(by);
		List<WrappedWebElement> list = new ArrayList<WrappedWebElement>();
		elements.stream().forEach(ele -> list.add(new WrappedWebElement(new WrappedWebDriver(driver), ele)));
		return list;
	}

	@Override
	public List<WebElement> findElements(By by) {
		new Exception("Please use findElementsEx");
		return null;

	}

	@Override
	public WrappedWebElement findElement(By by) {
		return new WrappedWebElement(driver, element.findElement(by));
	}

	@Override
	public boolean isDisplayed() {
		return element.isDisplayed();
	}

	@Override
	public Point getLocation() {
		return element.getLocation();
	}

	@Override
	public Dimension getSize() {
		return element.getSize();
	}

	@Override
	public Rectangle getRect() {
		return element.getRect();
	}

	@Override
	public String getCssValue(String propertyName) {
		return element.getCssValue(propertyName);
	}

	public void scrollIntoView() {
		JavascriptExecutor j = (JavascriptExecutor) driver.getWebDriver();
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
	}

}
