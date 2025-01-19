package testfile;

import org.testng.Assert;
import org.testng.annotations.Test;

import classfile.AdminUsersPage;
import classfile.HomePage;
import classfile.LoginPage;

public class AdminUserTest extends Base{
	HomePage home;
	AdminUsersPage admin;
	
  @Test
  public void newAdminUserCreation() {
	  LoginPage login=new LoginPage(driver);
	  login.enterUsernameOnField("admin").enterPasswordOnField("admin");
	 home= login.clickOnSignInButton();
	admin= home.adminsUserClick();
	admin.newClick().enterUsernameOnField("argjjssxdcfvgjsnsbs").enterPasswordOnField("dffffdcfvbvcxdfghgvc").userTypeDropdown().clickOnSaveButton();
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