package classfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews {
	public WebDriver driver;

	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newClick;
	@FindBy(xpath = "//textarea[@name='news']")
	private WebElement enterNews;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessagee;

	public ManageNews ClickOnNewButton() {
		newClick.click();
		return this;

	}

	public ManageNews enterNewsOnField(String message) {
		enterNews.sendKeys(message);
		return this;
	}

	public ManageNews clickOnSaveButton() {
		saveButton.click();
		return this;

	}

	public boolean isAlertMessageDisplayed() {
		return alertMessagee.isDisplayed();

	}

}