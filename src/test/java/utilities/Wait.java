package utilities;

import commons.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

    WebDriver driver;
    Duration seconds;
    By xpath;

    public Wait(WebDriver driver, Duration seconds, By xpath) {
        this.driver = driver;
        this.seconds = seconds;
        this.xpath = xpath;

        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

}
