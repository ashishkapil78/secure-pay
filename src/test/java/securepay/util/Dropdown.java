package securepay.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

    private final WebElement element;

    public Dropdown(WebElement element) {
        this.element = element;
    }

    public void chooseOption(String item) {
        Select select = new Select(element);
        select.selectByVisibleText(item);
    }
}
