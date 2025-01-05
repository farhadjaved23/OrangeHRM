package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    @Parameters("Browser")
    public void setUp(@Optional("chrome") String Browser) throws MalformedURLException {
        switch (Browser.toLowerCase()) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("platformName", "ANY");
                firefoxOptions.setCapability("browserName", "firefox");
                driver = new RemoteWebDriver(new URL("http://10.96.104.20:4444"), firefoxOptions);
                break;

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability("platformName", "ANY");
                chromeOptions.setCapability("browserName", "chrome");
                driver = new RemoteWebDriver(new URL("http://10.96.104.20:4444"), chromeOptions);
                break;

            case "microsoftedge":
                ChromeOptions edgeOptions = new ChromeOptions();
                edgeOptions.setCapability("platformName", "ANY");
                edgeOptions.setCapability("browserName", "MicrosoftEdge"); // Correct browser name for Chrome
                edgeOptions.addArguments("--headless");
                driver = new RemoteWebDriver(new URL("http://10.96.104.20:4444"), edgeOptions);
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + Browser);
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Use seconds
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(5000);
//            driver.quit();
        }
    }
}
