package securepay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GooglePage extends PageHandler {

    private final String url;
    private final WebDriver driver;
    private static final By SEARCH_TEXT = By.name("q");
    private static final By RESULT_LIST = By.id("res");

    public GooglePage(String url, WebDriver driver) {
        this.url = url;
        this.driver = driver;
    }

    public boolean goToGoogleSearchPage() {
        try {
            driver.get(url);
            waitForElement(driver, SEARCH_TEXT, 10);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public SecurePayHomePage searchAndSelectSecurePay() {
        try {
            driver.findElement(SEARCH_TEXT).sendKeys("securepay" + Keys.ENTER);
            WebElement resultList = waitForElement(driver, RESULT_LIST, 10);
            List<WebElement> links = resultList.findElements(By.tagName("a"));
            for (WebElement link : links) {
                if (link.getAttribute("href").contains("securepay")) {
                    link.click();
                    return new SecurePayHomePage(driver);
                }
            }
            return null;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
