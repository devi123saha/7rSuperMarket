package testfile;

import org.testng.Assert;
import org.testng.annotations.Test;

import classfile.AdminUsersPage;
import classfile.HomePage;
import classfile.LoginPage;
import utilities.FakerUtility;

public class AdminUserTest extends Base{
	HomePage home;
	AdminUsersPage admin;
	FakerUtility faker = new FakerUtility();
	
  @Test
  public void newAdminUserCreation() {
	  LoginPage login=new LoginPage(driver);
	  login.enterUsernameOnField("admin").enterPasswordOnField("admin");
	 home= login.clickOnSignInButton();
	admin= home.adminsUserClick();
	String usernamefield = faker.getFakeFirstName();
	String passwordfield = faker.getPassword();
	admin.newClick().enterUsernameOnField(usernamefield).enterPasswordOnField(passwordfield).userTypeDropdown().clickOnSaveButton();
	boolean alertMessage=admin.isAlertDisplayed();
	Assert.assertTrue(alertMessage, "new user creation is unsuccessful");
	 }
  @Test
  public void searchUser() {
	  LoginPage login=new LoginPage(driver);
	  login.enterUsernameOnField("admin").enterPasswordOnField("admin");
	 home= login.clickOnSignInButton();
	admin= home.adminsUserClick();
	admin.clickOnSearchButton().enterNameOnSearchNameField("athiraa").selectUsertypeDropDown().clickOnUserSearchButton();
	  
	  
	  
  }
}