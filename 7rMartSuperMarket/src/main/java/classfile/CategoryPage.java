package classfile;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class CategoryPage {
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	public CategoryPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") private WebElement clickNew;
	 @FindBy(xpath="//input[@id='category']") private WebElement enterCategoryName;
	 @FindBy(xpath="//input[@id='main_img']") private WebElement clickFileUpload;
	@FindBy(xpath="//input[@name='top_menu'][1]") private WebElement showOnTopMenu;
	@FindBy(xpath="//input[@name='show_home'][1]") private WebElement  showOnleftMenu;
	@FindBy(xpath="//button[@class='btn btn-danger']") private WebElement  clickSave;
	 
	





	 public CategoryPage clickNew() {
		 clickNew.click();
		 return this;
	}
	 
	 public CategoryPage enterCategoryName(String category) {
		 enterCategoryName.sendKeys(category);
		 return this;
	 }
    
	 public CategoryPage clickFileUpload() throws AWTException {
		 wait.waitForELementClick(driver, clickFileUpload);
		 FileUploadUtility file = new FileUploadUtility();
		 file.roboKeysForFileUpload(clickFileUpload, Constants.PDFFILE);
		 return this;
	 }
	 
	 public CategoryPage showOnTopMenu() {
		 showOnTopMenu.click();
		 return this;
	 }
      
	 public CategoryPage showOnleftpMenu() {
		 showOnleftMenu.click();
		 return this;
	 }
	 public CategoryPage clickSave() {
		 clickSave.click();
		 return this;
	 }
	 
	 




}