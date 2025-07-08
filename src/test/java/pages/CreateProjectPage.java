package pages;

import commons.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectPage {
    WebDriver driver;
    public CreateProjectPage(WebDriver driver) {
        this.driver = driver;
    }
    By createProject = By.xpath("//a[@href='/projects/new']");
    public By projectName = By.xpath("//input[@name='projectName']");
    By releaseDate = By.xpath("//input[ @name='intendedReleaseDate']");
    By audience = By.xpath("//select[@name='intendedAudience']");
    By distChannel = By.xpath("//select[@name='distributionChannel']");
    By mainDoc = By.xpath("//input[@type='file']");
    By uploadBtn = By.xpath("//button[@type='submit']");
    public By proDetails = By.xpath("//button[contains(text(),'Project Details')]");
    public By dName = By.xpath("//div[@class='chakra-stack css-1igwmid'] /p");
    public By cBName = By.xpath("//td[contains(text(),'Created By:')]/following-sibling::td");
    public By pNameInHeading = By.xpath("//div[@class='css-jmsfa6']");
    public By pNameInDetails = By.xpath("//td[contains(text(),'Name:')]/following-sibling::td");
    public By pdfView = By.xpath("//div[@class='react-pdf__Document']/div[last()]");
    public By pp = By.xpath("//div[contains(text(),'Check Scrolling')]");
    public By pdfContainer = By.xpath("//div[contains(@data-page-number,'1')]");

    public void clickNewProjectIcon(){
        driver.findElement(createProject).click();
    }
    public void enterProjectName(String proName){
        driver.findElement(projectName).sendKeys(proName);
    }
    public void enterReleaseDate(String date){
        driver.findElement(releaseDate).sendKeys(date);
    }
    public void selectAudience(String aud){
        Select sa = new Select(driver.findElement(audience));
        sa.selectByVisibleText(aud);
    }
    public void selectDistributionChannel(String channel){
        Select s = new Select(driver.findElement(distChannel));
        s.selectByVisibleText(channel);
    }
    public void selectFile(String filename){
        WebElement selFile = driver.findElement(mainDoc);
        selFile.sendKeys(filename);
    }
    public void clickUpload(){
        driver.findElement(uploadBtn).click();
    }
    public void scrollDown() {
        new Actions(driver).scrollToElement(driver.findElement(uploadBtn)).perform();
    }
    public void scrollDownPdf() {
        new Actions(driver).scrollToElement(driver.findElement(pdfView)).perform();
    }
    public String displayName(){
        WebElement dispName = driver.findElement(dName);
        return dispName.getText();
    }
    public String createdByName(){
        WebElement crtBy = driver.findElement(cBName);
        return crtBy.getText();
    }
    public String projectNameInHeading(){
        WebElement nHead = driver.findElement(pNameInHeading);
        return nHead.getText();
    }
    public String projectNameInDetails(){
        WebElement nDetails = driver.findElement(pNameInDetails);
        return nDetails.getText();
    }
    public void clickProject() {
        driver.findElement(pp).click();

    }
}
