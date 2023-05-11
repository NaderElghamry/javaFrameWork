package com.QaQart.utils;

import java.util.Properties;

public class ConfigUtils {
    private static Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils() {
        properties =
                PropertiesUtils.LoadProperties("src/test/java/com/QaQart/Config/Production.Properties");
    }

    public static ConfigUtils getInstance() {
        if (configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public String getSignUpUrl() {
        String prop = properties.getProperty("signUpUrl");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find signup URL in Property file");
    }

    public String getSignUpEmail() {
        String prop = properties.getProperty("signUpEmail");
        if (prop != null)
            return prop;
        else
            throw new RuntimeException("Couldn't find signup Email in Property file");
    }

    public String getFirstName() {
        String prop = properties.getProperty("firstName");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find First name in Property file");
    }

    public String getLastMame() {
        String prop = properties.getProperty("lastname");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find Last name in Property file");
    }

    public String getSignUpPassword() {
        String prop = properties.getProperty("signUpPassword");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find signup password in Property file");
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find BaseUrl in Property file");
    }

    public String getEmail() {
        String prop = properties.getProperty("email");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find Username in Property file");
    }

    public String getPassword() {
        String prop = properties.getProperty("password");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find Username in Property file");
    }


    public String getConfirmPassword() {
        String prop = properties.getProperty("confirmPassword");
        if (prop != null) return prop;
        else
            throw new RuntimeException("Couldn't find Confirm password in Property file");
    }

}
