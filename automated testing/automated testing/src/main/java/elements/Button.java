package elements;

import org.openqa.selenium.By;

public class Button extends BaseElement {

    private final By buttonBy;

    public Button(By buttonBy) {
        this.buttonBy = buttonBy;
    }

    public void click() {
        driver.findElement(buttonBy).click();
    }
}
