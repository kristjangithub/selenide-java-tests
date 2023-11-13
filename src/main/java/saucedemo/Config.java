package saucedemo;

import java.io.IOException;
import java.util.Properties;

public class Config {

    private static final Properties properties;

    static {
        properties = new Properties();

        try (var customConfig = Config.class.getClassLoader().getResourceAsStream("customConfig.properties");
             var config = Config.class.getClassLoader().getResourceAsStream("config.properties")) {

            var preferredConfig = customConfig == null ? config : customConfig;
            if (preferredConfig == null) throw new RuntimeException("Could not find a .properties file");

            properties.load(preferredConfig);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public static Boolean getHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }

    public static Integer getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static String getBrowserSize() {
        return properties.getProperty("browserSize");
    }

    public static String getBrowserVersion() {
        return properties.getProperty("browserVersion");
    }

    public static String getReportsFolderPath() {
        return properties.getProperty("reportsFolder");
    }
}
