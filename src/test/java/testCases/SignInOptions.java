package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import commons.BaseClass;
import pages.SignInOptionsPage;

public class SignInOptions extends BaseClass{
	
	@Test
	public void SignInOptionsTest() {
		
		SignInOptionsPage signInOptionsPage = new SignInOptionsPage(driver);
		
		signInOptionsPage.continueWithEmail();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(signInOptionsPage.isLogin()));
		Assert.assertTrue(signInOptionsPage.isLogin().isDisplayed(), "Login page is loaded successfully");
	}

}
