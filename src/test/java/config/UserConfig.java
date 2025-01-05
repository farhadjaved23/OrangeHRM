package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserConfig {
    private Properties properties;
    private final String propertyFilePath = "resources/users.properties";

    public UserConfig() {
        properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(propertyFilePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() { return properties.getProperty("username");}

    public String getPassword() { return properties.getProperty("password");}

    public String getInvalidPassword() { return properties.getProperty("invalidpassword");}

    public String getSecretKey() { return properties.getProperty("secretKey");}

    public String getInvalidSecretKey() { return properties.getProperty("invalidsecretKey");}


}