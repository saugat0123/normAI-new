package testCases;

import commons.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CreateProjectPage;
import pages.LoginPage;

import java.time.Duration;

public class ScrollDocumentTest extends BaseClass {

//    @Test(dataProviderClass = ReadXlSData.class, dataProvider = "testdata")
    @Test
    public void ScrollDoc() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        CreateProjectPage cpp = new CreateProjectPage(driver);

        loginPage.continueWithEmail();
        loginPage.enterEmail("saugat.dahal@bitskraft.com");
        loginPage.enterPassword("Hello123!");
        loginPage.clickContinue();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe(loginPage.expectedURL));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cpp.pp));
        cpp.clickProject();
        Thread.sleep(6000);
        cpp.scrollDownPdf();

    }
}
