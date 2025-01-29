package hillel.qa;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    static {
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getValue(String key) {
        return prop.getProperty(key);
    }

    public static String getBaseUrl() {
        return prop.getProperty("baseUrl");
    }

    public static String getRemoteUrl() {
        return prop.getProperty("remoteUrl");
    }
}
