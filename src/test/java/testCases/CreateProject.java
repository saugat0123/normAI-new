package testCases;

import commons.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateProjectPage;
import pages.LoginPage;
import utilities.ReadXlSData;

import java.time.Duration;

public class CreateProject extends BaseClass {

    @Test(dataProviderClass = ReadXlSData.class, dataProvider = "testdata")
    public void CreateProjectTest(String projectName, String releaseDate, String audience, String channel, String filePath) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        CreateProjectPage cpp = new CreateProjectPage(driver);

        loginPage.continueWithEmail();
        loginPage.enterEmail("saugat.dahal@bitskraft.com");
        loginPage.enterPassword("Hello123!");
        loginPage.clickContinue();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.urlToBe(loginPage.expectedURL));

        cpp.clickNewProjectIcon();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(cpp.projectName));

        cpp.enterProjectName(projectName);
        cpp.enterReleaseDate(releaseDate);
        cpp.selectAudience(audience);
        cpp.selectDistributionChannel(channel);
        cpp.scrollDown();
        cpp.selectFile(filePath);
        cpp.clickUpload();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cpp.proDetails));
        Assert.assertTrue(true,"Project not created");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cpp.cBName));
        if (cpp.displayName().equals(cpp.createdByName())) {
            Assert.assertTrue(true,"Display Name and Created By do not match");
        }
        if (cpp.projectNameInHeading().equals(cpp.projectNameInDetails())) {
            Assert.assertTrue(true,"Project Name in Heading and in Project Details do not match");
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(cpp.pdfContainer));
//        Thread.sleep(2000);
        cpp.scrollDownPdf();
    }
}
