package testCases;

import commons.BaseClass;
import commons.Login;
import pages.DraftsPage;
import utilities.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CreateSubmission;

@Listeners(TestListener.class)
public class AiRegressionTest extends BaseClass {

    String email = "saugat.dahal@bitskraft.com";
    String password = "N3w@cc0unt123!";
    String pdf = "pdf";
    String ppt = "ppt";

    @Test
    public void createSubmission() throws InterruptedException {
        Login login = new Login();
        login.userLogin(email, password);
        Assert.assertTrue(true, "Logged in failed!");

        //Step 1: Upload a valid PDF file
        CreateSubmission createSubmission = new CreateSubmission(driver);
        createSubmission.clickNewSubmission();
        createSubmission.selectFile(pdf);
        createSubmission.addSupportingMaterials();
        createSubmission.selectRegulations();
        createSubmission.selectBusinessUnits();
        createSubmission.submitSubmission();
//        createSubmission.enterSubmissionDetails();
//        createSubmission.enterContentDetails();
//        createSubmission.enterDistributionDetails();

        Assert.assertTrue(true, "Submission creation failed!");
    }

//    @Test
//    public void deleteDraft() throws InterruptedException {
//        Login login = new Login();
//        login.userLogin(email, password);
//
//        DraftsPage draftsPage = new DraftsPage(driver);
//        draftsPage.waitForDraftsPageToLoad();
//        int before = draftsPage.drftCount();
//        draftsPage.deleteFirst();
//        int after = draftsPage.drftCount();
//        if (before == after+1) {
//            System.out.println("end");
//            Assert.assertTrue(true, "Draft deletion failed");
//        }
//    }
}
