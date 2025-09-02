package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Wait;

import java.time.Duration;

public class DraftsPage {

    WebDriver driver;

    public DraftsPage(WebDriver driver) {
        this.driver = driver;
    }

    int countBeforeDelete;

    By draftsTab = By.xpath("//span[contains(text(), 'Drafts')]");
    By firstInfoIcon = By.xpath("(//td//button[contains(@class,'inline-flex')])[1]");
    By deleteIcon = By.xpath("//span[contains(text(),'Delete draft')]/parent::button");
    By confirmDelete = By.xpath("//div[@role='alertdialog']//button[text()='Delete']");
    By  draftCount = By.xpath("//button[.//span[text()='Drafts']]//div");

    public void waitForDraftsPageToLoad() {
        driver.findElement(draftsTab).click();
        new Wait(driver, Duration.ofSeconds(20), By.xpath("//table"));
    }

    public int drftCount() {
//        new Wait(driver, Duration.ofSeconds(20), draftCount);
        return Integer.parseInt(driver.findElement(draftCount).getText());
    }

    public void deleteFirst() throws InterruptedException {
        new Wait(driver, Duration.ofSeconds(20), firstInfoIcon);
        driver.findElement(firstInfoIcon).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='dialog']")).click();
        By delicon = By.xpath("(//div[@role='dialog']//div[@dir='ltr']//div[.//button[normalize-space()='Delete draft']])[2]");
//        new Wait(driver, Duration.ofSeconds(15), delicon);
//        WebElement delBtn = driver.findElement(By.xpath("//div[@role='dialog']//div[2]//div//div[2]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(delicon));
        System.out.println("del icon click vo");
//        Thread.sleep(7000);
        new Wait(driver, Duration.ofSeconds(10), confirmDelete);
        driver.findElement(confirmDelete).click();
//        Thread.sleep(3000);
        new Wait(driver, Duration.ofSeconds(20), draftCount);
//        int countAfterDelete = Integer.parseInt(driver.findElement(By.xpath("//button//div[contains(@class,'inline-flex')])[4]")).getText());
//        Thread.sleep(10000);
//        System.out.println("after"+ countAfterDelete);
//        System.out.println("before"+ countBeforeDelete);
//        return countBeforeDelete == countAfterDelete + 1;
    }

    public void checkDraftsCount() {
    }
}
