package testfile;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import classfile.AdminUsersPage;
import classfile.HomePage;
import classfile.LoginPage;
import constants.Constants;
import utilities.ExcelUtility;
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
  public void verifyUserAbleToEditUserDetails() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		admin = home.adminsUserClick();
		String newUsername = ExcelUtility.readStringData(4, 0, "LoginPage");
		String newPassword = ExcelUtility.readIntegerData(4, 1, "LoginPage");
		admin.clickOnSaveButton().editUsernameField(newUsername).editPasswordField(newPassword).clickOnUpdateButton();
		boolean statusMessage = admin.isEditSuccessfulMessageDisplayed();
		Assert.assertTrue(statusMessage, Constants.ERRORMESSAGRFORUNSUCCESSFULADMINUSERDETAILS);
	}
}