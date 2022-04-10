package pages;

import org.openqa.selenium.By;

public class PageDownload extends BasePage {

    private final By uploadAndDownload = By.xpath("//div[@class='main-header']");


    public String uploadAndDownload() {
        String text = driver.findElement(uploadAndDownload).getText();
        return text;
    }

}