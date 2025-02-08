package testfile;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import classfile.CategoryPage;
import classfile.HomePage;
import classfile.LoginPage;
import constants.Constants;

public class CategoryTest extends Base {
	HomePage home;
	CategoryPage category;

	@Test(retryAnalyzer = retry.Retry.class)

	public void verifyNewCategoryCreaation() throws AWTException {
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnField("admin").enterPasswordOnField("admin");
		home = login.clickOnSignInButton();
		category = home.categoryclick();
		category.chooseFileClick().enterCategoryNameOnField("Devika");
		category.radioSelectOfTopMenu().radioSelectOfSideMenu().saveButtonClick();
		

	}
}
