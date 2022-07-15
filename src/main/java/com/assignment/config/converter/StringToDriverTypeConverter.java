package com.assignment.config.converter;

import com.assignment.driver.enums.DriverType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToDriverTypeConverter implements Converter<DriverType> {

    @Override
    public DriverType convert(Method method, String browername) {

        return DriverType.valueOf(browername.toUpperCase());
    }
}
