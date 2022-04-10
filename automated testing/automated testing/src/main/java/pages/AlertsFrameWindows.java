package pages;

import elements.Button;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlertsFrameWindows extends BasePage {
    private final By alerts = By.xpath("//span[text()='Alerts']");
    private final By nested_Frames = By.xpath("//span[text() = 'Nested Frames']");
    private final By frames = By.xpath("//span[text()='Frames']");
    private final By textAlert = By.id("promptResult");
    private final By framesOne = By.id("frame1");
    private final By nestedFrameTwo = By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']");
    private final By formFramesTwo = By.id("frame2");
    private final By textOne = By.xpath("//*[text()='Parent frame']");
    private final By textTwo = By.xpath("//*[text()='Child Iframe']");
    private final By framesText = By.id("sampleHeading");
    private final Button alertButton = new Button(By.id("alertButton"));
    private final Button confirmBoxButton = new Button(By.id("confirmButton"));
    private final Button promptBoxButton = new Button(By.id("promtButton"));
    private final static Logger LOGGER = LoggerFactory.getLogger(PageToolsQA.class.getName());


    WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(System.getProperty("IMPLICIT_WAIT")));


    public void alertsClick() {
        driver.findElement(alerts).click();
    }

    public void nestedFrames() {
        driver.findElement(nested_Frames).click();
        LOGGER.info("page Nested Frames open");
    }

    public void alertsOkConfirm() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        LOGGER.info("confirm box will appear");
    }
    public void alertsOkPrompt() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        LOGGER.info("prompt box will appear");
    }


    public String generatedStr() {

        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }

    public String alertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = generatedStr();
        alert.sendKeys(text);
        alert.accept();
        return text;
    }

    public String textForm() {
        WebElement prompt = driver.findElement(textAlert);
        int indexOfNeededText = 12;
        return prompt.getText().substring(indexOfNeededText);
    }

    public String nestedFramesOne() {
        driver.switchTo().frame(driver.findElement(framesOne));
        String text = driver.findElement(textOne).getText();
        return text;
    }

    public String nestedFramesTwo() {
        driver.switchTo().frame(driver.findElement(nestedFrameTwo));
        String text = driver.findElement(textTwo).getText();
        return text;
    }

    public void frames() {
        driver.findElement(frames).click();
        LOGGER.info("page Frames open");
    }

    public String framesOne() {
        driver.switchTo().frame(driver.findElement(framesOne));
        String text = driver.findElement(framesText).getText();
        return text;
    }

    public String framesTwo() {
        driver.switchTo().frame(driver.findElement(formFramesTwo));
        String text = driver.findElement(framesText).getText();
        return text;
    }

    public Button getAlertButton() {
        return alertButton;
    }

    public Button getConfirmBoxButton() {
        return confirmBoxButton;
    }

    public Button getPromptBoxButton() {
        return promptBoxButton;
    }
}
