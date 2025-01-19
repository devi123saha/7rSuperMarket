package classfile;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import utilities.WaitUtility;
import classfile.LoginPage;

public class LoginPage {
	public WebDriver driver;
	  public LoginPage(WebDriver driver)	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	  @FindBy(name="username") private WebElement usernameField;
	  @FindBy(name="password") private WebElement passwordField;
	  @FindBy(xpath="//button[@type='submit']") private WebElement signInClick;
	  @FindBy(xpath="//li[text()='Dashboard']") private WebElement dashboard;
	  @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") private WebElement alert;
	  
	  
	  
	  
	  public LoginPage enterUsernameOnField(String username) {
		  usernameField.sendKeys(username);
		  return this;
	  }
	  
	  public LoginPage enterPasswordOnField(String password) {
		  passwordField.sendKeys(password);
		  return this;
	  
	  }
	  
	  
	 public HomePage clickOnSignInButton() {
		 WaitUtility waitutility = new WaitUtility();
		 waitutility.waitForELementClick(driver, signInClick);
		 signInClick.click();
		 return new HomePage(driver);
	 }
	  
	 public boolean isDashboardIsLoaded() {
		 return dashboard.isDisplayed();
	 }
	 public boolean isAlertDisplayed() {
		 return alert.isDisplayed();
	 }
	  
	  
	  
	  
	  
	  

}