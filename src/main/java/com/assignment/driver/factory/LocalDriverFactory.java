package com.assignment.driver.factory;

import com.assignment.config.factory.ConfigFactory;
import com.assignment.driver.enums.DriverType;
import com.assignment.driver.impl.ChromeManager;
import com.assignment.driver.impl.EdgeManager;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class LocalDriverFactory {

    private LocalDriverFactory(){}

    private static final Map<DriverType, Supplier<WebDriver>> MAP = new EnumMap<>(DriverType.class);
    private static final Supplier<WebDriver> CHROME = ()-> new ChromeManager().getDriver();
    private static final Supplier<WebDriver> EDGE = ()-> new EdgeManager().getDriver();
    static {
        MAP.put(DriverType.CHROME, CHROME);
        MAP.put(DriverType.EDGE, EDGE);
    }

    public static WebDriver getDriver(){
        return MAP.getOrDefault(ConfigFactory.getConfig().browser(),CHROME).get();
    }

}
