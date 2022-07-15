package com.assignment.constants;

import lombok.Getter;

public final class FrameworkConstants {

    private FrameworkConstants(){}

    @Getter private static final String REPORT_PATH = System.getProperty("user.dir")+"/ExtentReports/index.html";
    @Getter private static final int TIMEOUT = 10;
}
