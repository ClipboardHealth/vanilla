package com.assignment.driver.factory;

import com.assignment.config.factory.ConfigFactory;
import com.assignment.driver.enums.RemoteType;
import com.assignment.driver.remoteimpl.SeleniumGrid;
import com.assignment.driver.remoteimpl.SelenoidGrid;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class RemoteDriverFactory {

    private RemoteDriverFactory(){}


    private static final Map<RemoteType, Supplier<WebDriver>> MAP = new EnumMap<>(RemoteType.class);
    private static final Supplier<WebDriver> SELENOID = ()-> new SelenoidGrid().getDriver();
    private static final Supplier<WebDriver> SELENIUM = ()-> new SeleniumGrid().getDriver();
    static {
        MAP.put(RemoteType.SELENIUM, SELENIUM);
        MAP.put(RemoteType.SELENOID, SELENOID);
    }

    public static WebDriver getDriver(){
        return MAP.getOrDefault(ConfigFactory.getConfig().remoteMode(),SELENOID).get();
    }




}
