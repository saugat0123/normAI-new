package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Action;
import utilities.Wait;

import java.time.Duration;
import java.util.Date;
import java.util.Random;

public class CreateSubmission {

    WebDriver driver;


    public CreateSubmission(WebDriver driver) {
        this.driver = driver;
    }

    By sidebar = By.xpath("//button[@data-sidebar=\"trigger\"]");
    By clickNewSub = By.xpath("//span[contains(text(),'New Submission')]");
    By selectFileArea = By.xpath("//input[@type='file']");
    By getStarted = By.xpath("//button[contains(text(),'Get Started')]");
    By selectRegulationsLabel = By.xpath("//label[contains(text(),'Select Regulations')]");
    By finra = By.xpath("//div[contains(text(),'FINRA 2210')]");
    By sec = By.xpath("//div[contains(text(),'SEC Marketing Rule')]");
    By nextBtn = By.xpath("//button[contains(text(),'Next')]");
//    By businessUnit = By.xpath("//div[@class='css-1lx7dxn']");
    By businessUnit = By.xpath("//div[@class='css-14ay5v']");
//    By businessUnit = By.xpath("//svg[@class='css-8mmkcg']");
    By subDetailLabel = By.xpath("//p[contains(text(),'Submission Details')]");
//    By typeOfMarketingMaterial = By.xpath("//p[contains(text(),'" + materialType + "')]");
    By contentDetailsLabel = By.xpath("//p[contains(text(),'Content Details')]");
    By cooApprovedYes = By.xpath("//p[contains(text(),'Yes')]");
    By cooApprovedNo = By.xpath("//p[contains(text(),'No')]");
    By singleDistribution = By.xpath("//p[contains(text(),'Single')]");
    By multipleDistribution = By.xpath("//p[contains(text(),'Multiple')]");
    By comingledFund = By.xpath("//p[contains(text(),'Comingled Fund')]");
    By befm = By.xpath("//p[contains(text(),'BEFM')]");
    By retail = By.xpath("//p[contains(text(),'Retail')]");
    By distributionDetailsLabel = By.xpath("//p[contains(text(),'Distribution Details')]");
    By distributionCountry = By.xpath("//div[@class='css-14ay5v']");
    By bell = By.xpath("//p[contains(text(), 'BELL')]");
    By newContentYes = By.xpath("//p[contains(text(),'Yes')]");
    By nfaApprovalLabel = By.xpath("//div[contains(text(),'S-24/NFA')]");
    By nfaApprovalYes = By.xpath("//p[contains(text(),'Yes')]");
    By nfaApproval2Label = By.xpath("//div[contains(text(),'Have you')]");
    By nfaApproval2Yes = By.xpath("//p[contains(text(),'Yes')]");
    By reqTimingLabel = By.xpath("//div[contains(text(),'Requested timing')]");
    By standardTime = By.xpath("//p[contains(text(),'Standard')]");
    By dateNeededBy = By.xpath("//div[contains(text(),'Date Needed By')]");
    By submit = By.xpath("//button[@type='submit']");
    By subCreated = By.xpath("//p[contains(text(),'Submission Created!')]");
    By subName = By.xpath("//input[@placeholder='Enter a name for this submission']");
    By supportingMaterials = By.xpath("//button[contains(text(),'Add Supporting Materials')]");

    public void clickNewSubmission() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(sidebar));
        new Wait(driver, Duration.ofSeconds(30), sidebar);
        driver.findElement(sidebar).click();
