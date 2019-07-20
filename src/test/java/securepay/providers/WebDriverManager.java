package securepay.providers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import securepay.util.ApplicationConfig;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriver driver;
    private static final String GECKO_DRIVER = FileUtils.getFile("drivers", "geckodriver").getAbsolutePath();

    public static WebDriver initialiseFirefoxBrowser() {
        try {
            driver = new FirefoxDriver(getFirefoxOptions());
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return driver;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static FirefoxOptions getFirefoxOptions() {
        System.setProperty("webdriver.gecko.driver", GECKO_DRIVER);
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(CapabilityType.PLATFORM_NAME, Platform.getCurrent().family());
        options.setCapability("marionette", true);
        options.setHeadless(false);
        return options;
    }

    public static void closeBrowser() {
        try {
            if (driver != null) {
                driver.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
