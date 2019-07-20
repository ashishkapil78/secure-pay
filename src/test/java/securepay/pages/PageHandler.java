package securepay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

class PageHandler {

    PageHandler() {
    }

    static WebElement waitForElement(final WebDriver driver, final By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    static WebElement waitTillVisible(final WebDriver driver, final WebElement locator, int timeoutSeconds) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        }
        catch(Exception e) {
            return null;
        }
    }
}
