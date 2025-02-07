package testfile;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import classfile.HomePage;
import classfile.LoginPage;
import constants.Constants;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage home;

	@Test(dataProvider = "credentials")

	public void verifyCorrectUsernameAndPassword(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		boolean isHomepageIsLoaded = login.isDashboardIsLoaded();
		Assert.assertTrue(isHomepageIsLoaded, Constants.ERRORMESSAGEFORLOGIN);

	}

	@Test
	@Parameters({ "username", "password" })
	public void verifyInvalidUsernameAndCorrectPassword(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		login.clickOnSignInButton();
		boolean isAlertLoaded = login.isAlertDisplayed();
		Assert.assertTrue(isAlertLoaded, Constants.ERRORMESSAGEFORLOGIN);

	}

	@Test(groups = { "smoke" })
	public void verifyCorrectUsernameAndInvalidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readIntegerData(1, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		login.clickOnSignInButton();
		boolean isAlertLoaded = login.isAlertDisplayed();
		Assert.assertTrue(isAlertLoaded, Constants.ERRORMESSAGEFORLOGIN);

	}

	@Test(groups = { "smoke" })
	public void verifyInvalidUsernameAndPassword() {
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnField("adminss").enterPasswordOnField("123");
		login.clickOnSignInButton();
		String expected = "Login | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual, Constants.ERRORMESSAGEFORLOGIN);

	}

	@DataProvider(name = "credentials")
	public Object[][] testData() {
		Object data[][] = { { "admin", "admin" } };
		return data;

	}

}