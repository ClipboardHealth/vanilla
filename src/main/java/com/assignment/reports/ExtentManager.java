package com.assignment.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public final class ExtentManager {


    private ExtentManager() {
    }

    private static final ThreadLocal<ExtentTest> threadSafeExtentTest = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return threadSafeExtentTest.get();
    }

    static void setExtentTest(ExtentTest test) {
        if (Objects.nonNull(test)) {
            threadSafeExtentTest.set(test);
        }
    }

    static void unload() {
        threadSafeExtentTest.remove();
    }
}
