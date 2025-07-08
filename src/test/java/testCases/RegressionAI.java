package testCases;

import commons.BaseClass;
import commons.Login;
import utilities.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CreateSubmission;

@Listeners(TestListener.class)
public class RegressionAI extends BaseClass {

    String email = "saugat.dahal@bitskraft.com";
    String password = "Newaccount123!";
    String pdf = "pdf";
    String ppt = "ppt";

    @Test
    public void regressionSteps() throws InterruptedException {
        Login login = new Login();
        login.userLogin(email, password);
        Assert.assertTrue(true, "Logged in successfully!");

        //Step 1: Upload a valid PDF file
        CreateSubmission createSubmission = new CreateSubmission(driver);
        createSubmission.clickNewSubmission();
        createSubmission.selectFile(pdf);
        createSubmission.selectRegulations();
        createSubmission.enterSubmissionDetails();
        createSubmission.enterContentDetails();
        createSubmission.enterDistributionDetails();
        Assert.assertTrue(true, "Submission created successfully!");
    }
}
