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

    By draftsTab = By.xpath("//span[contains(text(), 'Drafts')]");
    By firstInfoIcon = By.xpath("(//td//button[contains(@class,'inline-flex')])[1]");
    By deleteIcon = By.xpath("//span[contains(text(),'Delete draft')]/parent::button");
    By confirmDelete = By.xpath("//button[contains(text(),'Delete')]");
    By draftCount = By.xpath("(//button//div[contains(@class,'inline-flex')])[4]");

    public void waitForDraftsPageToLoad() {
        new Wait(driver, Duration.ofSeconds(20), draftsTab);
        driver.findElement(draftsTab).click();
    }

    public boolean deleteFirst() throws InterruptedException {
        new Wait(driver, Duration.ofSeconds(20), firstInfoIcon);
        int countBeforeDelete = Integer.parseInt(driver.findElement(draftCount).getText());
        System.out.println("countBeforeDelete:: "+ countBeforeDelete);
//        Thread.sleep(5000);
        driver.findElement(firstInfoIcon).click();
//        driver.findElement(deleteIcon).click();
        Thread.sleep(5000);
        WebElement span = driver.findElement(By.xpath("//span[contains(text(),'Delete draft')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", span);
        System.out.println("asdasdasd");
        driver.findElement(confirmDelete).click();
        int countAfterDelete = Integer.parseInt(driver.findElement(draftCount).getText());
        System.out.println("countAfterDelete"+ countAfterDelete);
        return countAfterDelete == countBeforeDelete -1;
    }

    public void checkDraftsCount() {
    }
}
