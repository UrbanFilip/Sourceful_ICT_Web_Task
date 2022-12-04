package org.selenium.utils;

import org.selenium.constants.EnvType;

import java.util.Properties;

public enum ConfigReader {
    BASE_URL,
    BROWSER,
    HEADLESS,
    INCOGNITO,
    WAIT_TIMEOUT;

    private final Properties properties;

    ConfigReader() {
        String env = System.getProperty("env", String.valueOf(EnvType.STAGE));
        String configPath = "./environments/";
        switch (EnvType.valueOf(env)) {
            case STAGE -> this.properties = PropertyUtils.propertyLoader(configPath + "stg_config.properties");
            case DUMMY_ENV -> this.properties = PropertyUtils.propertyLoader(configPath + "dummy_env.properties");
            default -> throw new IllegalStateException("Invalid env type: " + env);
        }
    }

    public String getProperty() {
        return properties.getProperty(this.toString());
    }
}

