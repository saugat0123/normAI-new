package testCases;

import commons.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.SupportingDocsPage;

import java.io.IOException;

public class test extends BaseClass {

    @Test
    public void checkUpload() throws IOException, NoSuchMethodException, InterruptedException {
        SupportingDocsPage spp = new SupportingDocsPage(driver);
        SupportingDocs ss = new SupportingDocs();

        driver.get("https://demo.automationtesting.in/FileUpload.html");

        for (int i = 0; i< ss.getAllFilesPath().size(); i++) {
//            System.out.println(ss.getAllFilesPath().get(i));
            WebElement sel = driver.findElement(By.xpath("//input[@id='input-4']"));
            sel.sendKeys(ss.getAllFilesPath().get(i));
//            sp.selectFile(getAllFilesPath().get(i));
//            Thread.sleep(2000);

            Thread.sleep(5000);
        }



    }
}
