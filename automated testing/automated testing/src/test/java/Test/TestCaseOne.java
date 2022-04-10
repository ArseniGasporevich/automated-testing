package Test;

import config.WebDriverHolder;
import elements.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TestCaseOne {

    protected PageToolsQA pageToolsQA = new PageToolsQA();
    protected AlertsFrameWindows alertsFrameWindows = new AlertsFrameWindows();
    protected PageElements pageElements = new PageElements();
    protected Form forms = new Form();
    protected PageTables pageTables = new PageTables();
    protected PageBrowserWindows pageBrowserWindows = new PageBrowserWindows();
    protected Tab tab = new Tab();
    protected PageWidgets pageWidgets = new PageWidgets();
    protected Slider slider = new Slider();
    protected PageDownload pageDownload = new PageDownload();
    private final String page = System.getProperty("page.demoqa");


    @Test
    public void testCaseOne() throws InterruptedException {
        WebDriverHolder.getInstance().getDriver().get(page);
        assertTrue(pageToolsQA.mainOpen(), "Page not found");
        Thread.sleep(Long.parseLong(System.getProperty("IMPLICIT_WAIT_MIDDLE")));
        BasePage.scroll();
        pageToolsQA.openAlerts();
        alertsFrameWindows.alertsClick();
        assertTrue(pageToolsQA.formOpen(), "Form not found");
        alertsFrameWindows.getAlertButton().click();
        alertsFrameWindows.alertsOkConfirm();
        alertsFrameWindows.getConfirmBoxButton().click();
        alertsFrameWindows.alertsOkPrompt();
        alertsFrameWindows.getPromptBoxButton().click();
        assertEquals(alertsFrameWindows.alertText(), alertsFrameWindows.textForm());

    }

    @Test
    public void testCaseTwo() throws InterruptedException {
        WebDriverHolder.getInstance().getDriver().get(page);
        assertTrue(pageToolsQA.mainOpen(), "Page not found");
        pageToolsQA.openAlerts();
        BasePage.scroll();
        alertsFrameWindows.nestedFrames();
        assertEquals(alertsFrameWindows.nestedFramesOne(), "Parent frame", "Error Parent frame");
        assertEquals(alertsFrameWindows.nestedFramesTwo(), "Child Iframe", "Error Child Iframe");
        BasePage.scroll();
        alertsFrameWindows.frames();
        assertEquals(alertsFrameWindows.framesOne(), alertsFrameWindows.framesTwo(), "Frames error");

    }

    @Test
    public void testCaseThree () {
        WebDriverHolder.getInstance().getDriver().get(page);
        assertTrue(pageToolsQA.mainOpen(), "Page not found");
        BasePage.scroll();
        pageToolsQA.buttonElements();
        pageElements.webTables();
        int size = pageTables.numberOfFields();
        pageElements.getAddTable().click();
        forms.addTable("firstNameValue", "Snow", "knownothing@gmail.com",
                "30", "3000", "alpha");
        int sizeAfterAdd = pageTables.numberOfFields();
        assertTrue(size < sizeAfterAdd, "User added");
        pageElements.deleteUser();
        int sizeAfterDeleting = pageTables.numberOfFields();
        assertTrue(sizeAfterDeleting < sizeAfterAdd, "User deleted");

    }

    @Test
    public void testCaseFour() throws InterruptedException {
        WebDriverHolder.getInstance().getDriver().get(page);
        assertTrue(pageToolsQA.mainOpen(), "Page not found");
        pageToolsQA.openAlerts();
        assertEquals(pageToolsQA.browserWindows(), "Browser Windows");
        pageBrowserWindows.getNewTab().click();
        tab.tab();
        assertEquals(pageBrowserWindows.newTab(), "This is a sample page");
        WebDriverHolder.getInstance().getDriver().switchTo().window(WebDriverHolder.getInstance().getDriver().getWindowHandles().stream().findAny().get());
        assertEquals(pageBrowserWindows.checkWindows(), "Browser Windows");
        pageToolsQA.buttonElements();
        BasePage.scroll();
        assertEquals(pageBrowserWindows.links(), "Links");
        String windows = WebDriverHolder.getInstance().getDriver().getWindowHandle();
        pageBrowserWindows.home();
        tab.tab();
        assertTrue(pageToolsQA.mainOpen(), "Main page not found");
        WebDriverHolder.getInstance().getDriver().switchTo().window(windows);
        assertEquals(pageBrowserWindows.checkLinks(), "Links");
    }

    @Test
    public void testCaseFive() throws InterruptedException {
        WebDriverHolder.getInstance().getDriver().get(page);
        assertTrue(pageToolsQA.mainOpen(), "Page not found");
        BasePage.scroll();
        assertEquals(pageWidgets.widgetsAndSlider(), "Slider");
        assertEquals(slider.setSlider(), slider.enterSlider(), "Error Slider");
        BasePage.scroll();
        assertEquals(pageWidgets.bar(), "Progress Bar");
        Thread.sleep(Long.parseLong(System.getProperty("IMPLICIT_WAIT")));
        int age = Integer.parseInt(System.getProperty("age"));
        double error = age * 0.02;
        int progress = pageWidgets.startAndStopBar();
        assertTrue(progress >= age - error && progress <= age + error);
    }

    @Test
    public void testCaseSix() {
        WebDriverHolder.getInstance().getDriver().get(page);
        assertTrue(pageToolsQA.mainOpen(), "Page not found");
        assertEquals(pageWidgets.widgetsAndDate(), "Date Picker");
        Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        SimpleDateFormat formaterSelectDate = new SimpleDateFormat("MM/D/Y", Locale.ENGLISH);
        SimpleDateFormat formaterDateAndTime = new SimpleDateFormat("MMMM d, yyyy H:mm a", Locale.ENGLISH);
        assertEquals(pageWidgets.selectDate(),formaterSelectDate.format(date));
        assertEquals(pageWidgets.dateAndTime(),formaterDateAndTime.format(date));
        assertEquals(pageWidgets.dateSetting(),"02/29/2024");
    }

    @Test
    public void testCaseSeven(){
        WebDriverHolder.getInstance().getDriver().get(page);
        assertTrue(pageToolsQA.mainOpen(), "Page not found");
        BasePage.scroll();
        pageToolsQA.buttonElements();
        BasePage.scroll();
        pageElements.clickUploadAndDownload();
        assertEquals(pageDownload.uploadAndDownload(), "Upload and Download");


    }


   @AfterClass
    public void close() {
        WebDriverHolder.getInstance().getDriver().close();
    }
}