//        Thread.sleep(1000);
        new Wait(driver, Duration.ofSeconds(10), clickNewSub);
        driver.findElement(clickNewSub).click();


    }

    public void selectFile(String ftype) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectFileArea));
        switch (ftype) {
            case "pdf":
                driver.findElement(selectFileArea).sendKeys("D:\\NormAIfiles\\pinetree.pdf");
                break;
            case "ppt":
                driver.findElement(selectFileArea).sendKeys("D:\\NormAIfiles\\ppt.pptx");
                break;
            case "word":
                driver.findElement(selectFileArea).sendKeys("D:\\NormAIfiles\\pinetree.docx");
                break;
        }
        int randomNum = new Random().nextInt(1000);
        new Wait(driver, Duration.ofSeconds(10), subName);
        driver.findElement(subName).sendKeys(""+randomNum);
        new Wait(driver, Duration.ofSeconds(5), supportingMaterials);
    }

    public void addSupportingMaterials() {
        driver.findElement(supportingMaterials).click();
        By upload = By.xpath("//button[contains(text(),\"Upload New File\")]");
        new Wait(driver, Duration.ofSeconds(20), upload);
        driver.findElement(upload).sendKeys("D:\\NormAIfiles\\pinetree.pdf");
        driver.findElement(getStarted).click();
        new Wait(driver, Duration.ofSeconds(30), selectRegulationsLabel);
    }

    public void selectRegulations() {
        driver.findElement(finra).click();
        driver.findElement(nextBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(subDetailLabel));
    }

    public void enterSubmissionDetails() throws InterruptedException {
        String materialType = "Interview";
        driver.findElement(businessUnit).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
//        new Action(driver, Keys.TAB);
//        System.out.println("hellooooo!!!");
        driver.findElement(By.xpath("//p[contains(text(),'" + materialType + "')]")).click();
        driver.findElement(nextBtn).click();
        new Wait(driver, Duration.ofSeconds(20), contentDetailsLabel);
//        System.out.println("Reached here!!!");
    }

    public void selectBusinessUnits() {
        driver.findElement(By.xpath("//p[contains(text(), 'QA')]")).click();
        driver.findElement(By.xpath("//input[@name='fields.review_due_date']")).click();

        Date date = new Date();
        String today = String.valueOf(date);
        String todayDate = today.split(" ")[2];
        int td = Integer.parseInt(todayDate);

        driver.findElement(By.xpath("//button[contains(text(), '"+td+"')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Done')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
        new Wait(driver, Duration.ofSeconds(10), By.xpath("//button[contains(text(), 'Understood')]"));
        driver.findElement(By.xpath("//button[contains(text(), 'Understood')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Next')]")).click();
        new Wait(driver, Duration.ofSeconds(20), subDetailLabel);
    }

    public void enterContentDetails() {
        driver.findElement(cooApprovedYes).click();
        driver.findElement(nextBtn).click();
        new Wait(driver, Duration.ofSeconds(10), singleDistribution);
        driver.findElement(singleDistribution).click();
        driver.findElement(comingledFund).click();
//        driver.findElement(By.xpath("//input[@id='asd']")).click();
        driver.findElement(nextBtn).click();
        new Wait(driver, Duration.ofSeconds(10), befm);
        driver.findElement(befm).click();
        driver.findElement(retail).click();
        driver.findElement(nextBtn).click();
        new Wait(driver, Duration.ofSeconds(10), distributionDetailsLabel);
    }

    public void enterDistributionDetails() {
        driver.findElement(distributionCountry).click();
        new Action(driver, Keys.TAB);
        new Action(driver, Keys.TAB);
        new Action(driver, Keys.TAB);
        new Action(driver, Keys.ESCAPE);
        driver.findElement(nextBtn).click();
        new Wait(driver, Duration.ofSeconds(20), bell);
        driver.findElement(bell).click();
        driver.findElement(newContentYes).click();
        driver.findElement(nextBtn).click();
        new Wait(driver, Duration.ofSeconds(20), nfaApprovalLabel);
        driver.findElement(nfaApprovalYes).click();
        driver.findElement(nextBtn).click();
        new Wait(driver, Duration.ofSeconds(20), nfaApproval2Label);
        driver.findElement(nfaApproval2Yes).click();
        driver.findElement(nextBtn).click();
        new Wait(driver, Duration.ofSeconds(20), reqTimingLabel);
        driver.findElement(standardTime).click();
        driver.findElement(nextBtn).click();
        new Wait(driver, Duration.ofSeconds(20), dateNeededBy);
        driver.findElement(submit).click();
        new Wait(driver, Duration.ofSeconds(20), subCreated);

    }

    public void submitSubmission() {
        new Wait(driver, Duration.ofSeconds(20), By.xpath("(//*[contains(@class, 'formdropdown')])[1]"));
        WebElement intendedAudience = driver.findElement(By.xpath("(//*[contains(@class, 'formdropdown')])[1]"));
        intendedAudience.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
        WebElement distributionChannel = driver.findElement(By.xpath("(//*[contains(@class, 'formdropdown')])[2]"));
        distributionChannel.click();
        actions.sendKeys(Keys.TAB).perform();
        driver.findElement(By.xpath("//p[contains(text(), 'Website')]")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test");
        driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
        new Wait(driver, Duration.ofSeconds(20), By.xpath("//button[contains(text(), 'View submission')]"));

    }


}
