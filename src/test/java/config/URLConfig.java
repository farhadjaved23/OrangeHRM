package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class URLConfig {
    private Properties properties;
    private final String propertyFilePath = "resources/config.properties";

    public URLConfig() {
        properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(propertyFilePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getBaseUrl() { return properties.getProperty("base.url");}

    public String getAdminUrl() { return properties.getProperty("admin.url");}

    public String getApplyUrl() { return properties.getProperty("applyLeave.url");}

    public String getMenTeesUrl() { return properties.getProperty("mentees.url");}

    public String getAddressUrl() { return properties.getProperty("address.url");}

    public String getAccountUrl() { return properties.getProperty("account.url");}

}