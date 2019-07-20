package securepay.scenarios;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import securepay.pages.ContactUsPage;
import securepay.pages.GooglePage;
import securepay.pages.SecurePayHomePage;
import securepay.providers.WebDriverManager;

public class TestSecurePay {

    private GooglePage googlePage;
    private SecurePayHomePage securePayHomePage;
    private ContactUsPage contactUsPage;
    private WebDriver driver;
    private static final String URL = "https://www.google.com.au";

    @Before
    public void init() {
        driver = WebDriverManager.initialiseFirefoxBrowser();
    }

    @Given("Launch google page")
    public void openGooglePage() {
        googlePage = new GooglePage(URL, driver);
    }

    @When("I search securepay on google")
    public void searchSecurePay() {
        Assert.assertTrue(googlePage.goToGoogleSearchPage(), "Failed to load google search page.");
    }

    @Then("I click securepay")
    public void clickSelectSecurePay() {
        securePayHomePage = googlePage.searchAndSelectSecurePay();
        Assert.assertTrue(securePayHomePage.displaySecurePayHomepage(), "Failed to load secure pay home page.");
    }

    @When("I click contact us menu")
    public void goToContactUs() {
        contactUsPage = securePayHomePage.goToContactUs();
    }

    @Then("Contact-us page is displayed")
    public void displayContactUsPage() {
        Assert.assertTrue(contactUsPage.displayContactUsPage(), "Failed to load contact us page.");
    }

    @Then("Contact-us form is completed")
    public void completeContactUsForm() {
        contactUsPage.complete();
    }

    @After
    public void end() {
        WebDriverManager.closeBrowser();
    }
}
