package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SupportingDocsPage {
    WebDriver driver;

    public SupportingDocsPage(WebDriver driver) {
        this.driver = driver;
    }
    By uploadArea = By.xpath("//input[@type='file']");
    public By supportingTab = By.xpath("//button[normalize-space()='Documents']");
    By uploadBtn = By.xpath("//button[@type='submit']");

    public void openProject(String pName) {
        driver.findElement(By.xpath("//div[contains(text(),'" + pName + "')]")).click();
    }
    public void clickSuppTab(){
        driver.findElement(supportingTab).click();
    }
    public void selectFile(String filename){
        WebElement selFile = driver.findElement(uploadArea);
        selFile.sendKeys(filename);
    }
    public void clickUpload(){
        driver.findElement(uploadBtn).click();
    }


}
