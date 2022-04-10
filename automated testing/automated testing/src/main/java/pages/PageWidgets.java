package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageWidgets extends BasePage {

    private final By widgets = By.xpath("//*[text()='Widgets']");
    private final By slider = By.xpath("//*[text()='Slider']");
    private final By sliderCheck = By.xpath("//div[@class='main-header']");
    private final By progressBar = By.xpath("//span[text()='Progress Bar']");
    private final By checkBar = By.xpath("//div[@class='main-header']");
    private final By buttonStartAndStopBar = By.id("startStopButton");
    private final By progressBarLoad = By.xpath("//div[@id='progressBar']//div");
    private final By datePicker = By.xpath("//span[text()='Date Picker']");
    private final By dateCheck = By.xpath("//div[@class='main-header']");
    private final By selectDate = By.id("datePickerMonthYearInput");
    private final By dateAndTime = By.id("dateAndTimePickerInput");
    private final By month = By.xpath("//select[@class='react-datepicker__month-select']");
    private final By year = By.xpath("//select[@class='react-datepicker__year-select']");
    private final By day = By.xpath("//div[@class='react-datepicker__day react-datepicker__day--029']");
    private final static Logger LOGGER = LoggerFactory.getLogger(PageToolsQA.class.getName());


    public String widgetsAndSlider() {
        BasePage.scroll();
        driver.findElement(widgets).click();
        BasePage.scroll();
        driver.findElement(slider).click();
        String text = driver.findElement(sliderCheck).getText();
        return text;
    }

    public String bar() {
        driver.findElement(progressBar).click();
        String text = driver.findElement(checkBar).getText();
        return text;
    }

    public int startAndStopBar() throws InterruptedException {
        WebElement startAndStop = driver.findElement(buttonStartAndStopBar);
        int progress = 0;
        int age = Integer.parseInt(System.getProperty("age"));
        startAndStop.click();
        while (progress < age) {
            String text = driver.findElement(progressBarLoad).getText().replaceAll("[^A-Za-zА-Яа-я0-9]", "");
            if (!"".equals(text)) {
                progress = Integer.parseInt(text);
            }
            Thread.sleep(Long.parseLong(System.getProperty("IMPLICIT_WAIT_MIN")));
        }
        startAndStop.click();
        return progress;
    }

    public String widgetsAndDate() {
        BasePage.scroll();
        driver.findElement(widgets).click();
        BasePage.scroll();
        driver.findElement(datePicker).click();
        String text = driver.findElement(dateCheck).getText();
        return text;
    }

    public String selectDate(){
        LOGGER.info("Select date");
       String text = driver.findElement(selectDate).getAttribute("value");
       return text;
    }

    public String dateAndTime(){
        LOGGER.info("Date and time");
        String text = driver.findElement(dateAndTime).getAttribute("value");
        return text;
    }

    public String dateSetting(){
        driver.findElement(selectDate).click();
        Select dateMonth = new Select(driver.findElement(month));
        dateMonth.selectByValue("1");
        Select dateYear = new Select(driver.findElement(year));
        dateYear.selectByValue("2024");
        driver.findElement(day).click();
        String text = driver.findElement(selectDate).getAttribute("value");
        return text;
    }
}
