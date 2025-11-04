package com.felix.util;

public final class StringUtils {

    public static boolean isBlank(String string) {
        return string == null || string.trim().isEmpty();
    }

    public static boolean isNotBlank(String string) {
        return !isBlank(string);
    }

}
