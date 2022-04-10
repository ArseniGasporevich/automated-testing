package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;

public class WebDriverHolder {

    private static WebDriverHolder INSTANCE;
    private final WebDriver driver;

    private WebDriverHolder() {
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
            PropertyConfigurator.configure(WebDriverHolder.class.getResource("/logs/log4j.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        WebDriver driver = null;
        String platformAndBrowser = System.getProperty("platform.chrome");
        switch (platformAndBrowser) {
            case "win_chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "win_firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Incrorrect platforms or browser name" + platformAndBrowser);

        }
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(Integer.parseInt(System.getProperty("size.height")), Integer.parseInt(System.getProperty("size.width"))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(System.getProperty("IMPLICIT_WAIT"))));
        this.driver = driver;
    }

    public static WebDriverHolder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WebDriverHolder();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        return driver;
    }
}