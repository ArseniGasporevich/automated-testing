package elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.PageToolsQA;

public class Form extends BaseElement {

    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By age = By.id("age");
    private final By salary = By.id("salary");
    private final By department = By.id("department");
    private final By submit = By.id("submit");
    private final static Logger LOGGER = LoggerFactory.getLogger(PageToolsQA.class.getName());

    public void addTable(String firstNameValue, String lastNameValue, String emailValue,
                         String ageValue, String salaryValue, String departmentValue) {
        driver.findElement(firstName).sendKeys(firstNameValue);
        driver.findElement(lastName).sendKeys(lastNameValue);
        driver.findElement(email).sendKeys(emailValue);
        driver.findElement(age).sendKeys(ageValue);
        driver.findElement(salary).sendKeys(salaryValue);
        driver.findElement(department).sendKeys(departmentValue);
        driver.findElement(submit).click();
        LOGGER.info("user added in tables");
    }
}
