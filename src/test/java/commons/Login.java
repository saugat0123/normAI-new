package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class Login extends BaseClass {

	public void userLogin(String em, String pass) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(em);
		loginPage.clickContinue();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		loginPage.enterPassword(pass);
		loginPage.clickContinue();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Select an Organization')]")));
		loginPage.selectOrg();
		System.out.println("Reached here!");
		wait.until(ExpectedConditions.urlContains("https://app.norm.ai/projects"));
	}

}
