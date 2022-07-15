package com.assignment.utils;

public final class DynamicXpathUtils {

    private DynamicXpathUtils(){}

    public static String getModifiedXpath(String xpathToBeAltered, String replacingString){
        return String.format(xpathToBeAltered,replacingString);
    }
}
