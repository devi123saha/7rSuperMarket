package classfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageProduct {
	 
			public WebDriver driver;
			  public ManageProduct(WebDriver driver)	{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			  
			  @FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") private WebElement searchClick;
				@FindBy(xpath="(//input[@type='text'])[1]") private WebElement title;
				@FindBy(xpath="(//input[@type='text'])[2]")private WebElement productCode;
				@FindBy(name="cat_id") private WebElement categoryDropDown;
				@FindBy(xpath="(//select[@class='form-control selectpicker'])[2]") private WebElement subcategory;
				@FindBy(xpath="//button[@class='btn btn-danger btn-fix']") private WebElement searchClickButton;
				@FindBy(xpath="//th[text()='Image']") private WebElement imageDisplay;
				
				
				
				
				
				
				public ManageProduct searchClick() {
					searchClick.click();
					return this;
					
				}
			public ManageProduct enterTitleOnTitleField(String titlename) {
				title.sendKeys(titlename);
				return this;
			}
			public ManageProduct enterProductCodeOnField(String code) {
				productCode.sendKeys(code);
				return this;
				
			}
			public ManageProduct selectCategoryDropdown() {
				Select select=new Select(categoryDropDown);
				select.selectByIndex(2);
				return this;
			}
			public ManageProduct selectSubcategoryDropDown() {
				Select select1=new Select(subcategory);
				select1.selectByIndex(2);
				return this;	
			}
			public ManageProduct clickOnSearchButton() {
				searchClickButton.click();
				return this;
				
			}
			public boolean isImageDisplayed() {
				return imageDisplay.isDisplayed();
			}










			}