package com.assignment.reports;

import com.assignment.reports.enums.LogType;
import com.assignment.utils.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

public final class FrameworkLogger {

    private FrameworkLogger() {
    }

    private static final Consumer<String> TAKESCREENSHOT = message ->
            ExtentManager.getExtentTest().info("",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
    private static final Consumer<String> PASS = message -> ExtentManager.getExtentTest().pass(message);
    private static final Consumer<String> FAIL = message -> ExtentManager.getExtentTest().fail(message);
    private static final Consumer<String> INFO = message -> ExtentManager.getExtentTest().info(message);
    private static final Map<LogType, Consumer<String>> MAP = new EnumMap<>(LogType.class);

    static {
        MAP.put(LogType.PASS, PASS);
        MAP.put(LogType.FAIL, FAIL.andThen(TAKESCREENSHOT));
        MAP.put(LogType.INFO, INFO);
    }

    public static void log(LogType status, String message) {
       MAP.getOrDefault(status,PASS).accept(message);
    }




}
