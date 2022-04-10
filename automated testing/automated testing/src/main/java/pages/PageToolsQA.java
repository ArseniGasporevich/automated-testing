package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PageToolsQA extends BasePage {
    private final By bannerOfMain = By.xpath("//img[@class='banner-image']");
    private final By buttonAlertsWindows = By.xpath("//div[@class='card mt-4 top-card'][3]");
    private final By checkForm = By.id("javascriptAlertsWrapper");
    private final By elements = By.xpath("//*[text()='Elements']");
    private final By browser = By.xpath("//span[text()='Browser Windows']");
    private final static Logger LOGGER = LoggerFactory.getLogger(PageToolsQA.class.getName());
    public PageToolsQA() {
        PageFactory.initElements(driver, this);
    }


    public boolean mainOpen() {
        try {
            driver.findElement(bannerOfMain);
            LOGGER.info("main page open");
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void openAlerts() {
        driver.findElement(buttonAlertsWindows).click();
        LOGGER.info("alerts page open");
    }

    public boolean formOpen() {
        try {
            driver.findElement(checkForm);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void buttonElements() {
        driver.findElement(elements).click();
        LOGGER.info("page Elements open");
    }

    public String browserWindows() {
        WebElement one = driver.findElement(browser);
        one.click();
        String text = one.getText();
        return text;
    }

}