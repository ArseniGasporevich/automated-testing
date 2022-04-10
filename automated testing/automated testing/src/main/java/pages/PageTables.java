package pages;

import org.openqa.selenium.By;

public class PageTables extends BasePage {

    protected final By count = By.xpath("//div[@class='rt-tbody']/div");

    public int numberOfFields() {
        return (int) driver.findElements(count).stream().filter(e -> !e.getText().isBlank()).count();
    }
}
