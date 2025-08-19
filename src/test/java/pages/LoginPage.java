package pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.BaseClass;
import utilities.Wait;

public class LoginPage {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By conWithEmail = By.xpath("//button[normalize-space()='Continue with Email']");
//	By isLoginPage = By.xpath("//button[normalize-space()='Back to options']");
	By enterEmail = By.xpath("//input[@id='username']");
	By enterPassword = By.xpath("//input[@id='password']");
	By login = By.xpath("//button[@type='submit']");
	By logo = By.xpath("//img[@alt='Norm Ai Logo']");
	By invalidEmailmsg = By.xpath("//p[normalize-space()='Invalid email address']");
	By charLimit = By.xpath("//p[normalize-space()='Needs at least 8 characters']");
	By capitalLetter = By.xpath("//p[normalize-space()='Needs a capital letter']");
	By specialChar = By.xpath("//p[normalize-space()='Needs a special character']");
	By numberMust = By.xpath("//p[normalize-space()='Needs a number']");
	By emailReq = By.xpath("//p[normalize-space()='Email is required']");
	By passReq = By.xpath("//p[normalize-space()='Password is required']");
	By continuee = By.xpath("//button[contains(text(),'Continue')]");
	By selectAIorg = By.xpath("//button[contains(text(),'Bitskraft QA')]");

	public String expectedURL = "https://app.norm.ai/projects";

	public void continueWithEmail() {
		driver.findElement(conWithEmail).click();
	}
	
	public void enterEmail(String email) {
		new Wait(driver, Duration.ofSeconds(20), enterEmail);
		driver.findElement(enterEmail).click();
        driver.findElement(enterEmail).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		driver.findElement(enterPassword).click();
        driver.findElement(enterPassword).sendKeys(password);
	}
	
	public void clickContinue() {
		driver.findElement(continuee).click();
	}
	
	public WebElement logo() {
		return driver.findElement(logo);
	}
	
	public WebElement invalidEmail() {
		return driver.findElement(invalidEmailmsg);
	}
	
	public WebElement characterLimit() {
		return driver.findElement(charLimit);
	}
	
	public WebElement noCapitalLetter() {
		return driver.findElement(capitalLetter);
	}
	
	public WebElement numberIsMust() {
		return driver.findElement(numberMust);
	}
	
	public WebElement emailRequired() {
		return driver.findElement(emailReq);
	}
	
	public WebElement passRequired() {
		return driver.findElement(passReq);
	}
	
	public WebElement specialChar() {
		return driver.findElement(specialChar);
	}

	public void selectOrg() {
		driver.findElement(selectAIorg).click();
	}
	
}
