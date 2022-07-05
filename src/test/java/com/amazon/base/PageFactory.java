package com.amazon.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

import com.amazon.pages.BasePage;

public class PageFactory  {


	protected BasePage getPage(WrappedWebDriver driver, Class<? extends BasePage> pageClass){
		Class[] type = { WrappedWebDriver.class };
		Constructor<? extends BasePage> cons;
		Object[] obj = { driver};
		try {
			cons = pageClass.getConstructor(type);
			return cons.newInstance(obj);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | 
				IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		 return null;
		
	}

}
