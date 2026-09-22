package FINALASSESSMENT;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.WebDriverWait;

public class OHRMLOGINPAGE {
	WebDriver driver;

	WebDriverWait wait;
	
	public OHRMLOGINPAGE(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement usernametf;
	
	@FindBy(name="password")
	private WebElement passwordtf;
	
	@FindBy(xpath="//button[text()=' Login ']")
	private WebElement loginButton;

	public void getUsernametf(String value) {
		wait.until(ExpectedConditions.visibilityOf(usernametf));
		usernametf.sendKeys(value);
	}

	public void getPasswordtf(String value) {
		wait.until(ExpectedConditions.visibilityOf(passwordtf));
		passwordtf.sendKeys(value);
	}

	public void getLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
	}
		

}
