package com.assignment.config.converter;

import com.assignment.driver.enums.RunType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Objects;

public class StringToRunTypeConverter implements Converter<RunType> {
    @Override
    public RunType convert(Method method, String string) {
        String runmodeProperty = System.getProperty("runmode");
        return Objects.isNull(runmodeProperty) || runmodeProperty.length() == 0 ?
                RunType.valueOf(string.toUpperCase()) :
                RunType.valueOf(runmodeProperty.toUpperCase());
    }
}
