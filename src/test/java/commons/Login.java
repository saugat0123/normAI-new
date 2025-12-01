package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;
import java.util.Date;

public class Login extends BaseClass {

	public void userLogin(String em, String pass) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(em);
		loginPage.clickContinue();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		loginPage.enterPassword(pass);
		loginPage.clickContinue();
//		Thread.sleep(10);
//		driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Select an Organization')]")));
		WebElement aa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[1]")));
//		loginPage.selectOrg();
		aa.click();
		System.out.println("Logged in!");
		wait.until(ExpectedConditions.urlContains("https://app.norm.ai/projects"));
	}

}
