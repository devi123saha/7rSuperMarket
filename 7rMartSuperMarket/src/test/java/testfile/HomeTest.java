package testfile;

import org.testng.annotations.Test;

import classfile.HomePage;
import classfile.LoginPage;

public class HomeTest extends Base {
	HomePage home;

	@Test
	public void verifyUserIsAbletoLogOut() {
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnField("admin").enterPasswordOnField("admin");
		home = login.clickOnSignInButton();
		home.logout();

	}
}