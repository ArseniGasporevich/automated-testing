package elements;

public class Tab extends BaseElement {

    public void tab() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window((tab));
        }
    }
}
