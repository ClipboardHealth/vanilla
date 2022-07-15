package com.assignment.driver.factory;

import com.assignment.config.factory.ConfigFactory;
import com.assignment.driver.enums.RunType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory {

    private DriverFactory(){}

    private static final Map<RunType, Supplier<WebDriver>> MAP = new EnumMap<>(RunType.class);
    private static final Supplier<WebDriver> LOCAL = LocalDriverFactory::getDriver;
    private static final Supplier<WebDriver> REMOTE = RemoteDriverFactory::getDriver;
    static {
        MAP.put(RunType.LOCAL, LOCAL);
        MAP.put(RunType.REMOTE, REMOTE);
    }

    public static WebDriver getDriver(){
        return MAP.getOrDefault(ConfigFactory.getConfig().runMode(),LOCAL).get();
    }

}
