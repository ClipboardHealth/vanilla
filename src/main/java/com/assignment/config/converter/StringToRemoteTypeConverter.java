package com.assignment.config.converter;

import com.assignment.driver.enums.RemoteType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Objects;

public class StringToRemoteTypeConverter implements Converter<RemoteType> {
    @Override
    public RemoteType convert(Method method, String remotemode) {
        String remoteModeProperty = System.getProperty("remotemode");

        return Objects.isNull(remoteModeProperty) || remoteModeProperty.length() ==0 ?
                RemoteType.valueOf(remotemode.toUpperCase()) :
                RemoteType.valueOf(remoteModeProperty.toUpperCase());
    }
}
