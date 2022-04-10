package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Slider extends BaseElement {

    private final By slider = By.id("sliderContainer");
    private final By valueSlider = By.xpath("//div[@class='col-9']//input");
    private final By enter = By.id("sliderValue");

    public String setSlider() {
        int number = Integer.parseInt(System.getProperty("random.numbers"));
        int set = (int) (Math.random() * number);
        WebElement enterSlider = driver.findElement(slider);
        Actions move = new Actions(driver);
        Action actionSlider = move.dragAndDropBy(enterSlider, set, 0).build();
        actionSlider.perform();
        String value = driver.findElement(valueSlider).getAttribute("Value");
        return value;
    }

    public String enterSlider() {
        String value = driver.findElement(enter).getAttribute("Value");
        return value;

    }
}
