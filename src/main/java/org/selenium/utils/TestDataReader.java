package org.selenium.utils;


import java.util.Properties;

public enum TestDataReader {
    SUCCESSFUL_CONTACT_MESSAGE;

    private final Properties properties;

    TestDataReader() {
        String configPath = "./src/main/resources/testData.properties/";
        properties = PropertyUtils.propertyLoader(configPath);
    }

    public String getProperty() {

        return properties.getProperty(this.toString());
    }
}
