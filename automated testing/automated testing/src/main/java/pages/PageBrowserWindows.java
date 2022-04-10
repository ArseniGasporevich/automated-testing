package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageBrowserWindows extends BasePage {

    private final By newTab = By.id("sampleHeading");
    private final By browserWindows = By.xpath("//div[@class='main-header']");
    private final By links = By.xpath("//span[text()='Links']");
    private final By linksCheck = By.xpath("//div[@class='main-header']");
    private final By home = By.id("simpleLink");
    private final Button buttonNewTab = new Button(By.id("tabButton"));
    private final static Logger LOGGER = LoggerFactory.getLogger(PageToolsQA.class.getName());



    public String newTab() {
        WebElement one = driver.findElement(newTab);
        String text = one.getText();
        driver.close();
        return text;
    }

    public String checkWindows() {
        String text = driver.findElement(browserWindows).getText();
        return text;
    }

    public String links() {
        driver.findElement(links).click();
        String text = driver.findElement(linksCheck).getText();
        return text;
    }

    public String checkLinks() {
        String text = driver.findElement(linksCheck).getText();
        return text;
    }

    public void home() {
        LOGGER.info("Home page open");
        driver.findElement(home).click();
    }

    public Button getNewTab() {
        LOGGER.info("Sample page open");
        return buttonNewTab;
    }

}



