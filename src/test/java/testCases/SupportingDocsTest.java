package testCases;


import commons.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SupportingDocsPage;
import utilities.ReadXlSData;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SupportingDocsTest extends BaseClass {
    public List<String> getAllFilesPath() throws NoSuchMethodException, IOException {
        ReadXlSData rd = new ReadXlSData();
        int columnToExtract = 0; // 0-based index
        List<String> extractedColumn = new ArrayList<>();
        Method method = SupportingDocsTest.class.getMethod("UploadSupportingDocsTest");
        String[][] data = rd.getData(method);
        for (String[] row : data) {
            if (columnToExtract < row.length) {
                extractedColumn.add(row[columnToExtract]);
            }
        }
        return extractedColumn;
    }

    @Test
    public void UploadSupportingDocsTest() throws InterruptedException, IOException, NoSuchMethodException {

        LoginPage loginPage = new LoginPage(driver);
        SupportingDocsPage sp = new SupportingDocsPage(driver);

        loginPage.continueWithEmail();
        loginPage.enterEmail("saugat.dahal@bitskraft.com");
        loginPage.enterPassword("Hello123!");
        loginPage.clickContinue();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.urlToBe(loginPage.expectedURL));
        Thread.sleep(5000);

        sp.openProject("rty");
        Thread.sleep(5000);
        sp.clickSuppTab();
        for (int i = 0; i< getAllFilesPath().size(); i++) {
            System.out.println(getAllFilesPath().get(i));
            WebElement sel = driver.findElement(By.xpath("//input[@type='file']"));
            sel.sendKeys(getAllFilesPath().get(i));
            Thread.sleep(2000);
            sp.clickUpload();
            Thread.sleep(5000);
        }
    }
}
