package com.amazon.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.amazon.pages.BasePage;
// This PageResolver uses reflection to return the page object for requested class type
public class PageResolver {

	protected BasePage getPage(WrappedWebDriver driver, Class<? extends BasePage> pageClass) {
		Class[] type = { WrappedWebDriver.class };
		Constructor<? extends BasePage> cons;
		Object[] obj = { driver };
		try {
			cons = pageClass.getConstructor(type);
			return cons.newInstance(obj);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;

	}

}
