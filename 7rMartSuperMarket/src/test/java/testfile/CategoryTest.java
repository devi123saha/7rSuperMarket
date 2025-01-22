package testfile;

import org.testng.annotations.Test;

import classfile.CategoryPage;
import classfile.HomePage;
import classfile.LoginPage;
import constants.Constants;

public class CategoryTest extends Base{
	HomePage home;
	CategoryPage category;
	
  @Test
  
  public void verifyNewCategoryCreaation(){
	  LoginPage login = new LoginPage(driver);
		login.enterUsernameOnField("admin").enterPasswordOnField("admin");
		home = login.clickOnSignInButton();
		category= home.categoryclick();
		category.clickNew().enterCategoryName("Devika");
		category.showOnTopMenu().showOnleftpMenu().clickSave();
		
		
		
  }
}
