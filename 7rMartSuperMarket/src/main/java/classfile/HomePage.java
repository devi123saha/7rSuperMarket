package classfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import classfile.HomePage;

public class HomePage {
	public WebDriver driver;
	  public HomePage(WebDriver driver)	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="(//a[@class='nav-link'])[2]") private WebElement  logoutclick;
@FindBy(xpath="(//a[@class='dropdown-item'])[2]") private WebElement clickonlogoutbutton;
@FindBy(xpath="(//a[@class='small-box-footer'])[1]") private WebElement adminUserClick;
@FindBy(xpath="(//a[@class='small-box-footer'])[8]") private WebElement manageProductsClick;
@FindBy(xpath="(//a[@class='small-box-footer'])[9]") private WebElement managenewsClick;




public AdminUsersPage adminsUserClick() {
	adminUserClick.click();
	return new AdminUsersPage(driver);
	
}

public ManageProduct manageProductClick() {
	
	manageProductsClick.click();
	return new ManageProduct(driver);
}

public ManageNews clickOnManageNews() {
	
	managenewsClick.click();
	return new ManageNews(driver);
	
}

public HomePage logout() {
	logoutclick.click();
	clickonlogoutbutton.click();
	return this;






}

}