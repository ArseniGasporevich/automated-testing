package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageElements extends BasePage {

    private final By webTables = By.xpath("//span[text() = 'Web Tables']");
    private final By uploadAndDownload = By.xpath("//span[text()='Upload and Download']");
    private final By deleteUser = By.id("delete-record-4");
    private static final Button buttonAddTable = new Button(By.id("addNewRecordButton"));
    private final static Logger LOGGER = LoggerFactory.getLogger(PageToolsQA.class.getName());

    public void webTables() {
        driver.findElement(webTables).click();
        LOGGER.info("page Web tables open");

    }

    public void clickUploadAndDownload(){
        driver.findElement(uploadAndDownload).click();
        LOGGER.info("page upload and download open");
    }

    public void deleteUser() {
        driver.findElement(deleteUser).click();
        LOGGER.info("user delete");
    }

    public Button getAddTable() {
        return buttonAddTable;
    }
}
