package securepay.pages;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import securepay.util.Dropdown;

public class ContactUsPage extends PageHandler {

    private final WebDriver driver;
    private final Fairy generator;
    private static final By FIRST_NAME_TEXT = By.name("first-name");
    private static final By LAST_NAME_TEXT = By.name("last-name");
    private static final By EMAIL_TEXT = By.name("email-address");
    private static final By PHONE_TEXT = By.name("phone-number");
    private static final By WEBSITE_TEXT = By.name("website-url");
    private static final By COMPANY_TEXT = By.name("business-name");
    private static final By ENQUIRY_REASON_SELECT = By.name("reason-for-enquiry");

    ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.generator = Fairy.create();
    }

    public boolean displayContactUsPage() {
        try {
            waitForElement(driver, FIRST_NAME_TEXT, 20);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void complete() {
        Person person = generator.person();
        driver.findElement(FIRST_NAME_TEXT).sendKeys(person.getFirstName());
        driver.findElement(LAST_NAME_TEXT).sendKeys(person.getLastName());
        driver.findElement(EMAIL_TEXT).sendKeys(person.getEmail());
        driver.findElement(PHONE_TEXT).sendKeys(person.getTelephoneNumber());
        driver.findElement(WEBSITE_TEXT).sendKeys(person.getCompany().getUrl());
        driver.findElement(COMPANY_TEXT).sendKeys(person.getCompany().getName());
        new Dropdown(driver.findElement(ENQUIRY_REASON_SELECT)).chooseOption("Support");
    }
}
