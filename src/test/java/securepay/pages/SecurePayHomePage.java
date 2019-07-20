package securepay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SecurePayHomePage extends PageHandler {

    private final WebDriver driver;
    private static final By SECUREPAY_LOGO = By.id("logo");
    private static final By MENU_BAR = By.id("nav");
    private static final By SUB_MENU = By.className("sub-menu");

    SecurePayHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean displaySecurePayHomepage() {
        try {
            waitForElement(driver, SECUREPAY_LOGO, 10);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ContactUsPage goToContactUs() {
        try {
            List<WebElement> menuItems = driver.findElement(MENU_BAR).findElements(By.tagName("a"));
            for (WebElement menuItem : menuItems) {
                if (menuItem.getText().contains("Support")) {
                    Actions action = new Actions(driver);
                    action.moveToElement(menuItem).build().perform();
                    waitTillVisible(driver, driver.findElement(SUB_MENU), 10);
                }
            }
            driver.findElement(By.id("menu-item-179")).click();
            return new ContactUsPage(driver);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
