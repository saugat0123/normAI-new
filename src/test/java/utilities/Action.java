package utilities;

import commons.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Action {
    WebDriver driver;
    Keys keys;

    public Action(WebDriver driver, Keys keys) {
        this.driver = driver;
        this.keys = keys;

        Actions actions = new Actions(driver);
        actions.sendKeys(keys).perform();
    }
}
