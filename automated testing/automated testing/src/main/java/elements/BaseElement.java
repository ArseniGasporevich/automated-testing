package elements;

import config.WebDriverHolder;
import org.openqa.selenium.WebDriver;

public class BaseElement {
    protected WebDriver driver = WebDriverHolder.getInstance().getDriver();
}
