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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		loginPage.enterPassword(pass);
		loginPage.clickContinue();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Select an Organization')]")));
		loginPage.selectOrg();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/projects/start?refresh=true']")));
	}

}
